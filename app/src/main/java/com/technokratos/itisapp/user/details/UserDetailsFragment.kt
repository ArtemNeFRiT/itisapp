package com.technokratos.itisapp.user.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.technokratos.itisapp.App
import com.technokratos.itisapp.R
import kotlinx.android.synthetic.main.fragment_user.*
import javax.inject.Inject

class UserDetailsFragment: Fragment() {

    companion object {
        private const val KEY_USER_ID = "userId"

        fun getBundle(userId: Int): Bundle {
            return Bundle().apply {
                putInt(KEY_USER_ID, userId)
            }
        }
    }

    @Inject lateinit var userDetailsViewModel: UserDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity?.application as App).appComponent.userDetailsComponentFactory()
            .create(this)
            .inject(this)

        userDetailsViewModel.userLiveData.observe(viewLifecycleOwner, Observer {
            userInfo.text = it.userInfo
        })
    }
}