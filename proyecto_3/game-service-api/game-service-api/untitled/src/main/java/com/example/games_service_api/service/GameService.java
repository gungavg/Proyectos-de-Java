package com.example.games_service_api.service;

import com.example.games_service_api.commons.entities.GameModel;

public interface GameService {
    GameModel createGame(GameModel gameRequest);
    GameModel getGame(Long gameId);

    GameModel deleteGame(Long gameId);
    GameModel updateGame(Long gameId, GameModel gameRequest);
}
