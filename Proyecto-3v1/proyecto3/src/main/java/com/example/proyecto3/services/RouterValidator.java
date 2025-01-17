package com.example.proyecto3.services;

import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.List;
import java.util.function.Predicate;

public class RouterValidator {
    public static final List<String> openEndpoints = List.of(
            "/v1/auth"
    );
    public Predicate<ServerHttpRequest> isSecure = serverHttpRequest -> openEndpoints.stream().noneMatch(uri -> serverHttpRequest.getURI().getPath().contains(uri));
}
