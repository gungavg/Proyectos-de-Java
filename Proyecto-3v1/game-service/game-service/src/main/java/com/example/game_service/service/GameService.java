package com.example.game_service.service;

import com.example.game_service.commons.constants.GameModel;
import com.example.game_service.commons.dtos.CreateGameModel;
import com.example.game_service.commons.dtos.GameInfoRequest;
import com.example.game_service.commons.dtos.GameRequest;
import com.example.game_service.commons.dtos.UpdateGameRequest;

public interface GameService {
    
    GameModel getGame(String userId);
    GameInfoRequest deleteGame(GameInfoRequest gameInfoRequest);
    UpdateGameRequest updateGame(String userId, UpdateGameRequest updateGameRequest);

    GameModel createGame(GameRequest gameRequest, String userId);
}
