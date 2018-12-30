package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.rxjavatest

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by MateuszW on 2018-06-25.
 */

class TrampolineSchedulerProvider : MainThread, Executor {

    override fun scheduler(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun post(runnable: Runnable) {
    }

    override fun execute(command: Runnable) {
    }
}
