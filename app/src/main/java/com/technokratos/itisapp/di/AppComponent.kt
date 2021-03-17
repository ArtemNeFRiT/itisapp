package com.technokratos.itisapp.di

import android.content.Context
import com.technokratos.data.di.DbModule
import com.technokratos.data.di.NetworkModule
import com.technokratos.data.di.RepoModule
import com.technokratos.itisapp.user.details.di.UserDetailsComponent
import com.technokratos.itisapp.user.list.di.UserListComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DbModule::class,
        NetworkModule::class,
        AppModule::class,
        RepoModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Context): Builder

        fun build(): AppComponent
    }

    fun userListComponentFactory(): UserListComponent.Factory

    fun userDetailsComponentFactory(): UserDetailsComponent.Factory
}