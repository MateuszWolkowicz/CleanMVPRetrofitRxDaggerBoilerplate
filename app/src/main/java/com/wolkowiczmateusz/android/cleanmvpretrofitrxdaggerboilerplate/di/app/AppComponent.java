package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.api.ApiModule;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.login.LoginModule;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.threading.ThreadingModule;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.usecases.UseCasesModule;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.login.LoginActivity;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.screens.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,
        LoginModule.class,
        ApiModule.class,
        UseCasesModule.class,
        ThreadingModule.class,
})
public interface AppComponent {

    void inject(MainActivity activity);
    void inject(LoginActivity loginActivity);
}
