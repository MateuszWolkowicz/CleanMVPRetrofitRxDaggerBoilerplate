package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.response.UserResponse
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User

object TestData {

    const val ERROR_MESSAGE = "error"
    val CORRECT_USER_ENTITY = ::correctTestUser
    val CORRECT_USER_RESPONSE = ::correctTestUserResponse

    val correctTestUser: User = User(
        "1", "token", "Mateusz",
        "wolkowicz.mateusz@gmail.com", "Mateusz", "Wołkowicz"
    )
    private val correctTestUserResponse: UserResponse = UserResponse(
        "Mateusz",
        "Mateusz",
        "Wołkowicz",
        "wolkowicz.mateusz@gmail.com",
        "1",
        "token"
    )
}

