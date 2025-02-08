package com.game_service_api.game_service.service.impl;

import com.game_service_api.game_service.common.constants.TopicConstants;
import com.game_service_api.game_service.common.dtos.CreateGame;
import com.game_service_api.game_service.common.dtos.UpdateGame;
import com.game_service_api.game_service.common.entities.GameModel;
import com.game_service_api.game_service.repository.GameRepository;
import com.game_service_api.game_service.service.GameService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public GameModel createGame(String userId,CreateGame createGame) {
        return Optional.of(createGame)
                .map(game -> mapToEntity(userId,createGame))
                .map(gameRepository::save)
                .orElseThrow(()-> new RuntimeException("Error creating the game"));
    }

    @Override
    public GameModel getGame(String userId) {
        return Optional.of(userId)
                .flatMap(gameRepository::findByUserId)
                .orElseThrow(() -> new RuntimeException("Game not found"));
    }

    @Override
    public void updateGame(String userId,UpdateGame updateGame) {
        Optional.of(userId)
                .flatMap(gameRepository::findByUserId)
                .map(existGame -> updateFieldsGame(existGame,updateGame))
                .map(gameRepository::save)
                .orElseThrow(() -> new RuntimeException("Error updating the game"));
    }

    @Override
    public void deleteGame(String userId,Long gameId) {
        Optional.of(userId)
                .flatMap(gameRepository::findByUserId)
                .ifPresent(gameRepository::delete);
    }

    private GameModel updateFieldsGame(GameModel existGame, UpdateGame updateGame) {
        existGame.setNameGame(updateGame.getNameGame());
        return existGame;
    }

    private GameModel mapToEntity(String userId,CreateGame createGame){
        return GameModel.builder()
                .nameGame(createGame.getNameGame())
                .userId(userId)
                .build();
    }
}
