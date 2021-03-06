package com.lyrcs.presentation.display

import android.os.Parcel
import android.os.Parcelable

data class LyricsDisplay(val trackName: String,
                         val artistName: String,
                         val lyrics: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(trackName)
        parcel.writeString(artistName)
        parcel.writeString(lyrics)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LyricsDisplay> {
        override fun createFromParcel(parcel: Parcel): LyricsDisplay {
            return LyricsDisplay(parcel)
        }

        override fun newArray(size: Int): Array<LyricsDisplay?> {
            return arrayOfNulls(size)
        }
    }

}