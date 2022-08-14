package com.kineduchallenge.core.database.schema

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Index

open class Event : RealmObject() {
    @Index
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("title", alternate = ["name"])
    var title: String? = null

    @SerializedName("description")
    var description: String? = null

    /*@SerializedName("thumbnail")
    var thumbnail: Thumbnail? = null

    @SerializedName("comica")
    var comics: RealmList<Comic>? = null

    @SerializedName("stories")
    var stories: RealmList<Story>? = null

    @SerializedName("series")
    var series: RealmList<Series>? = null

    @SerializedName("characters")
    var characters: RealmList<Character>? = null*/

    @SerializedName("resourceURI")
    var resourceURI: String? = null
}