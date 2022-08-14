package com.kineduchallenge.core.database.dao

import com.kineduchallenge.core.database.schema.Event
import io.realm.Realm
import javax.inject.Inject
import javax.inject.Provider

class EventDao @Inject constructor(private val mProvider: Provider<Realm>) : BaseDao<Event> {
    override fun deleteAll() {
        mProvider.get().use { realm ->
            val events = realm.where(Event::class.java).findAll()
            realm.executeTransaction {
                events.deleteAllFromRealm()
            }
            realm.close()
        }
    }

    override fun add(data: Event) {
        mProvider.get().use { realm ->
            realm.executeTransaction { transaction ->
                transaction.copyToRealmOrUpdate(data)
            }
            realm.close()
        }
    }

    override fun get(id: Int): Event {
        mProvider.get().use { realm ->
            var event = Event()
            realm.where(Event::class.java).equalTo("id", id).findFirst()?.let {
                event = realm.copyFromRealm(it)
            }

            realm.close()

            return event
        }
    }

    override fun getAll(): List<Event> {
        mProvider.get().use { realm ->
            val events =
                realm.copyFromRealm(realm.where(Event::class.java).findAll()) ?: emptyList()

            realm.close()

            return events
        }
    }

}