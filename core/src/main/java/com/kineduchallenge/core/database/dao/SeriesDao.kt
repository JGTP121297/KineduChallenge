package com.kineduchallenge.core.database.dao

import com.kineduchallenge.core.database.schema.Series
import io.realm.Realm
import javax.inject.Inject
import javax.inject.Provider

class SeriesDao @Inject constructor(private val mProvider: Provider<Realm>) : BaseDao<Series> {
    override fun deleteAll() {
        mProvider.get().use { realm ->
            val series = realm.where(Series::class.java).findAll()
            realm.executeTransaction {
                series.deleteAllFromRealm()
            }
            realm.close()
        }
    }

    override fun add(data: Series) {
        mProvider.get().use { realm ->
            realm.executeTransaction { transaction ->
                transaction.copyToRealmOrUpdate(data)
            }
            realm.close()
        }
    }

    override fun get(id: Int): Series {
        mProvider.get().use { realm ->
            var series = Series()
            realm.where(Series::class.java).equalTo("id", id).findFirst()?.let {
                series = realm.copyFromRealm(it)
            }

            realm.close()

            return series
        }
    }

    override fun getAll(): List<Series> {
        mProvider.get().use { realm ->
            val series =
                realm.copyFromRealm(realm.where(Series::class.java).findAll()) ?: emptyList()

            realm.close()

            return series
        }
    }

}