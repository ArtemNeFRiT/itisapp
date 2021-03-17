package com.technokratos.itisapp.user.details.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.technokratos.domain.UserInteractor
import com.technokratos.itisapp.common.ResourceManager
import com.technokratos.itisapp.di.ViewModelModule
import com.technokratos.itisapp.user.details.UserDetailsViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import jp.co.soramitsu.common.di.viewmodel.ViewModelKey

@Module(includes = [ViewModelModule::class])
class UserDetailsModule {

    @Provides
    @IntoMap
    @ViewModelKey(UserDetailsViewModel::class)
    fun provideViewModel(
        interactor: UserInteractor,
        resourceManager: ResourceManager
    ): ViewModel {
        return UserDetailsViewModel(1, interactor, resourceManager)
    }

    @Provides
    fun provideViewModelCreator(fragment: Fragment, viewModelFactory: ViewModelProvider.Factory): UserDetailsViewModel {
        return ViewModelProvider(fragment, viewModelFactory).get(UserDetailsViewModel::class.java)
    }
}