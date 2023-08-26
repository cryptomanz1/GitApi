package com.example.gitapi

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity


@Entity(primaryKeys = ["massage", "documentation_url"])
data class Repository(
    val massage: String,
    @ColumnInfo(name = "documentation_url")
    val documentationUrl: String,
    @ColumnInfo(name = "user_id")
    val userId: Int
)