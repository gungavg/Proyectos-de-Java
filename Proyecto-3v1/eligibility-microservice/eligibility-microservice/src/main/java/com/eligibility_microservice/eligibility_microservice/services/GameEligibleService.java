package com.eligibility_microservice.eligibility_microservice.services;

import com.eligibility_microservice.eligibility_microservice.common.GameCreatedEvent;
import com.eligibility_microservice.eligibility_microservice.common.GameEligibleEvent;
import reactor.core.publisher.Mono;

public interface GameEligibleService {
    Mono<GameEligibleEvent> eligibilityGame(GameCreatedEvent gameCreatedEvent);
}
