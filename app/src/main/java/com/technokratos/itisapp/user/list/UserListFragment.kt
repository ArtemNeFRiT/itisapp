package com.technokratos.itisapp.user.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.technokratos.itisapp.App
import com.technokratos.itisapp.R
import com.technokratos.itisapp.router.AppRouter
import com.technokratos.itisapp.user.list.model.UserItemModel
import kotlinx.android.synthetic.main.fragment_users.*
import javax.inject.Inject

class UserListFragment: Fragment(), UsersAdapter.UserItemHandler {

    @Inject lateinit var viewModel: UserListViewModel

    private val usersAdapter = UsersAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).appComponent.userListComponentFactory()
            .create(this, activity as AppRouter)
            .inject(this)

        users.adapter = usersAdapter

        viewModel.users.observe(viewLifecycleOwner, Observer {
            usersAdapter.submitList(it)
        })

        viewModel.updateUsers()
    }

    override fun onClick(user: UserItemModel) {
        viewModel.userClicked(user)
    }
}