package com.example.game_service.repository;

import com.example.game_service.commons.constants.GameModel;
import com.example.game_service.commons.dtos.CreateGameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel,Long> {
}
