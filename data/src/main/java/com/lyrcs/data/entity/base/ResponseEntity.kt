package com.lyrcs.data.entity.base

import com.google.gson.annotations.SerializedName

data class ResponseEntity<T>(@SerializedName("message") val messageEntity: MessageEntity<T>) {
    fun getBody(): T = messageEntity.body
}