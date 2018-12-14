package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.rxjava

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TrampolineSchedulerProvider : MainThread, Executor {

    override fun scheduler(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun post(runnable: Runnable) {}

    override fun execute(command: Runnable) {}
}
