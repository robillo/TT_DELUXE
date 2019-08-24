package com.firstapp.robinpc.tongue_twisters_deluxe.data.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.firstapp.robinpc.tongue_twisters_deluxe.data.dao.DifficultyLevelDao
import com.firstapp.robinpc.tongue_twisters_deluxe.data.dao.LengthLevelDao
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.LengthLevel

class LengthRepository(private val lengthLevelDao: LengthLevelDao) {

    fun getAllLengthLevels(): LiveData<List<LengthLevel>> {
        return lengthLevelDao.getAllLengthLevels()
    }

    fun getLengthLevelCount(): LiveData<Int> {
        return lengthLevelDao.getLengthLevelCount()
    }

    fun insertLengthLevels(vararg lengthLevel: LengthLevel) {
        InsertLengthLevelsTask(lengthLevelDao).execute(*lengthLevel)
    }

    private class InsertLengthLevelsTask internal constructor(
            private val dao: LengthLevelDao
    ) : AsyncTask<LengthLevel, Void, Void>() {

        override fun doInBackground(vararg params: LengthLevel): Void? {
            dao.insertLengthLevels(*params)
            return null
        }
    }
}