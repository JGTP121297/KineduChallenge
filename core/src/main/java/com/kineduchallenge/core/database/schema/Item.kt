package com.kineduchallenge.core.database.schema

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Item : RealmObject() {
    val id: Int
        get() {
            resourceURI?.let { uri ->
                val idString = uri.split("/").last()
                return when {
                    idString.isNotEmpty() -> idString.toInt()
                    else -> 0
                }
            }
            return 0
        }

    @SerializedName("resourceURI")
    var resourceURI: String? = null

    @SerializedName("name")
    var name: String? = null
}