package com.kineduchallenge.core.database.schema

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey

open class Character : RealmObject() {
    @Index
    @PrimaryKey
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("description")
    var description: String? = null

    @SerializedName("thumbnail")
    var thumbnail: Thumbnail? = null

    @SerializedName("comics")
    var comics: ItemList? = null

    @SerializedName("stories")
    var stories: ItemList? = null

    @SerializedName("events")
    var events: ItemList? = null

    @SerializedName("series")
    var series: ItemList? = null

    @SerializedName("resourceURI")
    var resourceURI: String? = null
}