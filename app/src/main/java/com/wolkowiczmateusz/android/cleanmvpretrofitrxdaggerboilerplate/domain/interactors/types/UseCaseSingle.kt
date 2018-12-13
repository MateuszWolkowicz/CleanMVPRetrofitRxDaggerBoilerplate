package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.types

import io.reactivex.Single

interface UseCaseSingle<T, Params> {

    fun runUseCase(vararg params: Params): Single<T>
}
