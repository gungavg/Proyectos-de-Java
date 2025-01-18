package com.example.game_service.service.impl;

import com.example.game_service.commons.constants.GameModel;
import com.example.game_service.commons.dtos.GameInfoRequest;
import com.example.game_service.commons.dtos.UpdateGameRequest;
import com.example.game_service.repository.GameRepository;
import com.example.game_service.service.GameService;

import java.util.Optional;

public class UserServiceImpl  implements GameService {
    private final GameRepository gameRepository;

    public UserServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public GameModel getGame(Long gameId) {
        return Optional.of(gameId)
                .flatMap(gameRepository :: findById)
                .orElseThrow(()-> new RuntimeException("Error couldn't find that game"));
    }

    @Override
    public GameInfoRequest deleteGame(GameInfoRequest gameInfoRequest) {
        Optional.of(gameInfoRequest.getGameId())
                .map(this::getGame)
                .ifPresent(gameRepository :: delete);
        return null;
    }

    @Override
    public UpdateGameRequest updateGame(Long gameId, UpdateGameRequest updateGameRequest) {
        return Optional.of(gameId)
                .map(this::getGame)
                .map(existingGame -> updateGameFields(existingGame, updateGameRequest))
                .map(gameRepository::save)
                .map(updatedGame -> mapToUpdateGameRequest(updatedGame))
                .orElseThrow(() -> new RuntimeException("Game can't be updated"));
    }

    private GameModel updateGameFields(GameModel existingGame, UpdateGameRequest updateGameRequest) {
        existingGame.setName(updateGameRequest.getName());
        return existingGame;
    }

    private UpdateGameRequest mapToUpdateGameRequest(GameModel gameModel) {
        UpdateGameRequest updateGameRequest = new UpdateGameRequest();
        updateGameRequest.setName(gameModel.getName());
        return updateGameRequest;
    }

}
