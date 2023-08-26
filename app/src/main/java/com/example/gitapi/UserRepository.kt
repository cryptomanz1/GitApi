package com.example.gitapi

class UserRepository(private val userDao: UserDao) {

    suspend fun getUsersFromApiOrDatabase(): List<User> {

        val users = fetchUsersFromApi()
        return users

    }

    private suspend fun fetchUsersFromApi(): List<User> {
        val response = RetrofitClientModule.userService.getUsers()
        return response.body() ?: emptyList()
    }
}
