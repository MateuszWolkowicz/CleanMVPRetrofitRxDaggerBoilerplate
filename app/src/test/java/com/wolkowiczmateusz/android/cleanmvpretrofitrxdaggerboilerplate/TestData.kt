package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.response.UserResponse
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.UserEntity

object TestData {

    const val ERROR_MESSAGE = "error"
    val CORRECT_USER_ENTITY = correctTestUserEntity
    val CORRECT_USER_RESPONSE = correctTestUserResponse()

    private val correctTestUserEntity: UserEntity
        get() = UserEntity(
            "1", "token", "Mateusz",
            "wolkowicz.mateusz@gmail.com", "Mateusz", "Wołkowicz"
        )

    private fun correctTestUserResponse(): UserResponse {
        return UserResponse(
            username = "Mateusz",
            firstName = "Mateusz",
            lastName = "Wołkowicz",
            email = "wolkowicz.mateusz@gmail.com",
            objectId = "1",
            sessionToken = "token"
        )
    }
}
