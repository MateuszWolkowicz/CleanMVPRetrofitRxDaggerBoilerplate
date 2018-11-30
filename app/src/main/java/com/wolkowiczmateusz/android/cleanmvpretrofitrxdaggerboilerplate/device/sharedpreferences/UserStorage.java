package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.device.sharedpreferences;

import android.content.SharedPreferences;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.UserEntity;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by MateuszW on 2018-03-31.
 */
public class UserStorage {

    private static final String SESSION_TOKEN = "sessionToken";
    private static final String USERNAME = "username";
    private static final String EMAIL = "email";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String USER_ID = "userId";
    private final SharedPreferences preferences;

    public UserStorage(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public void saveUser(UserEntity user) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(SESSION_TOKEN, user.getSessionToken());
        editor.putString(USERNAME, user.getUsername());
        editor.putString(EMAIL, user.getEmail());
        editor.putString(FIRST_NAME, user.getFirstName());
        editor.putString(LAST_NAME, user.getLastName());
        editor.putString(USER_ID, user.getUserId());
        editor.apply();
    }

    public UserEntity getUser() {
        final UserEntity userEntity = new UserEntity(preferences.getString(USER_ID, ""));
        userEntity.setSessionToken(preferences.getString(SESSION_TOKEN, ""));
        userEntity.setUsername(preferences.getString(USERNAME, ""));
        userEntity.setEmail(preferences.getString(EMAIL, ""));
        userEntity.setFirstName(preferences.getString(FIRST_NAME, ""));
        userEntity.setLastName(preferences.getString(LAST_NAME, ""));
        return userEntity;
    }

    public Single<Boolean> isUserLogin() {
        return Single.defer(() -> Single.just(!preferences.getString(SESSION_TOKEN, "").isEmpty()));
    }

    public Completable logout() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        return Completable.complete();
    }

    public String getEmail() {
        return preferences.getString(EMAIL, "");
    }

    public String getUserId() {
        return preferences.getString(USER_ID, "");
    }

    public String getToken() {
        return preferences.getString(SESSION_TOKEN, "");
    }
}
