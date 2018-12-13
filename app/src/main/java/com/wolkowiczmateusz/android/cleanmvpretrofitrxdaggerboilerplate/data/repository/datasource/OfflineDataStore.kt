package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.datasource

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.UserEntity
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.device.sharedpreferences.UserStorage
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class OfflineDataStore @Inject
constructor(private val userStorage: UserStorage) {

    val loginUser: UserEntity
        get() = userStorage.user

    val isUserLogin: Single<Boolean>
        get() = Single.defer { userStorage.isUserLogin }

    fun logout(): Completable {
        return userStorage.logout()
    }

    fun saveUserToStorage(userEntity: UserEntity) {
        userStorage.saveUser(userEntity)
    }
}
