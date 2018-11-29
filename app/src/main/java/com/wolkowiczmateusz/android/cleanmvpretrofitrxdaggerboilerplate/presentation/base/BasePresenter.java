package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base;

import android.content.res.Resources;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.exception.CustomExceptions;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by MateuszW on 2018-04-11.
 */
public abstract class BasePresenter<V extends BaseContractMvpView> implements BaseContractMvpPresenter<V> {

    protected Executor threadExecutor;
    protected MainThread mainThread;
    private V mvpView;
    private CompositeDisposable compositeDisposable;
    @Inject
    Resources resources;
    @Inject
    CustomExceptions customExceptions;

    public BasePresenter(Executor threadExecutor, MainThread mainThread, CompositeDisposable compositeDisposable) {
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

    public V getMvpView() {
        return mvpView;
    }

    public boolean ViewIsConnected() {
        return getMvpView() != null;
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public Resources getResources() {
        return resources;
    }

    public CustomExceptions getCustomExceptions() {
        return customExceptions;
    }
}
