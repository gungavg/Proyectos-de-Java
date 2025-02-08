package com.game_service_api.game_service.controller.impl;

import com.game_service_api.game_service.common.dtos.CreateGame;
import com.game_service_api.game_service.common.dtos.UpdateGame;
import com.game_service_api.game_service.common.entities.GameModel;
import com.game_service_api.game_service.controller.GameController;
import com.game_service_api.game_service.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameControllerImpl implements GameController {
    private final GameService gameService;

    public GameControllerImpl(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<GameModel> createGame(String userId,CreateGame createGame) {
        return ResponseEntity.ok(gameService.createGame(userId,createGame));
    }

    @Override
    public ResponseEntity<GameModel> getGame(String userId) {
        return ResponseEntity.ok(gameService.getGame(userId));
    }

    @Override
    public ResponseEntity<Void> updateGame(String userId,UpdateGame updateGame) {
        gameService.updateGame(userId,updateGame);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteGame(String userId,Long gameId) {
        gameService.deleteGame(userId,gameId);
        return ResponseEntity.noContent().build();
    }
}
