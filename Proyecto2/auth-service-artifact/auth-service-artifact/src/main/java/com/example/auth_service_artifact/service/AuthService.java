package com.example.auth_service_artifact.service;

import com.example.auth_service_artifact.comons.dtos.TokenResponse;
import com.example.auth_service_artifact.comons.dtos.UserRequest;

public interface AuthService {
    TokenResponse createUser(UserRequest userRequest);

    TokenResponse login(String email, String password);

   // TokenResponse updateUser(String email, UserRequest userRequest);


    TokenResponse deleteUser(String email);
}
