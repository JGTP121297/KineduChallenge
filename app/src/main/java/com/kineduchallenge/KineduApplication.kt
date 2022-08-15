package com.kineduchallenge

import android.app.Application
import com.kineduchallenge.core.database.DataBase
import dagger.hilt.android.HiltAndroidApp
import io.realm.Realm
import io.realm.RealmConfiguration

@HiltAndroidApp
open class KineduApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initDataBase()
    }

    private fun initDataBase() {
        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .allowWritesOnUiThread(true)
            .allowQueriesOnUiThread(true)
            .deleteRealmIfMigrationNeeded()
            .modules(DataBase())
            .build()
        Realm.setDefaultConfiguration(config)
    }

}