package com.game_service_api.game_service.common.dtos;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreateGame {
    @NotNull
    private String nameGame;
}
