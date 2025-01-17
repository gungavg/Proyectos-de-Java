package com.example.auth_service_artifact.service;

import com.example.auth_service_artifact.comons.entities.UserModel;

public interface UserService {
    UserModel getUser(Long userId);
    UserInfoRequest deleteUser(UserInfoRequest userInfoRequest);
    UpdateUserRequest updateUser(Long userId, UpdateUserRequest updateUserRequest);
}
