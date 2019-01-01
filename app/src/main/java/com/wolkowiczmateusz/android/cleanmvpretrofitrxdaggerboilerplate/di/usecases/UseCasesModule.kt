package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.usecases

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.TryToLoginUseCase
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.impl.TryToLoginUseCaseImpl
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun provideTryToLoginUseCase(tryToLoginUseCaseImpl: TryToLoginUseCaseImpl): TryToLoginUseCase {
        return tryToLoginUseCaseImpl
    }
}
