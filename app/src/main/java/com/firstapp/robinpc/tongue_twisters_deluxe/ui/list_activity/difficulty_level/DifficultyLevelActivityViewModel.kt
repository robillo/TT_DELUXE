package com.firstapp.robinpc.tongue_twisters_deluxe.ui.list_activity.difficulty_level

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.database.TwisterDatabase
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister
import com.firstapp.robinpc.tongue_twisters_deluxe.data.repository.TwisterRepository
import javax.inject.Inject

class DifficultyLevelActivityViewModel @Inject constructor(database: TwisterDatabase): ViewModel() {

    private val twisterRepo = TwisterRepository(database.twisterDao())

    fun getTwistersInRange(startIndex: Int, endIndex: Int): LiveData<List<Twister>> {
        return twisterRepo.getTwistersInRange(startIndex, endIndex)
    }
}