package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.threading

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.MainThreadImpl
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.ThreadExecutor

import dagger.Module
import dagger.Provides

@Module
class ThreadingModule {

    @Provides
    internal fun provideExecutor(): Executor {
        return ThreadExecutor
    }

    @Provides
    internal fun provideMainThread(): MainThread {
        return MainThreadImpl
    }
}
