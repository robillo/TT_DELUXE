package com.firstapp.robinpc.tongue_twisters_deluxe.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.firstapp.robinpc.tongue_twisters_deluxe.data.dao.DifficultyLevelDao
import com.firstapp.robinpc.tongue_twisters_deluxe.data.dao.LengthLevelDao
import com.firstapp.robinpc.tongue_twisters_deluxe.data.dao.TwisterDao
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.DifficultyLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.LengthLevel
import com.firstapp.robinpc.tongue_twisters_deluxe.data.model.Twister

@Database(entities = [Twister::class, DifficultyLevel::class, LengthLevel::class], version = 1, exportSchema = false)
abstract class TwisterDatabase: RoomDatabase() {

    abstract fun twisterDao(): TwisterDao
    abstract fun lengthLevelDao(): LengthLevelDao
    abstract fun difficultyLevelDao(): DifficultyLevelDao

}