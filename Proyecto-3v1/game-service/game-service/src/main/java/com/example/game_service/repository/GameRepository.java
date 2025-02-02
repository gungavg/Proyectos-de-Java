package com.example.game_service.repository;

import com.example.game_service.commons.constants.GameModel;
import com.example.game_service.commons.dtos.CreateGameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GameRepository extends JpaRepository<GameModel,Long> {

    Optional<GameModel> findGameByUserId(@Param("userId") String userId);
}
