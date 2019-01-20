package com.sample.android.testing.chap03.section0302

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface RepositoryDao {

    @Insert
    fun insertAll(vararg repositories: Repository)

    @Query("SELECT * FROM repository WHERE owner = :owner")
    fun findByOwner(owner: String): List<Repository>
}
