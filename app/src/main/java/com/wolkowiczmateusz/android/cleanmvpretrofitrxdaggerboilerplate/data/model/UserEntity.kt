package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model

data class UserEntity(
    val userId: String?,
    var sessionToken: String? = null,
    var username: String? = null,
    var email: String? = null,
    var firstName: String? = null,
    var lastName: String? = null
) {

    val fullName: String
        get() = "$firstName $lastName"
}
