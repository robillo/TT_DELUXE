package com.firstapp.robinpc.tongue_twisters_deluxe.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.DEFAULT_BOOLEAN
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.DEFAULT_STRING
import com.firstapp.robinpc.tongue_twisters_deluxe.utils.Constants.Companion.DEFAULT_VALUE_INT
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
): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readByte() != 0.toByte()) {
    }

    constructor(): this(
            DEFAULT_VALUE_INT,
            DEFAULT_STRING,
            DEFAULT_STRING,
            DEFAULT_VALUE_INT,
            DEFAULT_VALUE_INT,
            DEFAULT_STRING,
            DEFAULT_STRING,
            DEFAULT_BOOLEAN
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(twister)
        parcel.writeInt(length)
        parcel.writeInt(difficulty)
        parcel.writeString(iconUrl)
        parcel.writeString(hint)
        parcel.writeByte(if (isLocked) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Twister> {
        override fun createFromParcel(parcel: Parcel): Twister {
            return Twister(parcel)
        }

        override fun newArray(size: Int): Array<Twister?> {
            return arrayOfNulls(size)
        }
    }
}