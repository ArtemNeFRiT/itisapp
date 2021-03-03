package com.technokratos.itisapp.user.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.technokratos.itisapp.App
import com.technokratos.itisapp.R
import com.technokratos.itisapp.di.DaggerAppComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var userListViewModel: UserListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).appComponent.userListComponentFactory()
            .create(this)
            .inject(this)
    }
}