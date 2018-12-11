package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate;

import android.app.Application;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppComponent;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppModule;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.DaggerAppComponent;

import timber.log.Timber;

public class App extends Application {

    public static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return component;
    }
}
