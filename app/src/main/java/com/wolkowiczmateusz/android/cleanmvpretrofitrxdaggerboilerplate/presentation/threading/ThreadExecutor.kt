package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

object ThreadExecutor : Executor {
    private val threadPoolExecutor: ThreadPoolExecutor

    private val CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors()
    private val MAX_POOL_SIZE = CORE_POOL_SIZE * 2
    private val KEEP_ALIVE_TIME = 120
    private val TIME_UNIT = TimeUnit.SECONDS
    private val WORK_QUEUE = LinkedBlockingQueue<Runnable>()

    init {
        val keepAlive = KEEP_ALIVE_TIME.toLong()
        threadPoolExecutor = ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                keepAlive,
                TIME_UNIT,
                WORK_QUEUE)
    }

    override fun execute(command: Runnable) {
        threadPoolExecutor.submit(command)
    }

    override fun scheduler(): Scheduler {
        return Schedulers.from(this)
    }

}
