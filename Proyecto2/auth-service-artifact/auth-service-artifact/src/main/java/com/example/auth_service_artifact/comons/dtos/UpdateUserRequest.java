package com.example.auth_service_artifact.comons.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequest {

    @NotNull
    private String name;
    @NotNull
    @NotEmpty
    @NotBlank
    @Email
    private String email;


}
