package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.datasource;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.CustomApi;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper.UserEnitityMapper;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.UserEntity;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public class OnlineDataStore {

    private CustomApi customApi;
    private UserEnitityMapper userEnitityMapper;

    @Inject
    public OnlineDataStore(CustomApi customApi,
                           UserEnitityMapper userEnitityMapper) {
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

