package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.response.UserResponse
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.UserEntity
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User

import javax.inject.Inject

class UserEntityMapper @Inject
constructor() {

    fun userResponseToEntity(userResponse: UserResponse?): UserEntity {
        if (userResponse == null) {
            throw IllegalArgumentException("Cannot transform a null value")
        }
        return UserEntity(
            userResponse.objectId,
            userResponse.sessionToken,
            userResponse.username,
            userResponse.email,
            userResponse.firstName,
            userResponse.lastName
        )
    }

    fun entityToDomain(userEntity: UserEntity?): User {
        if (userEntity == null) {
            throw IllegalArgumentException("Cannot transform a null value")
        }
        return User(
            userEntity.userId,
            userEntity.sessionToken!!,
            userEntity.username!!,
            userEntity.email!!,
            userEntity.firstName!!,
            userEntity.lastName!!
        )
    }

    fun domainToEntity(user: User?): UserEntity {
        if (user == null) {
            throw IllegalArgumentException("Cannot transform a null value")
        }
        return UserEntity(
            user.userId,
            user.sessionToken,
            user.username,
            user.email,
            user.firstName,
            user.lastName
        )
    }
}
