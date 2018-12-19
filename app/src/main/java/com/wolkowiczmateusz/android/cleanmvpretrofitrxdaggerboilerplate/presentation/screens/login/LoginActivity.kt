package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login

import android.content.Intent
import android.os.Bundle
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.App
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.R
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base.BaseActivity
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.hideKeyboard
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {


    override val layoutId: Int
        get() = R.layout.activity_login

    @Inject
    lateinit var loginPresenter: LoginContract.Presenter<LoginContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnClickListeners()
    }

    override fun initializeDagger() {
        val app = applicationContext as App
        app.appComponent.inject(this)
    }

    override fun attachPresenter() {
        loginPresenter.onAttach(this)
    }

    override fun detachPresenter() {
        loginPresenter.onDetach()
    }

    private fun setOnClickListeners() {
        loginButton.setOnClickListener {
            tryLogin()
                    .also { this.hideKeyboard() }
        }
        registerButton.setOnClickListener { loginPresenter.registerClick() }
    }

    private fun tryLogin() {
        loginPresenter.loginClick(emailEditText.text.toString(), passwordEditText.text.toString())
    }

    override fun disableLoginButton(state: Boolean) {
        loginButton.isEnabled = !state
    }

    override fun showErrors(errorEmail: String?, errorPassword: String?) {
        passwordTextInputLayout.error = errorPassword
        emailTextInputLayout.error = errorEmail
    }

    override fun showRegister() {}

    override fun login() {
        startActivity(Intent(this, MainActivity::class.java))
                .also { finish() }
    }
}
