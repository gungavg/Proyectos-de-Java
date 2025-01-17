package com.example.auth_service_artifact.service.impl;

import com.example.auth_service_artifact.comons.dtos.LoginRequest;
import com.example.auth_service_artifact.comons.dtos.TokenResponse;
import com.example.auth_service_artifact.comons.dtos.UserRequest;
import com.example.auth_service_artifact.repositories.UserRepository;
import com.example.auth_service_artifact.service.AuthService;
import com.example.auth_service_artifact.service.JwtService;
import com.example.common_library.entities.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder paswordEncoder;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService, PasswordEncoder paswordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.paswordEncoder = paswordEncoder;
    }

    @Override
    public TokenResponse createUser(UserRequest userRequest) {
        return Optional.of(userRequest)
                .map(this::mapToEntity)
                .map(userRepository::save)
                .map(userCreated -> jwtService.generateToken(userCreated.getUserId()))
                .orElseThrow(()-> new RuntimeException("Error creating user"));

    }

    @Override
    public TokenResponse login(LoginRequest loginRequest){
        return Optional.of(loginRequest.getEmail())
                .map(userRepository :: findByEmail)
                .filter(user -> paswordEncoder.matches(loginRequest.getPassword(), user.get().getPassword()))
                .map(user -> jwtService.generateToken(user.get().getUserId()))
                .orElseThrow(() -> new RuntimeException("Failed login process"));
    }

    private UserModel mapToEntity(UserRequest userRequest){
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(paswordEncoder.encode(userRequest.getPassword()))
                .name(userRequest.getName())
                .role("USER")
                .build();

    }
}
