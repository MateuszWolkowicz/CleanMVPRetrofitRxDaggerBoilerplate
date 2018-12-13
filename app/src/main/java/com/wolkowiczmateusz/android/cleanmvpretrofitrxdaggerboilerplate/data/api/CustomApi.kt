package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.response.UserResponse

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface CustomApi {

    @GET("login")
    fun getLogin(@Query("username") username: String, @Query("password") password: String): Observable<UserResponse>
}
