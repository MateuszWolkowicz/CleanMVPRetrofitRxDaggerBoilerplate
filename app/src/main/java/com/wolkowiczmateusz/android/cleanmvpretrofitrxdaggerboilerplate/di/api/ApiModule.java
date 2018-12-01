package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.CustomApi;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.ErrorConverter;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    private static final String BASE_URL = "https://parseapi.back4app.com/";
    private static final int REQUEST_TIMEOUT = 5;

    @Provides
    public CustomApi provideCustomApi(Retrofit retrofit) {
        return retrofit.create(CustomApi.class);
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient client) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.client(client);
        return builder.build();
    }

    @Provides
    public OkHttpClient provideClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .addNetworkInterceptor(chain -> {
                    Request request = chain.request();
                    Request newRequest = request.newBuilder()
                            .addHeader("X-Parse-Application-Id", "kxYGXED4dFfmdM3rC5rwzADdd0tHd8ZCcvZaqy28")
                            .addHeader("X-Parse-REST-API-Key", "oNKhx7oB9RsoJ9XHby7ZKxiLcCxzrVrZNExf19SU")
                            .addHeader("X-Parse-Revocable-Session", "1")
                            .build();
                    return chain.proceed(newRequest);
                })
                .addNetworkInterceptor(loggingInterceptor).build();
    }

    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        return loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    public ErrorConverter provideErrorConverter(Retrofit retrofit) {
        return new ErrorConverter(retrofit);
    }
}