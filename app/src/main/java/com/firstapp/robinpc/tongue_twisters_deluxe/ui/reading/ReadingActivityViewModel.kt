package com.firstapp.robinpc.tongue_twisters_deluxe.ui.reading

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.database.TwisterDatabase
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

    fun getTwisterForIndex(index: Int): LiveData<Twister> {
        return twisterRepo.getTwisterForIndex(index)
    }
}