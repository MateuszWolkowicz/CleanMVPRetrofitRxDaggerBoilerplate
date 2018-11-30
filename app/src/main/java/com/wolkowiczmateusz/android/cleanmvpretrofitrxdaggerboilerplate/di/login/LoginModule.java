package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.login;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login.LoginContract;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login.LoginPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by MateuszW on 2018-04-07.
 */
@Module
public class LoginModule {

    @Provides
    LoginContract.Presenter<LoginContract.View> provideLoginPresenter(
            LoginPresenter<LoginContract.View> presenter) {
        return presenter;
    }

    public LoginModule() {
    }
}
