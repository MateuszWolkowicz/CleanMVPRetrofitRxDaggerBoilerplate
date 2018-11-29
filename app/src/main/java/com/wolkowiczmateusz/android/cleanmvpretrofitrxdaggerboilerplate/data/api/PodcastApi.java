package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PodcastApi {
    @GET("login")
    Observable<UserResponse> getLogin(@Query("username") String username, @Query("password") String password);

}
