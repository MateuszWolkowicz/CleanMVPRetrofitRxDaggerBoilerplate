package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.modules;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.rxjava.TrampolineSchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class MockThreadingModule {

    @Provides
    Executor provideExecutor() {
        return new TrampolineSchedulerProvider();
    }

    @Provides
    MainThread provideMainThread() {
        return new TrampolineSchedulerProvider();
    }
}
