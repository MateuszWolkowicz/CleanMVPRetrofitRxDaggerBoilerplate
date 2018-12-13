package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading

import android.os.Handler
import android.os.Looper

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

object MainThreadImpl : MainThread {
    private val handler: Handler = Handler(Looper.getMainLooper())

    override fun scheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun post(runnable: Runnable) {
        handler.post(runnable)
    }

}
