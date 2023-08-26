package com.example.gitapi

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var userRepository: UserRepository
    private lateinit var userAdapter: UserListAdapter

    @SuppressLint
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.userRecyclerView)
        userAdapter = UserListAdapter { selectedUser -> (selectedUser) }
        recyclerView.adapter = userAdapter

        val database = AppDatabase.getInstance(applicationContext)
        val userDao = database.userDao()
        userRepository = UserRepository(userDao)

        loadUsers()
    }

    private fun loadUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            val users = userRepository.getUsersFromApiOrDatabase()
            lifecycleScope.launch { userAdapter.setUsers(users) }
        }
    }
}
