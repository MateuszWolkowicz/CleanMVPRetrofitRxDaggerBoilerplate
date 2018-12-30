package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppComponent
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.app.AppModule
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.components.MockAppComponent

class TestApplication : App() {

    lateinit var mockAppComponent: MockAppComponent

    override var appComponent: AppComponent
        get() {
            if (mockAppComponent == null) {
                mockAppComponent = DaggerMockAppComponent.builder()
                    .appModule(AppModule(this))
                    .build()
            }
            return mockAppComponent
        }
        set(value) {
            super.appComponent = value
        }
}
