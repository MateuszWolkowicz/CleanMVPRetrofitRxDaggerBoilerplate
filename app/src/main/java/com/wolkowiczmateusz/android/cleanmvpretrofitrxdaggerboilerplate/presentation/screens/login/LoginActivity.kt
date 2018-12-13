package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login

import android.content.Intent
import android.os.Bundle
import com.crashlytics.android.Crashlytics
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.App
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.R
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base.BaseActivity
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.main.MainActivity
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    lateinit var loginPresenter: LoginContract.Presenter<LoginContract.View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fabric.with(this, Crashlytics())
        setContentView(R.layout.activity_login)
        (application as App).appComponent
                .inject(this)
        loginPresenter.onAttach(this)
        setOnClickListeners()
    }

    override fun onDestroy() {
        loginPresenter.onDetach()
        super.onDestroy()
    }

    private fun setOnClickListeners() {
        loginButton.setOnClickListener { loginPresenter.loginClick(emailEditText.text.toString(), passwordEditText.text.toString()) }
        registerButton.setOnClickListener { loginPresenter.registerClick() }
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
        finish()
    }
}
