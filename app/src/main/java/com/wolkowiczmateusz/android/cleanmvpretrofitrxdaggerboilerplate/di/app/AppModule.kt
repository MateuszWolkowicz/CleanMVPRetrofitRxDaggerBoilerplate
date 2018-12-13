package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.preference.PreferenceManager
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.App
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.RepositoryImpl
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.device.sharedpreferences.UserStorage
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.repository.Repository
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    internal fun provideApp(): App {
        return app
    }

    @Provides
    @Singleton
    internal fun provideContext(): Context {
        return app
    }

    @Provides
    @Singleton
    internal fun provideResources(): Resources {
        return app.resources
    }

    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Singleton
    @Provides
    fun provideUserStorage(sharedPreferences: SharedPreferences): UserStorage {
        return UserStorage(sharedPreferences)
    }

    @Singleton
    @Provides
    internal fun provideRepository(repositoryImpl: RepositoryImpl): Repository {
        return repositoryImpl
    }

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}
