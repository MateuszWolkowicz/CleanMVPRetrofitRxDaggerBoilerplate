package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.response

data class UserResponse(
        var username: String? = null,
        var objectId: String? = null,
        var email: String? = null,
        var firstName: String? = null,
        var lastName: String? = null,
        var sessionToken: String? = null
)
