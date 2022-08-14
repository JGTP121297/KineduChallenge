package com.kineduchallenge.core.database.schema

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

open class Thumbnail : RealmObject(){
    @SerializedName("path")
    var path: String? = null
    @SerializedName("extension")
    var extension: String? = null
}