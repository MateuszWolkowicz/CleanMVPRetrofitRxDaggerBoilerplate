package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.mapper;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.presentation.model.UserModel;

import javax.inject.Inject;

/**
 * Created by MateuszW on 2018-05-08.
 */
public class UserModelDataMapper {

    @Inject
    public UserModelDataMapper() {
    }

    public UserModel transformUserToUserModel(User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final UserModel userModel = new UserModel(user.getUserId());
        userModel.setSessionToken(user.getSessionToken());
        userModel.setUsername(user.getUsername());
        userModel.setEmail(user.getEmail());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        return userModel;
    }
}