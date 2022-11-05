package com.kevtubio.questionados.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Random;

@Configuration
@EnableConfigurationProperties
public class SpringConfig {

    @Bean
    Random random() {
        return new Random();
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
