package com.technokratos.itisapp.user.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.technokratos.itisapp.R
import com.technokratos.itisapp.user.list.model.UserModel
import kotlinx.android.synthetic.main.item_user.view.userAge
import kotlinx.android.synthetic.main.item_user.view.userName

class UserAdapter() : ListAdapter<UserModel, UserViewHolder>(userCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(user: UserModel) {
        with(itemView) {
            userName.text = user.name
            userAge.text = user.age
        }
    }
}

private val userCallback = object : DiffUtil.ItemCallback<UserModel>() {

    override fun areItemsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserModel, newItem: UserModel): Boolean {
        return oldItem == newItem
    }
}