package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.App;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.ErrorConverter;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.RepositoryImpl;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.device.sharedpreferences.UserStorage;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.repository.Repository;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private static final String BASE_URL = "https://parseapi.back4app.com/";
    private static final int REQUEST_TIMEOUT = 5;
    private final App app;

    public AppModule(final App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    App provideApp() {
        return app;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return app;
    }

    @Provides
    @Singleton
    Resources provideResources() {
        return app.getResources();
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

    @Provides
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Singleton
    @Provides
    public UserStorage provideUserStorage(SharedPreferences sharedPreferences) {
        return new UserStorage(sharedPreferences);
    }

    @Singleton
    @Provides
    Repository provideRepository(RepositoryImpl repositoryImpl) {
        return repositoryImpl;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }
}
