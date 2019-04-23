package com.lyrcs.presentation.display

import android.os.Parcel
import android.os.Parcelable

data class TrackDisplay(val trackId: String,
                        val trackName: String,
                        val artistName: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(trackId)
        parcel.writeString(trackName)
        parcel.writeString(artistName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TrackDisplay> {
        override fun createFromParcel(parcel: Parcel): TrackDisplay {
            return TrackDisplay(parcel)
        }

        override fun newArray(size: Int): Array<TrackDisplay?> {
            return arrayOfNulls(size)
        }
    }
}