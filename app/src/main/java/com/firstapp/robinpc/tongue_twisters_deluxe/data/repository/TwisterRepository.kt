package com.firstapp.robinpc.tongue_twisters_deluxe.data.repository

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.firstapp.robinpc.tongue_twisters_deluxe.data.dao.TwisterDao
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister

class TwisterRepository(private val twisterDao: TwisterDao) {

    fun getAllTwisters(): LiveData<List<Twister>> {
        return twisterDao.getAllTwisters()
    }

    fun getTwisterForIndex(index: Int): LiveData<Twister> {
        return twisterDao.getTwisterForIndex(index)
    }

    fun getTwisterCount(): LiveData<Int> {
        return twisterDao.getTwisterCount()
    }

    fun insertTwisters(vararg twister: Twister) {
        InsertTwistersTask(twisterDao).execute(*twister)
    }

    fun getDatabaseElementsCount(): LiveData<Int> {
        return twisterDao.getDatabaseElementsCount()
    }

    private class InsertTwistersTask internal constructor(private val dao: TwisterDao) : AsyncTask<Twister, Void, Void>() {

        override fun doInBackground(vararg params: Twister): Void? {
            dao.insertTwisters(*params)
            return null
        }
    }
}