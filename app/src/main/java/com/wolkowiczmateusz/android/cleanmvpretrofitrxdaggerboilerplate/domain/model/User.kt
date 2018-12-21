package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model

class User(val userId: String,
           val sessionToken: String,
           val username: String,
           val email: String,
           val firstName: String,
           val lastName: String) {


    val fullName: String
        get() = "$firstName $lastName"
}