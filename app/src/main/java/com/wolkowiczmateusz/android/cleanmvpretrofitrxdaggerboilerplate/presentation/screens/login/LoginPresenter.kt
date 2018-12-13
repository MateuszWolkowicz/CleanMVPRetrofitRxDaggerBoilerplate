package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.R
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.TryToLoginUseCase
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base.BasePresenter
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.wrappers.EmailMatcherWrapper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class LoginPresenter<V : LoginContract.View> @Inject
constructor(threadExecutor: Executor, mainThread: MainThread,
            compositeDisposable: CompositeDisposable) : BasePresenter<V>(threadExecutor, mainThread, compositeDisposable), LoginContract.Presenter<V> {

    @Inject
    lateinit var tryToLoginUseCase: TryToLoginUseCase

    private val emailMatcherWrapper: EmailMatcherWrapper = EmailMatcherWrapper()

    override fun loginClick(email: String, password: String) {
        if (email == null || password == null) {
            throw IllegalArgumentException("Email or Password can't be null")
        }
        var hasErrors = false
        val emailError: String?
        val passwordError: String?
        if (email.isEmpty()) {
            emailError = resources.getString(R.string.this_field_cant_be_empty)
            hasErrors = true
        } else if (emailNotValid(email)) {
            emailError = resources.getString(R.string.not_an_email)
            hasErrors = true
        } else {
            emailError = null
        }
        if (password.isEmpty()) {
            passwordError = resources.getString(R.string.this_field_cant_be_empty)
            hasErrors = true
        } else if (password.length < 6) {
            passwordError = resources.getString(R.string.password_too_short)
            hasErrors = true
        } else {
            passwordError = null
        }
        if (!hasErrors) {
            tryLogin(email, password)
        }
        if (isViewConnected()) {
            getMvpView()?.showErrors(emailError, passwordError)
        }
    }

    override fun registerClick() {
        getMvpView()?.showRegister()
    }

    private fun emailNotValid(email: String): Boolean {
        return !emailMatcherWrapper.isEmailValid(email)
    }

    private fun tryLogin(username: String, password: String) {
        compositeDisposable.add(
                tryToLoginUseCase.runUseCase(username, password)
                        .subscribeOn(threadExecutor.scheduler())
                        .observeOn(mainThread.scheduler())
                        .doOnSubscribe { v ->
                            getMvpView()?.disableLoginButton(true)
                            getMvpView()?.showProgressDialog(resources.getString(R.string.please_wait), false, false)
                        }
                        .doOnEach { v ->
                            getMvpView()?.hideProgressDialog()
                            getMvpView()?.disableLoginButton(false)
                        }
                        .subscribeWith(LoginObserver())
        )
    }

    private inner class LoginObserver : DisposableObserver<User>() {

        override fun onNext(msg: User) {
            if (isViewConnected()) {
                getMvpView()?.login()
            }
        }

        override fun onError(throwable: Throwable) {
            if (isViewConnected()) {
                getMvpView()?.showError(customExceptions.getException(throwable))
            }
        }

        override fun onComplete() {}
    }
}







