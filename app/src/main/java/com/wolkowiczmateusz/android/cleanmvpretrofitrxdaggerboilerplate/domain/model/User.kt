package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model

class User(val userId: String) {

    var sessionToken: String? = null
    var username: String? = null
    var email: String? = null
    var firstName: String? = null
    var lastName: String? = null

    val fullName: String
        get() = "$firstName $lastName"
}