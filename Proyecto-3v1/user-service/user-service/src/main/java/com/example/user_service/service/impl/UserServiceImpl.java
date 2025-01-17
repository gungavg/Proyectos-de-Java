package com.example.user_service.service.impl;


import com.example.common_library.entities.UserModel;
import com.example.user_service.commons.dtos.UpdateUserRequest;
import com.example.user_service.commons.dtos.UserInfoRequest;
import com.example.user_service.repositories.UserRepository;
import com.example.user_service.service.UserService;
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
