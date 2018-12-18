package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base

import android.content.res.Resources
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.exception.CustomExceptions
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract class BasePresenter<V : BaseContractMvpView> protected constructor(protected var threadExecutor: Executor, protected var mainThread: MainThread, protected val compositeDisposable: CompositeDisposable) : BaseContractMvpPresenter<V> {

    protected var mvpView: V? = null

    @Inject
    protected lateinit var resources: Resources

    @Inject
    protected lateinit var customExceptions: CustomExceptions

    override fun onAttach(mvpView: V) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        this.mvpView = null
        //it is very important to follow the standard to clear Observables (other than RxBus)
        // when activity is destroyed
        compositeDisposable.clear()
    }
}
