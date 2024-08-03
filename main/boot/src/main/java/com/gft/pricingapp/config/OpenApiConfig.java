package com.gft.pricingapp.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public GroupedOpenApi priceApi() {
        return GroupedOpenApi.builder()
                .group("price")
                .pathsToMatch("/price/**")
                .build();
    }
}