package com.firstapp.robinpc.tongue_twisters_deluxe.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class DifficultyLevel(
        @PrimaryKey @SerializedName("title") val title: String,
        @SerializedName("expanded_title") val expandedTitle: String,
        @SerializedName("level_tip") val levelTip: String,
        @SerializedName("start_index") val startIndex: Int,
        @SerializedName("end_index") val endIndex: Int,
        @SerializedName("count") val count: Int
) {

    companion object {
        const val DEFAULT_INT = 0
        const val DEFAULT_STRING = "DEFAULT"
    }
    constructor(): this(
            DEFAULT_STRING,
            DEFAULT_STRING,
            DEFAULT_STRING,
            DEFAULT_INT,
            DEFAULT_INT,
            DEFAULT_INT
    )
}