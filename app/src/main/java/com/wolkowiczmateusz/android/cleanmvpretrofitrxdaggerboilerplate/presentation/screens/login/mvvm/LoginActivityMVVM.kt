package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login.mvvm

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.App
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.R
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base.BaseActivity
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.customviews.hideKeyboard
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.model.Errors
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivityMVVM : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var loginViewModel: LoginViewModel

    override val layoutId: Int
        get() = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnClickListeners()
    }

    override fun initializeDagger() {
        val app = applicationContext as App
        app.appComponent.inject(this)
    }

    override fun attachPresenter() {
        loginViewModel = ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
        loginViewModel.login.observe(this, Observer { loginState(it) })
        loginViewModel.errors.observe(this, Observer { showErrors(it) })
    }


    private fun loginState(resource: Resource<Boolean>?) {
        resource?.let {
            when (it.state) {
                ResourceState.LOADING -> renderLoading()
                ResourceState.SUCCESS -> renderSuccess()
                ResourceState.ERROR -> renderError()
            }
            it.data?.let { it -> showData(it) }
            it.message?.let { it -> showError(it) }
        }
    }

    private fun showData(it: Boolean) {
        it.let { login() }
    }

    private fun renderError() {
        disableLoginButton(false)
        hideProgressDialog()
    }

    private fun renderSuccess() {
        disableLoginButton(false)
        hideProgressDialog()
    }

    private fun renderLoading() {
        disableLoginButton(true)
        showProgressDialog(resources.getString(R.string.please_wait), true, true)
    }

    override fun detachPresenter() {
    }

    private fun setOnClickListeners() {
        loginButton.setOnClickListener {
            tryLogin()
                    .also { this.hideKeyboard() }
        }
        registerButton.setOnClickListener { showRegister() }
    }

    private fun tryLogin() {
        loginViewModel.loginClick(emailEditText.text.toString(), passwordEditText.text.toString())
    }

    private fun disableLoginButton(state: Boolean) {
        loginButton.isEnabled = !state
    }

    private fun showErrors(errors: Errors?) {
        errors?.let {
            passwordTextInputLayout.error = errors.passwordError
            emailTextInputLayout.error = errors.emailError
        }
    }

    private fun showRegister() {

    }

    fun login() {
        startActivity(Intent(this, MainActivity::class.java))
                .also { finish() }
    }

}
