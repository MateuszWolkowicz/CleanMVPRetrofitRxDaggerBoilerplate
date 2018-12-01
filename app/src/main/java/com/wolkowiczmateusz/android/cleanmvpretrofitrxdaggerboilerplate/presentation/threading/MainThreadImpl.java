package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading;

import android.os.Handler;
import android.os.Looper;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;


public class MainThreadImpl implements MainThread {

    private MainThreadImpl() {
        handler = new Handler(Looper.getMainLooper());
    }

    @Override
    public Scheduler scheduler() {
        return AndroidSchedulers.mainThread();
    }

    private static MainThread sMainThread;
    private Handler handler;

    @Override
    public void post(Runnable runnable) {
        handler.post(runnable);
    }

    public static MainThread getInstance() {
        if (sMainThread == null) {
            sMainThread = new MainThreadImpl();
        }
        return sMainThread;
    }
}
