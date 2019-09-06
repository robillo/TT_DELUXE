package com.firstapp.robinpc.tongue_twisters_deluxe.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister

@Dao
interface TwisterDao {

    @Query("SELECT * FROM twister")
    fun getAllTwisters(): LiveData<List<Twister>>

    @Query("SELECT * FROM twister WHERE id = :index")
    fun getTwisterForIndex(index: Int): LiveData<Twister>

    @Query("SELECT count(id) FROM twister")
    fun getTwisterCount(): LiveData<Int>
    
    @Query("SELECT (SELECT count(*) FROM twister) + (SELECT count(*) FROM lengthlevel) + (SELECT count(*) FROM difficultylevel)")
    fun getDatabaseElementsCount(): LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTwisters(vararg params: Twister)
}