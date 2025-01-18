package com.example.game_service.controllers.impl;

import com.example.game_service.commons.constants.GameModel;
import com.example.game_service.commons.dtos.GameInfoRequest;
import com.example.game_service.commons.dtos.UpdateGameRequest;
import com.example.game_service.controllers.GameApi;
import com.example.game_service.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameControllerImpl implements GameApi {
    private final GameService gameService;

    public GameControllerImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<GameModel> getGame(String userId, Long gameId) {
        return ResponseEntity.ok(gameService.getGame(gameId));
    }

    @Override
    public ResponseEntity<GameModel> deleteUser(String userId, GameInfoRequest gameInfoRequest) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<GameModel> updateGame(String userId, Long gameId, UpdateGameRequest updateGameRequest) {
        gameService.updateGame(gameId, updateGameRequest);
        return ResponseEntity.noContent().build();
    }
}
