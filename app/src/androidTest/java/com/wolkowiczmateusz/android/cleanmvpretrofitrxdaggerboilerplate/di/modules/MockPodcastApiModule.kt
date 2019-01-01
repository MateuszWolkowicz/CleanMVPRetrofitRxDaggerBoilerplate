package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.di.modules

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.CustomApi
import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class MockPodcastApiModule {

    @Singleton // important ! Without it, it doesn't work
    @Provides
    fun provideCustomApi(retrofit: Retrofit): CustomApi {
        return mock(CustomApi::class.java)
    }
}
