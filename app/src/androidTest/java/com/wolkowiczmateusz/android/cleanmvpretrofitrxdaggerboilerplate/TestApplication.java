package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppComponent;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppModule;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.components.MockAppComponent;

public class TestApplication extends App {

    private MockAppComponent mockAppComponent;

    public MockAppComponent getMockAppComponent() {
        return (MockAppComponent) getAppComponent();
    }

    @Override
    public AppComponent getAppComponent() {
        if (mockAppComponent == null) {
            mockAppComponent = DaggerMockAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return mockAppComponent;
    }
}
