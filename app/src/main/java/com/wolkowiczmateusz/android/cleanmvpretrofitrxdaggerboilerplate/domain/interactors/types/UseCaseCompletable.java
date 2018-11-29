package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.types;

import io.reactivex.Completable;

public interface UseCaseCompletable<Params> {

    Completable runUseCase(Params... params);
}
