package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.types

import io.reactivex.Flowable

interface UseCaseFlowable<T, Params> {

    fun runUseCase(vararg params: Params): Flowable<T>
}
