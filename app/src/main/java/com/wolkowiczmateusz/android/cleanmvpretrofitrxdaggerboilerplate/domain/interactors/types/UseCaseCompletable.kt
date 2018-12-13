package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.types

import io.reactivex.Completable

interface UseCaseCompletable<Params> {

    fun runUseCase(vararg params: Params): Completable
}
