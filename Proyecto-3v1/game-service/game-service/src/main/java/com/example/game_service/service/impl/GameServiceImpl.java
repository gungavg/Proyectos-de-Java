package com.example.game_service.service.impl;

import com.example.game_service.commons.constants.GameModel;
import com.example.game_service.commons.dtos.GameInfoRequest;
import com.example.game_service.commons.dtos.UpdateGameRequest;
import com.example.game_service.repository.GameRepository;
import com.example.game_service.service.GameService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
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
        Optional.of(gameId)
                .map(this::getGame)
                .map(existingGame -> updateGameFields(existingGame, updateGameRequest))
                .map(gameRepository::save)
                .orElseThrow(() -> new RuntimeException("Game can't be updated"));
        return  updateGameRequest;
    }

    private GameModel updateGameFields(GameModel existingGame, UpdateGameRequest updateGameRequest) {
        existingGame.setName(updateGameRequest.getName());
        return existingGame;
    }



}
