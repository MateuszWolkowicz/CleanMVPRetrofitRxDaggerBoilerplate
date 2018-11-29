package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.usecases;


import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.Impl.TryToLoginUseCaseImpl;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.TryToLoginUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCasesModule {

    @Provides
    public TryToLoginUseCase provideTryToLoginUseCase(TryToLoginUseCaseImpl tryToLoginUseCaseImpl) {
        return tryToLoginUseCaseImpl;
    }

}
