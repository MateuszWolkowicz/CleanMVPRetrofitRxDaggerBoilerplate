package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.mapper

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.model.UserModel

import javax.inject.Inject

class UserModelDataMapper @Inject
constructor() {

    fun transformUserToUserModel(user: User?): UserModel {
        if (user == null) {
            throw IllegalArgumentException("Cannot transform a null value")
        }
        val userModel = UserModel(user.userId, "", "", "", "", "")
        userModel.sessionToken = user.sessionToken
        userModel.username = user.username
        userModel.email = user.email
        userModel.firstName = user.firstName
        userModel.lastName = user.lastName
        return userModel
    }
}
