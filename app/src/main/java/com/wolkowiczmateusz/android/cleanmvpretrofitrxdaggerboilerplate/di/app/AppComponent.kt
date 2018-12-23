package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.api.ApiModule
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.threading.ThreadingModule
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.usecases.UseCasesModule
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.viewmodels.ViewModelFactoryModule
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login.mvvm.LoginActivity
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    ApiModule::class,
    UseCasesModule::class,
    ThreadingModule::class,
    ViewModelFactoryModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)
    fun inject(loginActivity: LoginActivity)
}
