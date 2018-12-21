package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model

class User(val userId: String?,
           var sessionToken: String,
           var username: String,
           var email: String,
           var firstName: String,
           var lastName: String) {


    val fullName: String
        get() = "$firstName $lastName"
}