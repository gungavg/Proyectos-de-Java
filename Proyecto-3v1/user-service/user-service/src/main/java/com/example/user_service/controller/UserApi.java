package com.example.user_service.controller;


import com.example.user_service.commons.constants.ApiPathConstants;
import com.example.user_service.commons.dtos.UpdateUserRequest;
import com.example.user_service.commons.dtos.UserInfoRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.common_library.entities.UserModel;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)

@SecurityRequirement(name= "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface UserApi {
    @GetMapping()
    ResponseEntity<UserModel> getUser(


            @RequestAttribute("X-User-Id") Long userId
    );

    @DeleteMapping(value= "/deleteUser")
    ResponseEntity<UserModel> deleteUser(
            @RequestBody UserInfoRequest userInfoRequest
    );

    @PutMapping()
    ResponseEntity<UserModel>updateUser(
            @RequestAttribute("X-User-Id") Long userId,
            @RequestBody UpdateUserRequest updateUserRequest
    );

}
