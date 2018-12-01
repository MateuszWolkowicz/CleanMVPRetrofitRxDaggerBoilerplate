package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.components;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppComponent;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppModule;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.login.LoginModule;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.modules.MockCustomApiModule;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.modules.MockUseCaseModule;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.threading.ThreadingModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class,
        LoginModule.class,
        MockCustomApiModule.class,
        MockUseCaseModule.class,
        ThreadingModule.class,
})
public interface MockAppComponent extends AppComponent {
//    MockRegisterSubComponent newMockRegisterSubComponent(RegisterModule registerModule);
//    void inject(LoginActivityTest loginActivityTest);
}
