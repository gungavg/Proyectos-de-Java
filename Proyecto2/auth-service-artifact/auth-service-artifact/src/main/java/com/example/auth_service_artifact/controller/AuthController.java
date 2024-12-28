package com.example.auth_service_artifact.controller;


import com.example.auth_service_artifact.comons.dtos.TokenResponse;
import com.example.auth_service_artifact.comons.dtos.UserRequest;
import com.example.auth_service_artifact.service.AuthService;
import com.example.auth_service_artifact.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi{
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @Override
    public ResponseEntity<TokenResponse> createUser(UserRequest userRequest) {
        return ResponseEntity.ok(authService.createUser(userRequest));
    }
}
