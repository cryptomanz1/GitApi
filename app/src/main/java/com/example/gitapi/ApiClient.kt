package com.example.gitapi

import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("/users")
    suspend fun getUsers(): Response<List<User>?>
}