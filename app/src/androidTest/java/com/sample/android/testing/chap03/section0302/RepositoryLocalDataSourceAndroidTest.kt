package com.sample.android.testing.chap03.section0302

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.assertj.core.api.Assertions
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RepositoryLocalDataSourceAndroidTest {

    lateinit var repositoryLocalDataSource: RepositoryLocalDataSource

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getContext()
        val db = Room
            .inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        repositoryLocalDataSource = RepositoryLocalDataSource(db)
    }

    @Test
    fun insertAll_finishesSuccessfully() {
        val owner = "shiroyama"
        repositoryLocalDataSource.insertAll(
            Repository(1, "hello", "hello", owner),
            Repository(2, "world", "world", owner)
        )

        val list = repositoryLocalDataSource.findByOwner("shiroyama")
        Assertions.assertThat(list).hasSize(2)
    }

    @Test
    fun findByOwner_expectsEmpty() {
        val list = repositoryLocalDataSource.findByOwner("shiroyama")
        Assertions.assertThat(list).isEmpty()
    }
}
