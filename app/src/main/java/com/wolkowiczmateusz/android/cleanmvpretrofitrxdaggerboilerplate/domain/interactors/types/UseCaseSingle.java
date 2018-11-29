package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.types;

import io.reactivex.Single;

public interface UseCaseSingle<T, Params> {

    Single<T> runUseCase(Params... params);
}
