package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.datasource;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.UserEntity;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.device.sharedpreferences.UserStorage;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;


public class OfflineDataStore {

    private UserStorage userStorage;

    @Inject
    public OfflineDataStore(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public UserEntity getLoginUser() {
        return userStorage.getUser();
    }

    public Completable logout() {
        return userStorage.logout();
    }

    public Single<Boolean> isUserLogin() {
        return Single.defer(userStorage::isUserLogin);
    }

    public void saveUserToStorage(UserEntity userEntity) {
        userStorage.saveUser(userEntity);
    }
}
