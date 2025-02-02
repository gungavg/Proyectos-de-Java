package com.example.game_service.commons.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateGameRequest {
    @NotNull
    private String name;


}
