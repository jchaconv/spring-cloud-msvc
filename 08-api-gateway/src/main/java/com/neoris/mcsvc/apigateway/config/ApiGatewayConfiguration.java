package com.neoris.mcsvc.apigateway.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("my-custom-header", "my-uri-mcsvc")
                                .addRequestParameter("my-custom-parameter", "my-value-parameter"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/currency-exchange/**") //Se agrega ** para que reconozca lo que viene luego del path
                        .uri("lb://currency-exchange")) //Esto se pone para que haga el load-balancing con el nombre del mcsvc en eureka
                .route(p -> p.path("/currency-conversion/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-feign/**")
                        .uri("lb://currency-conversion"))
                .route(p -> p.path("/currency-conversion-new/**") //Aquí se cambió el path
                        .filters(f -> f.rewritePath(
                                "/currency-conversion-new/(?<segment>.*)", //Se establece con el rewrite y segment para lo que va después
                                "/currency-conversion-feign/${segment}")) //Con este segment reconoce lo que está despues de la modificación y hace "match"
                        .uri("lb://currency-conversion"))
                .build();
    }


}
