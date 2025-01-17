package com.example.auth_service_artifact.controller.Impl;

import com.example.auth_service_artifact.comons.entities.UserModel;
import com.example.auth_service_artifact.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Override
    public ResponseEntity<UserModel> getUser(Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }

    @Override
    public ResponseEntity<UserModel> deleteUser(UserInfoRequest userInfoRequest) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserModel> updateUser(Long userId, UpdateUserRequest updateUserRequest) {
        userService.updateUser(userId, updateUserRequest);
        return ResponseEntity.noContent().build();
    }
}
