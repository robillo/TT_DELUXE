package com.firstapp.robinpc.tongue_twisters_deluxe.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Twister(
        @PrimaryKey @SerializedName("index") val id: Int,
        @SerializedName("title") val name: String,
        @SerializedName("twister") val twister: String,
        @SerializedName("length") val length: Int,
        @SerializedName("difficulty") val difficulty: Int,
        @SerializedName("icon_url") val iconUrl: String,
        @SerializedName("hint") val hint: String,
        @SerializedName("is_locked") val isLocked: Boolean
) {

    companion object {
        const val DEFAULT_INT = 0
        const val DEFAULT_STRING = "DEFAULT"
        const val DEFAULT_BOOLEAN = false
    }
    constructor(): this(
            DEFAULT_INT,
            DEFAULT_STRING,
            DEFAULT_STRING,
            DEFAULT_INT,
            DEFAULT_INT,
            DEFAULT_STRING,
            DEFAULT_STRING,
            DEFAULT_BOOLEAN
    )
}