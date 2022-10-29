package com.kevtubio.questionados.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class SpringConfig {

    @Bean
    Random random() {
        return new Random();
    }

}
