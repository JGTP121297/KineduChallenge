package com.kineduchallenge.core.database.dao

import com.kineduchallenge.core.database.schema.Story
import io.realm.Realm
import javax.inject.Inject
import javax.inject.Provider

class StoryDao @Inject constructor(private val mProvider: Provider<Realm>) : BaseDao<Story> {
    override fun deleteAll() {
        mProvider.get().use { realm ->
            val stories = realm.where(Story::class.java).findAll()
            realm.executeTransaction {
                stories.deleteAllFromRealm()
            }
            realm.close()
        }
    }

    override fun add(data: Story) {
        mProvider.get().use { realm ->
            realm.executeTransaction { transaction ->
                transaction.copyToRealmOrUpdate(data)
            }
            realm.close()
        }
    }

    override fun get(id: Int): Story {
        mProvider.get().use { realm ->
            var story = Story()
            realm.where(Story::class.java).equalTo("id", id).findFirst()?.let {
                story = realm.copyFromRealm(it)
            }

            realm.close()

            return story
        }
    }

    override fun getAll(): List<Story> {
        mProvider.get().use { realm ->
            val story =
                realm.copyFromRealm(realm.where(Story::class.java).findAll()) ?: emptyList()

            realm.close()

            return story
        }
    }

}