package com.firstapp.robinpc.tongue_twisters_deluxe.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.DEFAULT_STRING
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.DEFAULT_VALUE_INT
import com.google.gson.annotations.SerializedName

@Entity
data class DifficultyLevel(
        @PrimaryKey @SerializedName("title") val title: String,
        @SerializedName("expanded_title") val expandedTitle: String,
        @SerializedName("level_tip") val levelTip: String,
        @SerializedName("start_index") val startIndex: Int,
        @SerializedName("end_index") val endIndex: Int,
        @SerializedName("count") val count: Int
): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt()) {
    }

    constructor(): this(
            DEFAULT_STRING,
            DEFAULT_STRING,
            DEFAULT_STRING,
            DEFAULT_VALUE_INT,
            DEFAULT_VALUE_INT,
            DEFAULT_VALUE_INT
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(expandedTitle)
        parcel.writeString(levelTip)
        parcel.writeInt(startIndex)
        parcel.writeInt(endIndex)
        parcel.writeInt(count)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DifficultyLevel> {
        override fun createFromParcel(parcel: Parcel): DifficultyLevel {
            return DifficultyLevel(parcel)
        }

        override fun newArray(size: Int): Array<DifficultyLevel?> {
            return arrayOfNulls(size)
        }
    }
}