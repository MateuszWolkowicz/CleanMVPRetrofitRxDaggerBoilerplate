package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading;

import io.reactivex.Scheduler;

/**
 * Created by MateuszW on 2018-06-11.
 */
public interface Executor extends java.util.concurrent.Executor {

    Scheduler scheduler();
}
