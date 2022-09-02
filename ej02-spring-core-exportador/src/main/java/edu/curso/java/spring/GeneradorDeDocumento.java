package edu.curso.java.spring;

import edu.curso.java.spring.service.Exportador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("generadorDeDocumento")
public class GeneradorDeDocumento {

	private Exportador exportador;

	@Autowired
	public GeneradorDeDocumento(@Qualifier("exportadorXML") Exportador exportador) {
		this.exportador = exportador;
	}

	public void exportarDatos(Persona persona) {
		System.out.println(exportador.exportar(persona));
	}

	public Exportador getExportador() {
		return this.exportador;
	}

	public void setExportador(Exportador exportador) {
		this.exportador = exportador;
	}
}
