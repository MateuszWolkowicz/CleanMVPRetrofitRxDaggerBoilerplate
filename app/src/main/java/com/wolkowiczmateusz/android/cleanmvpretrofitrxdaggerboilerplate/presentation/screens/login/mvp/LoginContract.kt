package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login.mvp

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base.BaseContractMvpPresenter
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base.BaseContractMvpView

interface LoginContract {

    interface View : BaseContractMvpView {

        fun disableLoginButton(state: Boolean)
        fun showErrors(errorEmail: String?, errorPassword: String?)
        fun showRegister()
        fun login()
    }

    interface Presenter<V : View> : BaseContractMvpPresenter<V> {

        fun loginClick(email: String, password: String)
        fun registerClick()
    }
}
