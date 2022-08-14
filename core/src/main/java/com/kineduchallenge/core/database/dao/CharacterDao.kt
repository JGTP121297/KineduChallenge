package com.kineduchallenge.core.database.dao

import com.kineduchallenge.core.database.schema.Character
import io.realm.Realm
import javax.inject.Inject
import javax.inject.Provider

class CharacterDao @Inject constructor(private val mProvider: Provider<Realm>) :
    BaseDao<Character> {
    override fun deleteAll() {
        mProvider.get().use { realm ->
            val characters = realm.where(Character::class.java).findAll()
            realm.executeTransaction {
                characters.deleteAllFromRealm()
            }
            realm.close()
        }
    }

    override fun add(data: Character) {
        mProvider.get().use { realm ->
            realm.executeTransaction { transaction ->
                transaction.copyToRealmOrUpdate(data)
            }
            realm.close()
        }
    }

    override fun get(id: Int): Character {
        mProvider.get().use { realm ->
            var character = Character()
            realm.where(Character::class.java).equalTo("id", id).findFirst()?.let {
                character = realm.copyFromRealm(it)
            }

            realm.close()

            return character
        }
    }

    override fun getAll(): List<Character> {
        mProvider.get().use { realm ->
            val characters =
                realm.copyFromRealm(realm.where(Character::class.java).findAll()) ?: emptyList()

            realm.close()

            return characters
        }
    }
}