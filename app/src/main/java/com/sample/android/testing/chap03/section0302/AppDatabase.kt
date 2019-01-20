package com.sample.android.testing.chap03.section0302

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Repository::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun repositoryDao(): RepositoryDao
}
