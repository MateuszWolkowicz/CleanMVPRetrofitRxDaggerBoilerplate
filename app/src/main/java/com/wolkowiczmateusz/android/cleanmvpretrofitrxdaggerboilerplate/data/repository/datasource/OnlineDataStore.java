package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.datasource;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.CustomApi;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.ErrorConverter;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.UserResponse;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper.UserEnitityMapper;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.UserEntity;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.device.sharedpreferences.UserStorage;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import retrofit2.Call;

/**
 * Created by MateuszW on 2018-05-09.
 */
public class OnlineDataStore {

    private UserStorage userStorage;
    private ErrorConverter converter;
    private CustomApi customApi;
    private UserEnitityMapper userEnitityMapper;
    private Call<UserResponse> userResponseCall;

    @Inject
    public OnlineDataStore(UserStorage userStorage, ErrorConverter converter, CustomApi customApi,
                           UserEnitityMapper userEnitityMapper) {
        this.userStorage = userStorage;
        this.converter = converter;
        this.customApi = customApi;
        this.userEnitityMapper = userEnitityMapper;
    }

    public Observable<UserEntity> tryLogin(@NonNull String... params) {
        for (String param : params) {
            if (param == null) {
                throw new IllegalArgumentException("Any of each parameters can't be null");
            }
        }
        return customApi.getLogin(params[0], params[1])
                .map(userEnitityMapper::userResponseToEntity)
                .take(1);
    }
}

