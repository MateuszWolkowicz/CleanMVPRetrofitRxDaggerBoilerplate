package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.datasource;


import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.ErrorConverter;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.PodcastApi;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.UserResponse;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper.UserEnitityMapper;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.UserEntity;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.device.sharedpreferences.UserStorage;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by MateuszW on 2018-05-09.
 */
public class OnlineDataStore {

    private final Retrofit retrofit;
    private UserStorage userStorage;
    private ErrorConverter converter;
    private PodcastApi podcastApi;
    private UserEnitityMapper userEnitityMapper;
    private Call<UserResponse> userResponseCall;


    @Inject
    public OnlineDataStore(UserStorage userStorage, ErrorConverter converter, PodcastApi podcastApi,
                           Retrofit retrofit, UserEnitityMapper userEnitityMapper) {
        this.userStorage = userStorage;
        this.converter = converter;
        this.podcastApi = podcastApi;
        this.retrofit = retrofit;
        this.userEnitityMapper = userEnitityMapper;
    }

    public Observable<UserEntity> tryLogin(@NonNull String... params) {
        for (String param : params) {
            if (param == null) {
                throw new IllegalArgumentException("Any of each parameters can't be null");
            }
        }
        return podcastApi.getLogin(params[0], params[1])
                .map(userEnitityMapper::userResponseToEntity)
                .take(1);
    }

}

