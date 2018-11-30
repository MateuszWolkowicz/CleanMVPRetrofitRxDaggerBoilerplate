package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CustomApi {

    @GET("login")
    Observable<UserResponse> getLogin(@Query("username") String username, @Query("password") String password);
}
