@file:Suppress("unused")

package com.firstapp.robinpc.tongue_twisters_deluxe.ui.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.database.TwisterDatabase
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.LengthLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.data.repository.DifficultyRepository
import com.firstapp.robinpc.tongue_twisters_deluxe.data.repository.LengthRepository
import com.firstapp.robinpc.tongue_twisters_deluxe.data.repository.TwisterRepository
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.ALL_TWISTERS
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.CHARSET_UTF_8
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.DIFFICULTY_LEVEL_COUNT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.LENGTH_LEVEL_COUNT
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.LEVELS_BY_DIFFICULTY
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.LEVELS_BY_LENGTH
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.TWISTER_COUNT
import com.google.gson.Gson
import kotlinx.coroutines.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.nio.charset.Charset
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SplashViewModel @Inject constructor(
        database: TwisterDatabase,
        private val gson: Gson,
        private val inputStream: InputStream
): ViewModel() {

    private lateinit var completeJsonObject: JSONObject

    private var lengthJsonArray: JSONArray? = null
    private var twisterJsonArray: JSONArray? = null
    private var difficultyJsonArray: JSONArray? = null

    private var twisterArray: Array<Twister> = Array(TWISTER_COUNT) { Twister() }
    private var lengthArray: Array<LengthLevel> = Array(LENGTH_LEVEL_COUNT) { LengthLevel() }
    private var difficultyArray: Array<DifficultyLevel> = Array(DIFFICULTY_LEVEL_COUNT) { DifficultyLevel() }

    private val twisterRepo = TwisterRepository(database.twisterDao())
    private val lengthLevelRepo = LengthRepository(database.lengthLevelDao())
    private val difficultyLevelRepo = DifficultyRepository(database.difficultyLevelDao())

    private val job: CompletableJob = Job()
    private val context: CoroutineContext = Dispatchers.IO + job
    private val scope: CoroutineScope = CoroutineScope(context)

    private val _jsonStringLiveData = MutableLiveData<String>()
    val jsonStringLiveData: LiveData<String>
        get() = _jsonStringLiveData

    private val _loadProgressLiveData = MutableLiveData<String>()
    val loadProgressLiveData: LiveData<String>
        get() = _loadProgressLiveData

    companion object {
        enum class Progress {
            JSON_LOADED, ARRAYS_CONVERTED, DATA_STORED
        }
    }

    fun fetchJsonFromAssets() {
        scope.launch {
            withContext(context) {
                inflateParentJson()
                inflateChildrenArrays()
            }
            _loadProgressLiveData.postValue(Progress.JSON_LOADED.name)
        }
    }

    private fun inflateParentJson() {
        val buffer: ByteArray = getBuffer()
        completeJsonObject = JSONObject(String(buffer, Charset.forName(CHARSET_UTF_8)))
    }

    private fun getBuffer(): ByteArray {
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        return buffer
    }

    private fun inflateChildrenArrays() {
        twisterJsonArray = getJsonArrayForName(ALL_TWISTERS)
        lengthJsonArray = getJsonArrayForName(LEVELS_BY_LENGTH)
        difficultyJsonArray = getJsonArrayForName(LEVELS_BY_DIFFICULTY)
    }

    fun convertArrays() {
        scope.launch {
            withContext(context) {
                convertLengthArray()
                convertTwisterArray()
                convertDifficultyArray()
            }
            _loadProgressLiveData.postValue(Progress.ARRAYS_CONVERTED.name)
        }
    }

    private fun convertLengthArray() {
            for(index: Int in 0 until lengthJsonArray!!.length())
                lengthArray[index] = gson.fromJson(lengthJsonArray!!.getJSONObject(index).toString(), LengthLevel::class.java)
    }

    private fun convertTwisterArray() {
        for(index: Int in 0 until twisterJsonArray!!.length())
            twisterArray[index] = gson.fromJson(twisterJsonArray!!.getJSONObject(index).toString(), Twister::class.java)
    }

    private fun convertDifficultyArray() {
        for(index: Int in 0 until difficultyJsonArray!!.length())
            difficultyArray[index] = gson.fromJson(difficultyJsonArray!!.getJSONObject(index).toString(), DifficultyLevel::class.java)
    }

    fun insertListsIntoRoom() {
        scope.launch {
            withContext(context) {
                insertTwisterList()
                insertLengthList()
                insertDifficultyList()
            }
            _loadProgressLiveData.postValue(Progress.DATA_STORED.name)
        }
    }

    fun checkIfRoomFilled() {
        scope.launch {
            withContext(context) {
                getTwisterCount()
                getLengthLevelCount()
                getDifficultyLevelCount()
            }
            //TODO - post true or false for room data presence
        }
    }

    private fun insertTwisterList() {
        insertTwisters(*twisterArray)
    }

    private fun insertLengthList() {
        insertLengthLevels(*lengthArray)
    }

    private fun insertDifficultyList() {
        insertDifficultyLevels(*difficultyArray)
    }

    private fun getJsonArrayForName(name: String): JSONArray {
        return completeJsonObject.getJSONArray(name)
    }

    fun getAllTwisters(): LiveData<List<Twister>> {
        return twisterRepo.getAllTwisters()
    }

    private fun getTwisterCount(): LiveData<Int> {
        return twisterRepo.getTwisterCount()
    }

    private fun insertTwisters(vararg twister: Twister) {
        twisterRepo.insertTwisters(*twister)
    }

    private fun getAllLengthLevels(): LiveData<List<LengthLevel>> {
        return lengthLevelRepo.getAllLengthLevels()
    }

    private fun getLengthLevelCount(): LiveData<Int> {
        return lengthLevelRepo.getLengthLevelCount()
    }

    private fun insertLengthLevels(vararg lengthLevel: LengthLevel) {
        lengthLevelRepo.insertLengthLevels(*lengthLevel)
    }

    private fun getAllDifficultyLevels(): LiveData<List<DifficultyLevel>> {
        return difficultyLevelRepo.getAllDifficultyLevels()
    }

    private fun getDifficultyLevelCount(): LiveData<Int> {
        return difficultyLevelRepo.getDifficultyLevelCount()
    }

    private fun insertDifficultyLevels(vararg difficultyLevel: DifficultyLevel) {
        difficultyLevelRepo.insertDifficultyLevels(*difficultyLevel)
    }
}