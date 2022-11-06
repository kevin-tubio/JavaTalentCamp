package com.kevtubio.questionados.exceptions.custom;

public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = -5392834240186692242L;

	private static final String DESCRIPTION = "Unauthorized Exception (401)";

	public UnauthorizedException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}
}
