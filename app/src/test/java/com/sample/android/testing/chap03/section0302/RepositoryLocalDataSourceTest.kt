package com.sample.android.testing.chap03.section0302

import android.arch.persistence.room.Room
import androidx.test.InstrumentationRegistry
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RepositoryLocalDataSourceTest {

    lateinit var repositoryLocalDataSource: RepositoryLocalDataSource

    @Before
    fun setUp() {
        val context = InstrumentationRegistry.getTargetContext()
        val db = Room
            .databaseBuilder(context, AppDatabase::class.java, "DB")
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
        assertThat(list).hasSize(2)
    }

    @Test
    fun findByOwner_expectsEmpty() {
        val list = repositoryLocalDataSource.findByOwner("shiroyama")
        assertThat(list).isEmpty()
    }
}
