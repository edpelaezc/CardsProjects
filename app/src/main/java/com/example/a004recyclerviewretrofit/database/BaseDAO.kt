package com.example.a004recyclerviewretrofit.database

import io.realm.kotlin.RealmConfiguration

open class BaseDAO {
    private val allStores by lazy {
        RealmCardsDAO.STORES
    }

    companion object {
        private const val DATABASE_SCHEMA_VERSION = 1L
    }

    val config by lazy {
        RealmConfiguration
            .Builder(allStores)
            .name("bah.realm")
            .schemaVersion(DATABASE_SCHEMA_VERSION)
            .deleteRealmIfMigrationNeeded()
            .build()

    }
}