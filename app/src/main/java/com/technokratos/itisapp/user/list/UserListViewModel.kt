package com.technokratos.itisapp.user.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.technokratos.domain.UserInteractor
import com.technokratos.domain.model.User
import com.technokratos.itisapp.router.AppRouter
import com.technokratos.itisapp.user.list.model.UserItemModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserListViewModel(
    private val interactor: UserInteractor,
    private val router: AppRouter
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _users = MutableLiveData<List<UserItemModel>>()
    val users: LiveData<List<UserItemModel>> = _users

    init {
        disposables.add(
            interactor.getUsers()
                .subscribeOn(Schedulers.io())
                .map { it.map(::mapUserToUserItemModel) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _users.value = it
                }, {
                })
        )
    }

    private fun mapUserToUserItemModel(user: User): UserItemModel {
        return with(user) {
            UserItemModel(id, name, age.toString())
        }
    }

    fun updateUsers() {
        disposables.add(
            interactor.updateUsers()
                .subscribeOn(Schedulers.io())
                .subscribe()
        )
    }

    fun userClicked(user: UserItemModel) {
        router.openUserDetails(user.id)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}