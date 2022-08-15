package com.kineduchallenge.core.database.schema

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.Index
import io.realm.annotations.PrimaryKey

open class Comic : RealmObject() {
    @Index
    @PrimaryKey
    @SerializedName("id")
    var id: Int? = null

    @SerializedName("title", alternate = ["name"])
    var title: String? = ""

    @SerializedName("description")
    var description: String? = ""

    @SerializedName("thumbnail")
    var thumbnail: Thumbnail? = null

    /*@SerializedName("characters")
    var characters: RealmList<Character>? = null

    @SerializedName("stories")
    var stories: RealmList<Story>? = null

    @SerializedName("events")
    var events: RealmList<Event>? = null*/

    @SerializedName("resourceURI")
    var resourceURI: String? = null
}