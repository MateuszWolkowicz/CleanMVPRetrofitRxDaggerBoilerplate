package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor;

import io.reactivex.Scheduler;


public interface MainThread {

    /**
     * Make runnable operation run in the main thread.
     */
    Scheduler scheduler();
    void post(final Runnable runnable);
}
