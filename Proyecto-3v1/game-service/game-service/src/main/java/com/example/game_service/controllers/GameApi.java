package com.example.game_service.controllers;

import com.example.game_service.commons.constants.ApiPathConstants;
import com.example.game_service.commons.constants.GameModel;
import com.example.game_service.commons.dtos.CreateGameModel;
import com.example.game_service.commons.dtos.GameInfoRequest;
import com.example.game_service.commons.dtos.UpdateGameRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiPathConstants.V1_ROUTE + ApiPathConstants.GAME_ROUTE)
@SecurityRequirement(name= "Bearer Authentication")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface GameApi {
    @PostMapping(value= "/create")
    ResponseEntity<CreateGameModel> createGame(
            @RequestHeader("X-User-Id") String userId,
            @RequestBody CreateGameModel createGameModel
            );
    @GetMapping()
    ResponseEntity< GameModel > getGame(
            @RequestHeader("uX-User-Idt") String userId,
            @RequestAttribute("gameId") Long gameId
    );
    @DeleteMapping(value = "/deleteGame")
    ResponseEntity<GameModel> deleteGame(
            @RequestHeader("X-User-Id") String userId,
            @RequestBody GameInfoRequest gameInfoRequest
    );

    @PutMapping()
    ResponseEntity<GameModel> updateGame(
            @RequestHeader("X-User-Id") String userId,
            @RequestAttribute("gameId") Long gameId,
            @RequestBody UpdateGameRequest updateGameRequest
            );

}
