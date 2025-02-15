package com.example.user_service.service;

import com.example.common_library.entities.UserModel;
import com.example.user_service.commons.dtos.UpdateUserRequest;
import com.example.user_service.commons.dtos.UserInfoRequest;

public interface UserService {
    UserModel getUser(Long userId);
    UserInfoRequest deleteUser(UserInfoRequest userInfoRequest);
    UpdateUserRequest updateUser(Long userId, UpdateUserRequest updateUserRequest);
}
