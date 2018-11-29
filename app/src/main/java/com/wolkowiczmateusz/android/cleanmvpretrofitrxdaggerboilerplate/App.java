package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate;

import android.app.Application;
import android.content.Context;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppComponent;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppModule;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.DaggerAppComponent;

import timber.log.Timber;

/**
 * Created by MateuszW on 2018-03-31.
 */
public class App extends Application {

    public static AppComponent component;
    private static Context context;

    public static App from(final Context context) {
        return (App) context.getApplicationContext();
    }

    public void getNonStaticContext() {
        App.getContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        context = this;
    }

    public AppComponent getAppComponent() {
        return component;
    }

    public static Context getContext() {
        return context;
    }
}
