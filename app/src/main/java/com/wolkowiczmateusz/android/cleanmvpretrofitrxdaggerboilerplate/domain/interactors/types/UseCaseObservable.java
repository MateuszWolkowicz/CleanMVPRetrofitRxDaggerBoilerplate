package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.types;

import io.reactivex.Observable;

public interface UseCaseObservable<T, Params> {

    Observable<T> runUseCase(Params... params);
}
