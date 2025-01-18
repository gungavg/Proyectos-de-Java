package com.example.game_service.service;

import com.example.game_service.commons.constants.GameModel;
import com.example.game_service.commons.dtos.GameInfoRequest;
import com.example.game_service.commons.dtos.UpdateGameRequest;

public interface GameService {
    GameModel getGame(Long gameId);
    GameInfoRequest deleteGame(GameInfoRequest gameInfoRequest);
    UpdateGameRequest updateGame(Long gameId, UpdateGameRequest updateGameRequest);
}
