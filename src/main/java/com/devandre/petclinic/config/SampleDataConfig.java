package com.devandre.petclinic.config;

import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * andre on 12/10/2023
 */
@Configuration
public class SampleDataConfig {

    @Bean
    Faker faker() {
        return new Faker();
    }
}
