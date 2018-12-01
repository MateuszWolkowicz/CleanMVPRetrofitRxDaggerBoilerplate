package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading;

import io.reactivex.Scheduler;

public interface Executor extends java.util.concurrent.Executor {

    Scheduler scheduler();
}
