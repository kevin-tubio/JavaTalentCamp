package edu.curso.java.spring.service.impl;

import edu.curso.java.spring.Persona;
import edu.curso.java.spring.service.Exportador;

import org.springframework.stereotype.Service;

@Service("exportadorCSV")
public class ExportadorCSV implements Exportador {

	@Override
	public String exportar(Persona persona) {
		return persona.getNombre() + "," + persona.getEdad() + "," + persona.getDireccion();
	}

}
