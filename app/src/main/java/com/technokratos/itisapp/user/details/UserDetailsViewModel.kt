package com.technokratos.itisapp.user.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.technokratos.domain.UserInteractor
import com.technokratos.domain.model.User
import com.technokratos.itisapp.R
import com.technokratos.itisapp.common.ResourceManager
import com.technokratos.itisapp.user.details.model.UserDetailsModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserDetailsViewModel(
    private val userId: Int,
    private val interactor: UserInteractor,
    private val resourceManager: ResourceManager
): ViewModel() {

    private val disposables = CompositeDisposable()

    private val _userLiveData = MutableLiveData<UserDetailsModel>()
    val userLiveData: LiveData<UserDetailsModel> = _userLiveData

    init {
        disposables.add(
            interactor.getUser(userId)
                .subscribeOn(Schedulers.io())
                .map(::mapUserToUserDetailsModel)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    _userLiveData.value = it
                }, {
                    it.printStackTrace()
                })
        )
    }

    private fun mapUserToUserDetailsModel(user: User): UserDetailsModel {
        val userInfo = resourceManager.getString(R.string.user_info_mask).format(user.name, user.age)
        return UserDetailsModel(userInfo)
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}