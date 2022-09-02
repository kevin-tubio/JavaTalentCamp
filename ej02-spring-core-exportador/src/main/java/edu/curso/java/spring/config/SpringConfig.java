package edu.curso.java.spring.config;

import edu.curso.java.spring.Persona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("edu.curso.java.spring")
public class SpringConfig {

    @Bean
    public Persona getPersona() {
        return new Persona("Victoria", 37, "Lugones 4402");
    }

}
