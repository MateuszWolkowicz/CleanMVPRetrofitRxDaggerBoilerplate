package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor;

import io.reactivex.Scheduler;

/**
 * Created by MateuszW on 2018-05-22.
 */
public interface MainThread {

    /**
     * Make runnable operation run in the main thread.
     */
    Scheduler scheduler();
    void post(final Runnable runnable);
}
