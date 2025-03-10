package com.example.auth_service_artifact.controller;

import com.example.auth_service_artifact.comons.constants.ApiPathConstants;
import com.example.auth_service_artifact.comons.dtos.UpdateUserRequest;
import com.example.auth_service_artifact.comons.dtos.UserInfoRequest;
import com.example.auth_service_artifact.comons.entities.UserModel;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)

@SecurityRequirement(name= "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface UserApi {
    @GetMapping()
    ResponseEntity<UserModel> getUser(
            @RequestAttribute("X-User-Id") Long userId
    );

    @DeleteMapping(value= "/deleteUser")
    ResponseEntity<UserModel>deleteUser(
            @RequestBody UserInfoRequest userInfoRequest
            );

    @PutMapping()
    ResponseEntity<UserModel>updateUser(
            @RequestAttribute("X-User-Id") Long userId,
            @RequestBody UpdateUserRequest updateUserRequest
            );

}
