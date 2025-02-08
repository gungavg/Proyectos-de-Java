package com.game_service_api.game_service.common.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UpdateGame {
    @NotNull
    private String nameGame;
}
