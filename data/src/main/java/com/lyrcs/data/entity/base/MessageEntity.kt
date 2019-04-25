package com.lyrcs.data.entity.base

import com.google.gson.annotations.SerializedName

data class MessageEntity<T>(@SerializedName("header") val header: HeaderEntity,
                            @SerializedName("body") val body: T) {
}