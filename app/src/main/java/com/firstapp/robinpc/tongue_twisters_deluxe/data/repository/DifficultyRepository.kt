package com.firstapp.robinpc.tongue_twisters_deluxe.data.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.firstapp.robinpc.tongue_twisters_deluxe.data.dao.DifficultyLevelDao
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel

class DifficultyRepository(private val dao: DifficultyLevelDao) {

    fun getAllDifficultyLevels(): LiveData<List<DifficultyLevel>> {
        return dao.getAllDifficultyLevels()
    }

    fun getDifficultyLevelCount(): LiveData<Int> {
        return dao.getDifficultyLevelCount()
    }

    fun insertDifficultyLevels(vararg difficultyLevel: DifficultyLevel) {
        InsertDifficultyLevelsTask(dao).execute(*difficultyLevel)
    }

    private class InsertDifficultyLevelsTask internal constructor(
            private val dao: DifficultyLevelDao
    ) : AsyncTask<DifficultyLevel, Void, Void>() {

        override fun doInBackground(vararg params: DifficultyLevel): Void? {
            dao.insertDifficultyLevels(*params)
            return null
        }
    }
}