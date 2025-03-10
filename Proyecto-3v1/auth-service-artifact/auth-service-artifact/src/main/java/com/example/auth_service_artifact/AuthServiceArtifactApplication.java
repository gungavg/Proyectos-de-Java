package com.example.auth_service_artifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.common_library.entities")

public class AuthServiceArtifactApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceArtifactApplication.class, args);
	}

}
