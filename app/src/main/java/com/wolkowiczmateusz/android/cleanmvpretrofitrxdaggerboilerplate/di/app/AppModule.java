package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.App;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.repository.RepositoryImpl;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.device.sharedpreferences.UserStorage;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class AppModule {

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
