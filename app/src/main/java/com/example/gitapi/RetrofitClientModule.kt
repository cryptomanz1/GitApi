package com.example.gitapi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClientModule {
    private const val BASE_URL = "https://api.github.com"
    val client by lazy {
        OkHttpClient.Builder().build()
    }
    val userService: ApiClient by lazy {
        val retrofit = Retrofit.Builder().client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiClient::class.java)
    }

}
