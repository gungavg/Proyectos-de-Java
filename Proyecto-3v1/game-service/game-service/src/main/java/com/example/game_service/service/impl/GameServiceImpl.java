package com.example.game_service.service.impl;

import com.example.game_service.commons.constants.GameModel;
import com.example.game_service.commons.dtos.GameInfoRequest;
import com.example.game_service.commons.dtos.GameRequest;
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



    private GameModel mapToEntity(GameRequest gameRequest, String userId){
        return  GameModel.builder()
                .name(gameRequest.getGameName())
                .userId(userId)
                .build();

    }




    @Override
    public GameModel getGame(String userId) {
        return Optional.of(userId)
                .flatMap(gameRepository :: findGameByUserId)
                .orElseThrow(()-> new RuntimeException("Error couldn't find that game"));
    }

    @Override
    public GameInfoRequest deleteGame(GameInfoRequest gameInfoRequest) {
        Optional.of(gameInfoRequest.getUserId())
                .map(this::getGame)
                .ifPresent(gameRepository :: delete);
        return null;
    }

    @Override
    public UpdateGameRequest updateGame(String userId, UpdateGameRequest updateGameRequest) {
        Optional.of(userId)
                .map(this::getGame)
                .map(existingGame -> updateGameFields(existingGame, updateGameRequest))
                .map(gameRepository::save)
                .orElseThrow(() -> new RuntimeException("Game can't be updated"));
        return  updateGameRequest;
    }

    @Override
    public GameModel createGame(GameRequest gameRequest, String userId) {
         return Optional.of(gameRequest)
                 .map(game -> mapToEntity(game ,userId))
                 .map(gameRepository::save)
                 .orElseThrow(() -> new RuntimeException("Error creating game"));
    }

    private GameModel updateGameFields(GameModel existingGame, UpdateGameRequest updateGameRequest) {
        existingGame.setName(updateGameRequest.getName());
        return existingGame;
    }



}
