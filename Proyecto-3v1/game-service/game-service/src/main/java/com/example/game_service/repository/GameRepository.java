package com.example.game_service.repository;

import com.example.game_service.commons.constants.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<GameModel,Long> {
}
