package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base;

import android.content.res.Resources;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.exception.CustomExceptions;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


public abstract class BasePresenter<V extends BaseContractMvpView> implements BaseContractMvpPresenter<V> {

    protected Executor threadExecutor;
    protected MainThread mainThread;
    private V mvpView;
    private CompositeDisposable compositeDisposable;
    @Inject
    Resources resources;
    @Inject
    CustomExceptions customExceptions;

    protected BasePresenter(Executor threadExecutor, MainThread mainThread, CompositeDisposable compositeDisposable) {
        this.threadExecutor = threadExecutor;
        this.mainThread = mainThread;
        this.compositeDisposable = compositeDisposable;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
        this.mvpView.attachPresenter(this);
    }

    @Override
    public void onDetach() {
        this.mvpView = null;
        //it is very important to follow the standard to clear Observables (other than RxBus)
        // when activity is destroyed
        compositeDisposable.clear();
    }

    protected boolean ViewIsConnected() {
        return getMvpView() != null;
    }

    protected V getMvpView() {
        return mvpView;
    }

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    protected Resources getResources() {
        return resources;
    }

    protected CustomExceptions getCustomExceptions() {
        return customExceptions;
    }
}
