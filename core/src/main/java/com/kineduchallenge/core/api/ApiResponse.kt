package com.kineduchallenge.core.api

import com.google.gson.annotations.SerializedName

data class ApiResponse<T>(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val data: Data<T>,
    @SerializedName("status")
    val status: String
)