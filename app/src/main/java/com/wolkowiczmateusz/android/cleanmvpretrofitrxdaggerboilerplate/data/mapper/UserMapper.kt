package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.response.UserResponse
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User
import javax.inject.Inject

/**
 * Created by MateuszW on 2018-05-08.
 */
class UserMapper @Inject constructor() {

    fun userResponseToUser(userResponse: UserResponse): User {
        return User(
                userResponse.objectId,
                userResponse.sessionToken,
                userResponse.username,
                userResponse.email,
                userResponse.firstName,
                userResponse.lastName
        )
    }
}
