package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.repository

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface Repository {

    val loginUser: Single<User>
    val isUserLogin: Single<Boolean>
    fun logoutUser(): Completable
    fun tryLogin(vararg params: String): Observable<User>
}
