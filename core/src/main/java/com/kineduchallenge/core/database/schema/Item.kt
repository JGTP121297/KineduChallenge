package com.kineduchallenge.core.database.schema

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Item : RealmObject() {
    val id: String
        get() {
            resourceURI?.let { uri ->
                return uri.split("/").last()
            }
            return ""
        }

    @SerializedName("resourceURI")
    var resourceURI: String? = null

    @SerializedName("name")
    var name: String? = null
}