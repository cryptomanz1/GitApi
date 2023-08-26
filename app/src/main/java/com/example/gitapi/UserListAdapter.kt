package com.example.gitapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserListAdapter(private val onItemClick: (User) -> Unit) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private var users: List<User> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun getItemId(position: Int): Long {
        return users[position].id.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    fun setUsers(newUsers: Any) {
        users = newUsers as List<User>
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)

        fun bind(user: User) {
            itemView.setOnClickListener { onItemClick(user) }
            usernameTextView.text = user.login
        }
    }
}
