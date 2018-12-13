package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading

import io.reactivex.Scheduler

interface Executor : java.util.concurrent.Executor {

    fun scheduler(): Scheduler
}
