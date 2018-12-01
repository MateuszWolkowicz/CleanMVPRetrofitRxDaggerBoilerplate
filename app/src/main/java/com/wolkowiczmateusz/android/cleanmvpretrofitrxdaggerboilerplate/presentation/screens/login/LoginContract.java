package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base.BaseContractMvpPresenter;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base.BaseContractMvpView;


public interface LoginContract {

    interface View extends BaseContractMvpView {

        void disableLoginButton(boolean state);
        void showErrors(String errorEmail, String errorPassword);
        void showRegister();
        void Login();
    }

    interface Presenter<V extends View> extends BaseContractMvpPresenter<V> {

        void LoginClick(String email, String password);
        void RegisterClick();
    }
}
