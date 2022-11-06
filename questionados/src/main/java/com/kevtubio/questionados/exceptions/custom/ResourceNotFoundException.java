package com.kevtubio.questionados.exceptions.custom;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -1191111763586653346L;

	private static final String DESCRIPTION = "NotFound Exception (404)";

	private final String nombreDelRecurso;
	private final String nombreDelCampo;
	private final long valorDelCampo;

	public ResourceNotFoundException(String nombreDelRecurso, String nombreDelCampo, long valorDelCampo) {

		super(DESCRIPTION + ". "
				+ String.format("%s no existente: %s='%s'", nombreDelRecurso, nombreDelCampo, valorDelCampo));

		this.nombreDelRecurso = nombreDelRecurso;
		this.nombreDelCampo = nombreDelCampo;
		this.valorDelCampo = valorDelCampo;

	}

}
