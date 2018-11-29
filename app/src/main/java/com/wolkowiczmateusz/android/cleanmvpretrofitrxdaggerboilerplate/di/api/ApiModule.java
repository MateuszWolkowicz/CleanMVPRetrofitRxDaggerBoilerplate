package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.api;


import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.PodcastApi;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    public PodcastApi providePodcastApi(Retrofit retrofit) {
        return retrofit.create(PodcastApi.class);
    }
}