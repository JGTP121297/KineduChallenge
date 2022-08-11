package com.kineduchallenge.core.api

import com.google.gson.annotations.SerializedName

data class Data<T>(
    @SerializedName("results")
    var results: T
)