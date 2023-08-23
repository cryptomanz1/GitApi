package com.example.gitapi

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RepositoryDao {
    @Query("SELECT * FROM repository WHERE ownerLogin = :login")
    suspend fun getUserRepositories(login: String): List<Repository>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepositories(repositories: List<Repository>)
}