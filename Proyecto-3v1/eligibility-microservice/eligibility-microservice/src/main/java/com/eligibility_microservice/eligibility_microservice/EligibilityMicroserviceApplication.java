package com.eligibility_microservice.eligibility_microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {
		org.springframework.cloud.function.context.config.ContextFunctionCatalogAutoConfiguration.class
})
public class EligibilityMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EligibilityMicroserviceApplication.class, args);
	}

}
