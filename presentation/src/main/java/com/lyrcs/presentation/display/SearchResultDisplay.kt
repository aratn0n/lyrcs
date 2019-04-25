package com.lyrcs.presentation.display

import android.os.Parcel
import android.os.Parcelable

data class SearchResultDisplay(val trackId: String,
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

    companion object CREATOR : Parcelable.Creator<SearchResultDisplay> {
        override fun createFromParcel(parcel: Parcel): SearchResultDisplay {
            return SearchResultDisplay(parcel)
        }

        override fun newArray(size: Int): Array<SearchResultDisplay?> {
            return arrayOfNulls(size)
        }
    }
}