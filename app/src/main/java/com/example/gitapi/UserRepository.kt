package com.example.gitapi

class UserRepository(private val userDao: UserDao) {

    suspend fun getUsersFromApiOrDatabase(): Any {
        val cachedUsers = userDao.getUsers()

        if (cachedUsers.isEmpty()) {
            val usersFromApi = fetchUsersFromApi()
            userDao.insertUsers(usersFromApi)
            return usersFromApi
        }

        return cachedUsers
    }

    private suspend fun fetchUsersFromApi() {

    }
}
