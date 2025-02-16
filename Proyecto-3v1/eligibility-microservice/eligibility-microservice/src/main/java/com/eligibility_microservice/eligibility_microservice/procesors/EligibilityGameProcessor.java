package com.eligibility_microservice.eligibility_microservice.procesors;

import com.eligibility_microservice.eligibility_microservice.common.GameCreatedEvent;
import com.eligibility_microservice.eligibility_microservice.common.GameEligibleEvent;
import com.eligibility_microservice.eligibility_microservice.services.GameEligibleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@Slf4j
public class EligibilityGameProcessor {
    private GameEligibleService gameEligibleService;

    public EligibilityGameProcessor(GameEligibleService gameEligibleService) {
        this.gameEligibleService = gameEligibleService;
    }
    public Flux<GameEligibleEvent> process (Flux<GameCreatedEvent> gameCreatedEventFlux){
        return gameCreatedEventFlux.doOnNext(given -> log.info("Entry event : {}", given))
                .flatMap(gameEligibleService::eligibilityGame)
                .onErrorContinue(this::handleError);
    }

    private void handleError(Throwable throwable, Object object ) {
        log.error("Error processing event: {}", object, throwable);
    }

}
