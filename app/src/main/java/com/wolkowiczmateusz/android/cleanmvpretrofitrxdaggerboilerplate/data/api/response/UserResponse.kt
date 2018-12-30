package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.response

data class UserResponse(
    val username: String,
    val objectId: String,
    val email: String,
    val firstName: String,
    val lastName: String,
    val sessionToken: String
)
