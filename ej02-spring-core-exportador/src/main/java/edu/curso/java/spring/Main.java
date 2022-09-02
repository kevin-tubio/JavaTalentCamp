package edu.curso.java.spring;

import edu.curso.java.spring.config.SpringConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(SpringConfig.class);
		applicationContext.refresh();

		Persona persona = applicationContext.getBean(Persona.class, "persona");

		GeneradorDeDocumento generadorDeDocumento = applicationContext.getBean(GeneradorDeDocumento.class, "generadorDeDocumento");
		generadorDeDocumento.exportarDatos(persona);

	}
}
