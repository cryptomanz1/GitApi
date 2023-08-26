package com.example.gitapi

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    val login: String,
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String
)