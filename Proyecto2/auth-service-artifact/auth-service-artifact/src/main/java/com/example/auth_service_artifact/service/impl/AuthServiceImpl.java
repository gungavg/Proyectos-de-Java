package com.example.auth_service_artifact.service.impl;

import com.example.auth_service_artifact.comons.dtos.TokenResponse;
import com.example.auth_service_artifact.comons.dtos.UserRequest;
import com.example.auth_service_artifact.comons.entities.UserModel;
import com.example.auth_service_artifact.repositories.UserRepository;
import com.example.auth_service_artifact.service.AuthService;
import com.example.auth_service_artifact.service.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getId()))
                .orElseThrow(()-> new RuntimeException("Error creating user"));

    }
    private UserModel mapToEntity(UserRequest userRequest){
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .name(userRequest.getName())
                .build();

    }
}
