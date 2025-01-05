package com.example.auth_service_artifact.service.impl;

import com.example.auth_service_artifact.comons.dtos.UpdateUserRequest;
import com.example.auth_service_artifact.comons.dtos.UserInfoRequest;
import com.example.auth_service_artifact.comons.entities.UserModel;
import com.example.auth_service_artifact.repositories.UserRepository;
import com.example.auth_service_artifact.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserModel getUser(Long userId) {
        return Optional.of(userId)
                .flatMap(userRepository :: findById)
                .orElseThrow(()-> new RuntimeException("Error couldn't find that user"));
    }

    @Override
    public UserInfoRequest deleteUser(UserInfoRequest userInfoRequest) {
        Optional.of(userInfoRequest.getUserId())
                .map(this::getUser)
                .ifPresent(userRepository::delete);
        return null;
    }

    @Override
    public UpdateUserRequest updateUser(Long userId, UpdateUserRequest updateUserRequest) {
        Optional.of(userId)
                .map(this::getUser)
                .map(existingUser->updateUserFields(existingUser, updateUserRequest))
                .map(userRepository :: save)
                .orElseThrow(()-> new RuntimeException("User cant be updated"));
        return null;
    }

    private UserModel updateUserFields(UserModel existingUser, UpdateUserRequest updateUserRequest) {
        existingUser.setEmail(updateUserRequest.getEmail());
        existingUser.setName(updateUserRequest.getName());
        return existingUser;
    }

}
