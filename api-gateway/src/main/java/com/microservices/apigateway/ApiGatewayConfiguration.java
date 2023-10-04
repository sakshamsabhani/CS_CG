package com.microservices.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/bill/**")
                        .uri("lb://bill-service"))
                .route(p -> p.path("/guests/**")
                        .uri("lb://guest-service"))
                .route(p -> p.path("/rooms/**")
                        .uri("lb://room-service"))
                .route(p -> p.path("/holidays/**")
                        .uri("lb://rate-service"))
                .route(p -> p.path("/rate/**")
                        .uri("lb://rate-service"))
                .route(p -> p.path("/reservations/**")
                        .uri("lb://reservation-service"))
                .route(p -> p.path("/staff-service/**")
                        .uri("lb://staff"))
                .route(p -> p.path("/salary/**")
                        .uri("lb://salary-service"))
                .route(p -> p.path("/report/**")
                        .uri("lb://report-service"))
                .route(p -> p.path("/inventory/**")
                        .uri("lb://inventory-service"))
                .route(p -> p.path("/email/**")
                        .uri("lb://email-service"))
                .build();
    }
}