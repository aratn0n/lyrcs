package com.lyrcs.data.entity.base

import com.google.gson.annotations.SerializedName

data class HeaderEntity(@SerializedName("status_code") val statusCode: String,
                        @SerializedName("execute_time") val executeTime: String,
                        @SerializedName("available") val available: String) {
}