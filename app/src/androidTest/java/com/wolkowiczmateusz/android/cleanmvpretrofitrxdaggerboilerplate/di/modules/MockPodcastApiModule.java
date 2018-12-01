package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.modules;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.CustomApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

import static org.mockito.Mockito.mock;

@Module
public class MockCustomApiModule {

    @Singleton //important ! Without it, it doesn't work
    @Provides
    public CustomApi provideCustomApi(Retrofit retrofit) {
        return mock(CustomApi.class);
    }
}
