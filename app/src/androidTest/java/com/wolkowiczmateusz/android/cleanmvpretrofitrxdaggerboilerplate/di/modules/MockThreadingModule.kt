package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.modules

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.rxjava.TrampolineSchedulerProvider

import dagger.Module
import dagger.Provides

@Module
class MockThreadingModule {

    @Provides
    internal fun provideExecutor(): Executor {
        return TrampolineSchedulerProvider()
    }

    @Provides
    internal fun provideMainThread(): MainThread {
        return TrampolineSchedulerProvider()
    }
}
