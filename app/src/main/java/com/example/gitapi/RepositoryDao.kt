package com.example.gitapi

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction


@Dao
interface RepositoryDao {
    @Transaction
    @Query("SELECT * FROM Repository r WHERE r.user_id =:userId")
    suspend fun getUserRepositories(userId: Int): List<Repository>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepositories(repositories: List<Repository>)
}