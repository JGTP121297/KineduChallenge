package com.kineduchallenge.core.api.data

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("id")
    var id: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("description")
    var description: String
)