package com.kineduchallenge.core.database

import com.kineduchallenge.core.database.schema.*
import io.realm.annotations.RealmModule

@RealmModule(
    classes = [
        Character::class,
        Comic::class,
        Event::class,
        Series::class,
        Story::class,
        Thumbnail::class,
        ItemList::class,
        Item::class
    ]
)
class DataBase