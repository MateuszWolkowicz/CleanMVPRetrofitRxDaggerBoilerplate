package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.repository;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by MateuszW on 2018-05-07.
 */
public interface Repository {

    Single<User> getLoginUser();
    Completable logoutUser();
    Single<Boolean> isUserLogin();
    Observable<User> tryLogin(String... params);
}
