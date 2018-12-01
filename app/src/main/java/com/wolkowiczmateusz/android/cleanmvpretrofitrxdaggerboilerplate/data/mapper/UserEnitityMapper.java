package com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.mapper;

import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.api.UserResponse;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.data.model.UserEntity;
import com.wolkowiczmateusz.android.cleanmvpretrofitrxdaggerboilerplate.domain.model.User;

import javax.inject.Inject;


public class UserEnitityMapper {

    @Inject
    public UserEnitityMapper() {
    }

    public UserEntity userResponseToEntity(final UserResponse userResponse) {
        if (userResponse == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final UserEntity user = new UserEntity(userResponse.objectId);
        user.setSessionToken(userResponse.sessionToken);
        user.setUsername(userResponse.username);
        user.setEmail(userResponse.email);
        user.setFirstName(userResponse.firstName);
        user.setLastName(userResponse.lastName);
        return user;
    }

    public User entityToDomain(final UserEntity userEntity) {
        if (userEntity == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final User user = new User(userEntity.getUserId());
        user.setSessionToken(userEntity.getSessionToken());
        user.setUsername(userEntity.getUsername());
        user.setEmail(userEntity.getEmail());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        return user;
    }

    public UserEntity domainToEntity(final User user) {
        if (user == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final UserEntity userEntity = new UserEntity(user.getUserId());
        userEntity.setSessionToken(user.getSessionToken());
        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        return userEntity;
    }
}
