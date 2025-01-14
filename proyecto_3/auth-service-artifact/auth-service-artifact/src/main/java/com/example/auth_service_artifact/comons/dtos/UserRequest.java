package com.example.auth_service_artifact.comons.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserRequest {
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;

}
