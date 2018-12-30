package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base

import android.arch.lifecycle.ViewModel
import android.content.res.Resources
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.exception.CustomExceptions
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

open class BaseViewModel protected constructor(
    protected var threadExecutor: Executor,
    protected var mainThread: MainThread,
    protected val compositeDisposable: CompositeDisposable
) : ViewModel() {

    @Inject
    protected lateinit var resources: Resources

    @Inject
    protected lateinit var customExceptions: CustomExceptions

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}