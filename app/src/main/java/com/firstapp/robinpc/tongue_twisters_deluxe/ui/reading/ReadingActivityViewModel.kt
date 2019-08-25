package com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.database.TwisterDatabase
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.LengthLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.data.repository.DifficultyRepository
import com.firstapp.robinpc.tongue_twisters_deluxe.data.repository.LengthRepository
import com.firstapp.robinpc.tongue_twisters_deluxe.data.repository.TwisterRepository
import com.google.gson.Gson
import java.io.InputStream
import javax.inject.Inject

@Suppress("unused")
class ReadingActivityViewModel @Inject constructor(
        database: TwisterDatabase,
        private val gson: Gson,
        private val inputStream: InputStream
): ViewModel() {

    private val twisterRepo = TwisterRepository(database.twisterDao())
    private val lengthLevelRepo = LengthRepository(database.lengthLevelDao())
    private val difficultyLevelRepo = DifficultyRepository(database.difficultyLevelDao())

    private fun getAllTwisters(): LiveData<List<Twister>> {
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