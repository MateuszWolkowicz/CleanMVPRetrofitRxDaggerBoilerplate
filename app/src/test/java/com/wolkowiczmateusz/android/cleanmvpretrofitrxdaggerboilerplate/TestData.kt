package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.response.UserResponse
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.UserEntity

object TestData {

    const val ERROR_MESSAGE = "error"
    val CORRECT_USER_ENTITY = correctTestUserEntity
    val CORRECT_USER_RESPONSE = correctTestUserResponse

    private val correctTestUserEntity: UserEntity
        get() = UserEntity("1", "token", "Mateusz",
                "wolkowicz.mateusz@gmail.com", "Mateusz", "Wołkowicz")
    private val correctTestUserResponse: UserResponse
        get() {
            val userResponse = UserResponse()
            userResponse.username = "Mateusz"
            userResponse.firstName = "Mateusz"
            userResponse.lastName = "Wołkowicz"
            userResponse.email = "wolkowicz.mateusz@gmail.com"
            userResponse.objectId = "1"
            userResponse.sessionToken = "token"
            return userResponse
        }
}
