package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login.mvvm

import android.arch.lifecycle.MutableLiveData
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.R
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.TryToLoginUseCase
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base.BaseViewModel
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.model.Errors
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.wrappers.EmailMatcherWrapper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class LoginViewModel
@Inject constructor(threadExecutor: Executor,
                    mainThread: MainThread,
                    compositeDisposable: CompositeDisposable)
    : BaseViewModel(threadExecutor, mainThread, compositeDisposable) {

    val login = MutableLiveData<Resource<Boolean>>()
    val errors = MutableLiveData<Errors>()

    @Inject
    lateinit var tryToLoginUseCase: TryToLoginUseCase

    private var emailMatcherWrapper: EmailMatcherWrapper = EmailMatcherWrapper()

    fun loginClick(email: String, password: String) {
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
        errors.postValue(Errors(emailError, passwordError))
    }


    private fun emailNotValid(email: String): Boolean {
        return !emailMatcherWrapper.isEmailValid(email)
    }

    fun tryLogin(username: String, password: String) {
        compositeDisposable.add(
                tryToLoginUseCase.runUseCase(username, password)
                        .subscribeOn(threadExecutor.scheduler())
                        .observeOn(mainThread.scheduler())
                        .doOnSubscribe {
                            login.setLoading()
                        }
                        .subscribeWith(LoginObserver())
        )
    }

    private inner class LoginObserver : DisposableObserver<User>() {

        override fun onNext(msg: User) {
            login.setSuccess(true)
        }

        override fun onError(throwable: Throwable) {
            login.setError(customExceptions.getException(throwable))
        }

        override fun onComplete() {}
    }

}