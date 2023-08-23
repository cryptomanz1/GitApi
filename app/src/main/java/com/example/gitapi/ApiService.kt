package com.example.gitapi

import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users")
    suspend fun getUsers(): List<User>
}

interface RepositoryService {
    @GET("users/{login}/repos")
    suspend fun getUserRepositories(@Path("login") login: String): List<Repository>
}