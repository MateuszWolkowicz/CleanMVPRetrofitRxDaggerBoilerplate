package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.rxjava;

import android.support.annotation.NonNull;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MateuszW on 2018-06-25.
 */
public class TrampolineSchedulerProvider implements MainThread, Executor {

    @Override
    public Scheduler scheduler() {
        return Schedulers.trampoline();
    }

    @Override
    public void post(Runnable runnable) {
    }

    @Override
    public void execute(@NonNull Runnable command) {
    }
}
