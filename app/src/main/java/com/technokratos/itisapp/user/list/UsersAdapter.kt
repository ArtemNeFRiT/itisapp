package com.technokratos.itisapp.user.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.technokratos.itisapp.R
import com.technokratos.itisapp.user.list.model.UserItemModel
import kotlinx.android.synthetic.main.item_user.view.userAge
import kotlinx.android.synthetic.main.item_user.view.userName

class UsersAdapter(
    private val itemHandler: UserItemHandler
) : ListAdapter<UserItemModel, UserViewHolder>(userCallback) {
    
    interface UserItemHandler {
        fun onClick(user: UserItemModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position), itemHandler)
    }
}

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(user: UserItemModel, itemHandler: UsersAdapter.UserItemHandler) {
        with(itemView) {
            userName.text = user.name
            userAge.text = user.age

            setOnClickListener { itemHandler.onClick(user) }
        }
    }
}

private val userCallback = object : DiffUtil.ItemCallback<UserItemModel>() {

    override fun areItemsTheSame(oldItem: UserItemModel, newItem: UserItemModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserItemModel, newItem: UserItemModel): Boolean {
        return oldItem == newItem
    }
}