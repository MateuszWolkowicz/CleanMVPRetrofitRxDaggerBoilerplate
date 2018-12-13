package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.types

import io.reactivex.Observable

interface UseCaseObservable<T, Params> {

    fun runUseCase(vararg params: Params): Observable<T>
}
