package com.boon.parking.reservation.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * String message to JSON converter for RabbitMq messages.
 */
@Configuration
@RequiredArgsConstructor
public class JacksonConfig {

    private final ObjectMapper objectMapper;

    @Bean
    public Jackson2JsonMessageConverter converter() {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
