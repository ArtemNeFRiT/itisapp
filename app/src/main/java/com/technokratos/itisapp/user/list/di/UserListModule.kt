package com.technokratos.itisapp.user.list.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.technokratos.domain.UserInteractor
import com.technokratos.itisapp.di.ViewModelModule
import com.technokratos.itisapp.router.AppRouter
import com.technokratos.itisapp.user.list.UserListViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import jp.co.soramitsu.common.di.viewmodel.ViewModelKey

@Module(includes = [ViewModelModule::class])
class UserListModule {

    @Provides
    @IntoMap
    @ViewModelKey(UserListViewModel::class)
    fun provideViewModel(
        interactor: UserInteractor,
        router: AppRouter
    ): ViewModel {
        return UserListViewModel(interactor, router)
    }

    @Provides
    fun provideViewModelCreator(fragment: Fragment, viewModelFactory: ViewModelProvider.Factory): UserListViewModel {
        return ViewModelProvider(fragment, viewModelFactory).get(UserListViewModel::class.java)
    }
}