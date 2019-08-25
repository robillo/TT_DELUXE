package com.firstapp.robinpc.tongue_twisters_deluxe.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel

@Dao
interface DifficultyLevelDao {

    @Query("SELECT * FROM difficultylevel")
    fun getAllDifficultyLevels(): LiveData<List<DifficultyLevel>>

    @Query("SELECT count(title) FROM difficultylevel")
    fun getDifficultyLevelCount(): LiveData<Int>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDifficultyLevels(vararg difficultyLevel: DifficultyLevel)
}