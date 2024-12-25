package com.example.games_service_api.controllers;

import com.example.games_service_api.commons.constants.ApiPathConstants;
import com.example.games_service_api.commons.entities.GameModel;
import com.example.games_service_api.repository.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.GAME_ROUTE)
public interface GameApi {
    @PostMapping(value= "create")
    ResponseEntity<GameModel> createGame(
            @RequestBody GameModel gameRequest
    );
    @GetMapping(value="/{gameId}")
    ResponseEntity<GameModel> getGame(
            @PathVariable Long gameId
    );
    @DeleteMapping(value= "/delete/{gameId}")
    ResponseEntity<GameModel> deleteGame(
            @PathVariable Long gameId
    );

    @PutMapping(value= "/{gameId}")
    ResponseEntity<GameModel> updateGame(
            @PathVariable Long gameId,
            @RequestBody GameModel gameRequest
    );

}
