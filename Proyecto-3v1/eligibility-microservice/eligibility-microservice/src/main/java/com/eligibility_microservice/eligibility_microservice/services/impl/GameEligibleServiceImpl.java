package com.eligibility_microservice.eligibility_microservice.services.impl;

import com.eligibility_microservice.eligibility_microservice.common.GameCreatedEvent;
import com.eligibility_microservice.eligibility_microservice.common.GameEligibleEvent;
import com.eligibility_microservice.eligibility_microservice.services.GameEligibleService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GameEligibleServiceImpl implements GameEligibleService {
    @Override
    public Mono<GameEligibleEvent> eligibilityGame(GameCreatedEvent gameCreatedEvent) {
        return Mono.just(gameCreatedEvent)
                .flatMap(this::checkIsEligible)
                .map(givenCreated -> GameEligibleEvent.builder()
                        .gameId(givenCreated.getGameId())
                        .nameGame(givenCreated.getNameGame())
                        .userId(givenCreated.getUserId())
                        .isEligible(true)
                        .build()
                );
    }

    private Mono<GameCreatedEvent> checkIsEligible(GameCreatedEvent gameCreatedEvent) {
        return Mono.just(gameCreatedEvent)
                .filter(given -> !given.getNameGame().isBlank())
                .map(given -> gameCreatedEvent);
    }
}
