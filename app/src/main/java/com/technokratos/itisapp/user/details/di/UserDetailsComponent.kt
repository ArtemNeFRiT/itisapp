package com.technokratos.itisapp.user.details.di

import androidx.fragment.app.Fragment
import com.technokratos.itisapp.di.ScreenScope
import com.technokratos.itisapp.user.details.UserDetailsFragment
import com.technokratos.itisapp.user.list.UserListFragment
import com.technokratos.itisapp.user.list.di.UserListComponent
import com.technokratos.itisapp.user.list.di.UserListModule
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [
        UserDetailsModule::class
    ]
)
@ScreenScope
interface UserDetailsComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(
            @BindsInstance fragment: Fragment
        ): UserDetailsComponent
    }

    fun inject(usersDetailsFragment: UserDetailsFragment)
}