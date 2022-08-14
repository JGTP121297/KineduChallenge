package com.kineduchallenge.core.database.dao

import com.kineduchallenge.core.database.schema.Comic
import io.realm.Realm
import javax.inject.Inject
import javax.inject.Provider

class ComicDao @Inject constructor(private val mProvider: Provider<Realm>) : BaseDao<Comic> {
    override fun deleteAll() {
        mProvider.get().use { realm ->
            val comics = realm.where(Comic::class.java).findAll()
            realm.executeTransaction {
                comics.deleteAllFromRealm()
            }
            realm.close()
        }
    }

    override fun add(data: Comic) {
        mProvider.get().use { realm ->
            realm.executeTransaction { transaction ->
                transaction.copyToRealmOrUpdate(data)
            }
            realm.close()
        }
    }

    override fun get(id: Int): Comic {
        mProvider.get().use { realm ->
            var comic = Comic()
            realm.where(Comic::class.java).equalTo("id", id).findFirst()?.let {
                comic = realm.copyFromRealm(it)
            }

            realm.close()

            return comic
        }
    }

    override fun getAll(): List<Comic> {
        mProvider.get().use { realm ->
            val comics =
                realm.copyFromRealm(realm.where(Comic::class.java).findAll()) ?: emptyList()

            realm.close()

            return comics
        }
    }

}