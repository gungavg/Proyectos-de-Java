package com.example.game_service.commons.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GameRequest {
    @NonNull
    private String gameName;
}
