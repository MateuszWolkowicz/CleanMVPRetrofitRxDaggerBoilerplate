package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.types;

import io.reactivex.Flowable;

public interface UseCaseFlowable<T, Params> {

    Flowable<T> runUseCase(Params... params);
}
