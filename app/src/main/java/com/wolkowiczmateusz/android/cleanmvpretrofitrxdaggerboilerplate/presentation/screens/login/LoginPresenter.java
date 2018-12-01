package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.R;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.executor.MainThread;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.TryToLoginUseCase;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.base.BasePresenter;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.threading.Executor;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.wrappers.EmailMatcherWrapper;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class LoginPresenter<V extends LoginContract.View>
        extends BasePresenter<V>
        implements LoginContract.Presenter<V> {

    @Inject
    TryToLoginUseCase tryToLoginUseCase;
    private EmailMatcherWrapper emailMatcherWrapper;

    @Inject
    public LoginPresenter(Executor threadExecutor, MainThread mainThread,
                          TryToLoginUseCase tryToLoginUseCase,
                          CompositeDisposable compositeDisposable) {
        super(threadExecutor, mainThread, compositeDisposable);
        this.tryToLoginUseCase = tryToLoginUseCase;
        emailMatcherWrapper = new EmailMatcherWrapper();
    }

    @Override
    public void LoginClick(String email, String password) {
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email or Password can't be null");
        }
        boolean hasErrors = false;
        String emailError;
        String passwordError;
        if (email.isEmpty()) {
            emailError = getResources().getString(R.string.this_field_cant_be_empty);
            hasErrors = true;
        } else if (emailNotValid(email)) {
            emailError = getResources().getString(R.string.not_an_email);
            hasErrors = true;
        } else {
            emailError = null;
        }
        if (password.isEmpty()) {
            passwordError = getResources().getString(R.string.this_field_cant_be_empty);
            hasErrors = true;
        } else if (password.length() < 6) {
            passwordError = getResources().getString(R.string.password_too_short);
            hasErrors = true;
        } else {
            passwordError = null;
        }
        if (!hasErrors) {
            tryLogin(email, password);
        }
        if (ViewIsConnected()) {
            getMvpView().showErrors(emailError, passwordError);
        }
    }

    @Override
    public void RegisterClick() {
        getMvpView().showRegister();
    }

    private boolean emailNotValid(String email) {
        return !emailMatcherWrapper.isEmailValid(email);
    }

    private void tryLogin(String username, String password) {
        getCompositeDisposable().add(
                tryToLoginUseCase.runUseCase(username, password)
                        .subscribeOn(threadExecutor.scheduler())
                        .observeOn(mainThread.scheduler())
                        .doOnSubscribe(v -> {
                            getMvpView().disableLoginButton(true);
                            getMvpView().showProgressDialog(getResources().getString(R.string.please_wait), false, false);
                        })
                        .doOnEach(v -> {
                            getMvpView().hideProgressDialog();
                            getMvpView().disableLoginButton(false);
                        })
                        .subscribeWith(new LoginObserver())
        );
    }

    private final class LoginObserver extends DisposableObserver<User> {

        @Override
        public void onNext(User msg) {
            if (ViewIsConnected()) {
                getMvpView().Login();
            }
        }

        @Override
        public void onError(Throwable throwable) {
            if (ViewIsConnected()) {
                getMvpView().showError(getCustomExceptions().getException(throwable));
            }
        }

        @Override
        public void onComplete() {
        }
    }
}







