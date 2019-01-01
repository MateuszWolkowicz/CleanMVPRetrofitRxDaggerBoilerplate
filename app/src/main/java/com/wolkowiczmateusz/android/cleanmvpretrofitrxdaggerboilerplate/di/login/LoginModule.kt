package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.login

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login.LoginContract
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login.LoginPresenter

import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginContract.View>)
        : LoginContract.Presenter<LoginContract.View> {
        return presenter
    }
}
