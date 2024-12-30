package com.example.auth_service_artifact.service;

import com.example.auth_service_artifact.comons.dtos.LoginRequest;
import com.example.auth_service_artifact.comons.dtos.TokenResponse;
import com.example.auth_service_artifact.comons.dtos.UserRequest;

public interface AuthService {
    TokenResponse createUser(UserRequest userRequest);

    TokenResponse login(LoginRequest loginRequest);



}
