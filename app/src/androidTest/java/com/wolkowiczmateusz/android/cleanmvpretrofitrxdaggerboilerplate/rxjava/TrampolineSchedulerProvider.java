package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.rxjava;

import android.support.annotation.NonNull;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class TrampolineSchedulerProvider implements MainThread, Executor {

    @NonNull
    @Override
    public Scheduler scheduler() {
        return Schedulers.trampoline();
    }

    @Override
    public void post(@NonNull Runnable runnable) {
    }

    @Override
    public void execute(@NonNull Runnable command) {
    }
}
