package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate

import android.app.Application
import com.crashlytics.android.Crashlytics

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppComponent
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppModule
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.DaggerAppComponent
import io.fabric.sdk.android.Fabric

import timber.log.Timber

open class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        Fabric.with(this, Crashlytics())
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }


}
