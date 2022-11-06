package com.kevtubio.questionados.exceptions.custom;

public class ForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 5247525995004114616L;

	private static final String DESCRIPTION = "Forbidden Exception (403)";

	public ForbiddenException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}
}
