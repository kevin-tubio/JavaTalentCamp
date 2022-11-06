package com.kevtubio.questionados.exceptions.custom;

public class TokenRefreshException extends RuntimeException {

    private static final long serialVersionUID = 1281126528223987236L;

    public TokenRefreshException(String token, String message) {
        super(String.format("Failed for [%s]: %s", token, message));
    }

}
