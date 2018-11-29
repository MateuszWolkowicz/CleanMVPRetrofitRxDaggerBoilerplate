package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.Impl;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.interactors.TryToLoginUseCase;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.repository.Repository;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by MateuszW on 2018-05-23.
 */
public class TryToLoginUseCaseImpl implements TryToLoginUseCase {

    private Repository repository;

    @Inject
    public TryToLoginUseCaseImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<User> runUseCase(String... params) {
        return repository.tryLogin(params);
    }
}
