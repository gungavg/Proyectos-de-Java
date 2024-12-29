package com.example.auth_service_artifact.controller;

import com.example.auth_service_artifact.comons.constants.ApiPathConstants;
import com.example.auth_service_artifact.comons.dtos.TokenResponse;
import com.example.auth_service_artifact.comons.dtos.UserRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.AUTH_ROUTE)
public interface AuthApi {
    @PostMapping(value = "/register")
    ResponseEntity<TokenResponse> createUser(
            @RequestBody @Valid UserRequest userRequest
    );
    @GetMapping(value= "/login")
    ResponseEntity<TokenResponse> login(
            @RequestParam @Valid String mail,
            @RequestParam String password
    );
    @DeleteMapping(value = "/{mail}")
    ResponseEntity<Void>deleteUser(
            @RequestParam @Valid String mail
    );

    /*@PutMapping(value = "/{mail}")
    ResponseEntity<Void> updateUser(String mail, UserRequest userRequest);
*/

}
