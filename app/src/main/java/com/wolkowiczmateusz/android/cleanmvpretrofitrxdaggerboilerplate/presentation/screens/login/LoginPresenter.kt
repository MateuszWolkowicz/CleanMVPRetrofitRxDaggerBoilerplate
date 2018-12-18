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

    var emailMatcherWrapper: EmailMatcherWrapper = EmailMatcherWrapper()

    override fun loginClick(email: String, password: String) {
        var hasErrors = false
        val emailError: String?
        val passwordError: String?
        when {
            email.isEmpty() -> {
                emailError = resources.getString(R.string.this_field_cant_be_empty)
                hasErrors = true
            }
            emailNotValid(email) -> {
                emailError = resources.getString(R.string.not_an_email)
                hasErrors = true
            }
            else -> emailError = null
        }
        when {
            password.isEmpty() -> {
                passwordError = resources.getString(R.string.this_field_cant_be_empty)
                hasErrors = true
            }
            password.length < 6 -> {
                passwordError = resources.getString(R.string.password_too_short)
                hasErrors = true
            }
            else -> passwordError = null
        }
        if (!hasErrors) {
            tryLogin(email, password)
        }
        mvpView?.showErrors(emailError, passwordError)
    }

    override fun registerClick() {
        mvpView?.showRegister()
    }

    private fun emailNotValid(email: String): Boolean {
        return !emailMatcherWrapper.isEmailValid(email)
    }

    fun tryLogin(username: String, password: String) {
        compositeDisposable.add(
                tryToLoginUseCase.runUseCase(username, password)
                        .subscribeOn(threadExecutor.scheduler())
                        .observeOn(mainThread.scheduler())
                        .doOnSubscribe { v ->
                            mvpView?.disableLoginButton(true)
                            mvpView?.showProgressDialog(resources.getString(R.string.please_wait), true, true)
                        }
                        .doOnEach { v ->
                            mvpView?.hideProgressDialog()
                            mvpView?.disableLoginButton(false)
                        }
                        .subscribeWith(LoginObserver())
        )
    }

    private inner class LoginObserver : DisposableObserver<User>() {

        override fun onNext(msg: User) {
            mvpView?.login()
        }

        override fun onError(throwable: Throwable) {
            mvpView?.showError(customExceptions.getException(throwable))
        }

        override fun onComplete() {}
    }
}







