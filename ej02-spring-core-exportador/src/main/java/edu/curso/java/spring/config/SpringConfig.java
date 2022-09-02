package edu.curso.java.spring.config;

import edu.curso.java.spring.GeneradorDeDocumento;
import edu.curso.java.spring.Persona;
import edu.curso.java.spring.service.Exportador;

import org.springframework.beans.factory.annotation.Qualifier;
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

    @Bean("generadorDeDocumento")
    public GeneradorDeDocumento getGeneradorDeDocumento(@Qualifier("exportadorXML") Exportador exportador) {
        return new GeneradorDeDocumento(exportador);
    }

}
