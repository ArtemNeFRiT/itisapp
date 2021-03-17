package com.technokratos.itisapp.user.list.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.technokratos.itisapp.di.ScreenScope
import com.technokratos.itisapp.MainActivity
import com.technokratos.itisapp.router.AppRouter
import com.technokratos.itisapp.user.list.UserListFragment
import dagger.BindsInstance
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
            @BindsInstance fragment: Fragment,
            @BindsInstance router: AppRouter
        ): UserListComponent
    }

    fun inject(usersListFragment: UserListFragment)
}