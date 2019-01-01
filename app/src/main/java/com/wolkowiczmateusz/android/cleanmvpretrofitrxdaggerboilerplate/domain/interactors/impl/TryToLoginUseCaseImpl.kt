package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.impl

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.TryToLoginUseCase
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.repository.Repository
import io.reactivex.Observable
import javax.inject.Inject

class TryToLoginUseCaseImpl @Inject
constructor(private val repository: Repository) : TryToLoginUseCase {

    override fun runUseCase(vararg params: String): Observable<User> {
        return repository.tryLogin(params[0], params[1])
    }
}
