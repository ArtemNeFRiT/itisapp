package com.technokratos.itisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.technokratos.itisapp.router.AppRouter
import com.technokratos.itisapp.user.details.UserDetailsFragment
import com.technokratos.itisapp.user.list.UserListViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity(), AppRouter {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun openUserDetails(userId: Int) {
        navController.navigate(R.id.action_users_to_user_details, UserDetailsFragment.getBundle(userId))
    }

    private val navController: NavController by lazy {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHost) as NavHostFragment

        navHostFragment.navController
    }
}