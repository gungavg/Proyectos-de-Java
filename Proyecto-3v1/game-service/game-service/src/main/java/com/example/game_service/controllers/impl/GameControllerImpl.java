package com.example.game_service.controllers.impl;

import com.example.game_service.commons.constants.GameModel;
import com.example.game_service.commons.dtos.GameInfoRequest;
import com.example.game_service.commons.dtos.GameRequest;
import com.example.game_service.commons.dtos.UpdateGameRequest;
import com.example.game_service.controllers.GameApi;
import com.example.game_service.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameControllerImpl implements GameApi {
    private final GameService gameService;


    @Override
    public ResponseEntity<GameModel> createGame(String userId, GameRequest gameRequest) {
        return ResponseEntity.ok(gameService.createGame(gameRequest, userId));
    }

    @Override
    public ResponseEntity<GameModel> getGame(String userId) {
        return ResponseEntity.ok(gameService.getGame(userId));
    }

    @Override
    public ResponseEntity<GameModel> deleteGame(String userId, GameInfoRequest gameInfoRequest) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<GameModel> updateGame(String userId, UpdateGameRequest updateGameRequest) {
        gameService.updateGame(userId, updateGameRequest);
        return ResponseEntity.noContent().build();
    }

    public GameControllerImpl(GameService gameService) {
        this.gameService = gameService;
    }









}
