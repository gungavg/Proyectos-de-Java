package com.example.game_service_api.service.impl;

import com.example.games_service_api.commons.entities.GameModel;
import com.example.games_service_api.repository.GameRepository;
import com.example.games_service_api.service.GameService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GameServiceImpl  implements GameService {
    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public GameModel createGame(GameModel gameRequest) {
        return Optional.of(gameRequest)
                .map(this::mapToEntity)
                .map(gameRepository::save)
                .orElseThrow(()-> new RuntimeException("Error creating game") );
    }

    @Override
    public GameModel getGame(Long gameId) {
        return Optional.of(gameId)
                .flatMap(gameRepository::findById)
                .orElseThrow(()-> new RuntimeException("Error culdn't find that game"));
    }

    @Override
    public  GameModel deleteGame(Long gameId){
        return Optional.of(gameId)
                .flatMap(gameRepository :: findById)
                .map(game->{
                    gameRepository.deleteById(gameId);
                    return game;
        })
                .orElseThrow(()-> new RuntimeException("Error couldn't delete that game"));
    }

    @Override
    public GameModel updateGame(Long gameId, GameModel gameRequest) {
        return Optional.ofNullable(gameId)
                .flatMap(id -> gameRepository.findById(id)) // Check if game exists
                .map(game -> {
                    game.setName(gameRequest.getName());
                    return gameRepository.save(game); // Save the updated game
                })
                .orElseThrow(() -> new RuntimeException("Couldn't update the game. Game not found or invalid ID."));
    }


    private GameModel mapToEntity(GameModel gameRequest){
        return  GameModel.builder()
                .name(gameRequest.getName())
                .build();

    }
}
