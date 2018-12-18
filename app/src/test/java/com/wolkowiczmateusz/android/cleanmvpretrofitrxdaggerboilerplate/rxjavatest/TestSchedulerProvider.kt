package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.rxjavatest

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor

import io.reactivex.Scheduler
import io.reactivex.schedulers.TestScheduler

/**
 * Created by MateuszW on 2018-06-28.
 */

class TestSchedulerProvider(private val testScheduler: TestScheduler) : MainThread, Executor {

    override fun scheduler(): Scheduler {
        return testScheduler
    }

    override fun post(runnable: Runnable) {

    }

    override fun execute(command: Runnable) {

    }
}


