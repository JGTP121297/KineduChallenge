package com.kineduchallenge.core.database.schema

import com.google.gson.annotations.SerializedName
import io.realm.RealmList
import io.realm.RealmObject

open class ItemList : RealmObject(){
    @SerializedName("items")
    var itemList: RealmList<Item>? = null
}