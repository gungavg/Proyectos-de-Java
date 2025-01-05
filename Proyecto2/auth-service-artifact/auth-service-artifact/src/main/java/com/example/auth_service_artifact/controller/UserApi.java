package com.example.auth_service_artifact.controller;

import com.example.auth_service_artifact.comons.constants.ApiPathConstants;
import com.example.auth_service_artifact.comons.dtos.UpdateUserRequest;
import com.example.auth_service_artifact.comons.dtos.UserInfoRequest;
import com.example.auth_service_artifact.comons.entities.UserModel;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface UserApi {
    @GetMapping(value= "/{userId}")
    ResponseEntity<UserModel> getUser(
            @PathVariable Long userId
    );

    @DeleteMapping(value= "/deleteUser")
    ResponseEntity<UserModel>deleteUser(
            @RequestBody UserInfoRequest userInfoRequest
            );

    @PutMapping(value="/{userId}")
    ResponseEntity<UserModel>updateUser(
            @PathVariable Long userId,
            @RequestBody UpdateUserRequest updateUserRequest
            );

}
