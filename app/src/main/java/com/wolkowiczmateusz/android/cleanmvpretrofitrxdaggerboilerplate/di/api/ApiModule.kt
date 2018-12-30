package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.CustomApi
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.ErrorConverter
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ApiModule {

    @Provides
    fun provideCustomApi(retrofit: Retrofit): CustomApi {
        return retrofit.create(CustomApi::class.java)
    }

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {

        return Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create())
            client(client)
        }.build()
    }

    @Provides
    fun provideClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(REQUEST_TIMEOUT.toLong(), TimeUnit.SECONDS)
            .addNetworkInterceptor { chain ->
                val request = chain.request()
                val newRequest = request.newBuilder()
                    .addHeader("X-Parse-Application-Id", "kxYGXED4dFfmdM3rC5rwzADdd0tHd8ZCcvZaqy28")
                    .addHeader("X-Parse-REST-API-Key", "oNKhx7oB9RsoJ9XHby7ZKxiLcCxzrVrZNExf19SU")
                    .addHeader("X-Parse-Revocable-Session", "1")
                    .build()
                chain.proceed(newRequest)
            }
            .addNetworkInterceptor(loggingInterceptor).build()
    }

    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        return loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun provideErrorConverter(retrofit: Retrofit): ErrorConverter {
        return ErrorConverter(retrofit)
    }

    companion object {
        private const val BASE_URL = "https://parseapi.back4app.com/"
        private const val REQUEST_TIMEOUT = 5
    }
}