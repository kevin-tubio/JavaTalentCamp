package com.kevtubio.questionados.exceptions.custom;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -4192392901653217806L;

	private static final String DESCRIPTION = "Bad Request Exception (400)";

	/**
	 * En el constructor recibo los detalles
	 * 
	 * @param detail
	 */
	public BadRequestException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
