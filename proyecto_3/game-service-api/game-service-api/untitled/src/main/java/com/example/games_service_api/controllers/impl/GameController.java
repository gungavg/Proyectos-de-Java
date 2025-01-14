package com.example.games_service_api.controllers.impl;

import com.example.games_service_api.commons.entities.GameModel;
import com.example.games_service_api.controllers.GameApi;
import com.example.games_service_api.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController  implements GameApi {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<GameModel> createGame(GameModel gameRequest) {
        return ResponseEntity.ok(gameService.createGame( gameRequest));
    }

    @Override
    public ResponseEntity<GameModel> getGame(Long gameId) {
        return ResponseEntity.ok(gameService.getGame(gameId));
    }

    @Override
    public ResponseEntity<GameModel> deleteGame(Long gameId) {
        return ResponseEntity.ok(gameService.deleteGame(gameId));
    }

    @Override
    public ResponseEntity<GameModel> updateGame(Long gameId, GameModel gameRequest) {
        return ResponseEntity.ok(gameService.updateGame(gameId, gameRequest));
    }

}
