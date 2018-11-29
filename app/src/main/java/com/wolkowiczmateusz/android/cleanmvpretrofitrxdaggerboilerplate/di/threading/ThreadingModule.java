package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.threading;


import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.MainThreadImpl;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.ThreadExecutor;

import dagger.Module;
import dagger.Provides;

@Module
public class ThreadingModule {

    @Provides
    Executor provideExecutor() {
        return ThreadExecutor.getInstance();
    }

    @Provides
    MainThread provideMainThread() {
        return MainThreadImpl.getInstance();
    }
}
