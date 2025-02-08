package com.game_service_api.game_service.repository;

import com.game_service_api.game_service.common.entities.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GameRepository extends JpaRepository<GameModel, Long> {
    Optional<GameModel> findByUserId(@Param("userId")String userId);
}
