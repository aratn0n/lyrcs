package com.lyrcs.data.entity.base

import com.google.gson.annotations.SerializedName

data class BodyEntity<T>(
    @SerializedName("header") val headerEntity: HeaderEntity,
    @SerializedName("body") val body: T) {
}