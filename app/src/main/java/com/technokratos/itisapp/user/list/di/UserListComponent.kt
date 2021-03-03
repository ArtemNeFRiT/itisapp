package com.technokratos.itisapp.user.list.di

import androidx.appcompat.app.AppCompatActivity
import com.technokratos.itisapp.di.ScreenScope
import com.technokratos.itisapp.user.list.MainActivity
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@Subcomponent(
    modules = [
        UserListModule::class
    ]
)
@ScreenScope
interface UserListComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance activity: AppCompatActivity
        ): UserListComponent
    }

    fun inject(mainActivity: MainActivity)
}