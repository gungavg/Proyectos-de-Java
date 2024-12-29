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
                .map(userCreated -> jwtService.generateToken(userCreated.getUserId()))
                .orElseThrow(()-> new RuntimeException("Error creating user"));

    }

    @Override
    public TokenResponse login(String email, String password){
        return userRepository.findByEmail(email)
                .filter((user -> user.getPassword().matches(password) ))
                .map(user -> jwtService.generateToken(user.getUserId()))
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }




    @Override
    public TokenResponse deleteUser(String email) {
        return userRepository.findByEmail(email)
                .map(user -> {
                    userRepository.delete(user);
                    return new TokenResponse("User deleted successfully"); // Reemplaza con tu lógica para TokenResponse
                })
                .orElseThrow(() -> new RuntimeException("Error: couldn't delete that item"));
    }

    private UserModel mapToEntity(UserRequest userRequest){
        return UserModel.builder()
                .email(userRequest.getEmail())
                .password(userRequest.getPassword())
                .name(userRequest.getName())
                .role("USER")
                .build();

    }
}
