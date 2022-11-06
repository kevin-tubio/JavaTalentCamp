package com.kevtubio.questionados.exceptions.custom;

public class ConflictException extends RuntimeException {

	private static final long serialVersionUID = 8076529618730381061L;

	private static final String DESCRIPTION = "Conflict Exception (409)";

	public ConflictException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
