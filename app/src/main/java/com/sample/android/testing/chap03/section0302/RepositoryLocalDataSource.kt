package com.sample.android.testing.chap03.section0302

class RepositoryLocalDataSource(val db: AppDatabase) {

    fun insertAll(vararg repositories: Repository) {
        db.repositoryDao().insertAll(*repositories)
    }

    fun findByOwner(owner: String): List<Repository> {
        return db.repositoryDao().findByOwner(owner)
    }
}
