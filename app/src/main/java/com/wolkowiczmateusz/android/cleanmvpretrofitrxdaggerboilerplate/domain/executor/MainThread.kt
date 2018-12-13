package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor

import io.reactivex.Scheduler

interface MainThread {

    fun scheduler(): Scheduler
    fun post(runnable: Runnable)
}
