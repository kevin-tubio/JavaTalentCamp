package com.kevtubio.questionados.exceptions;

import com.kevtubio.questionados.exceptions.custom.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({
			ResourceNotFoundException.class,
			JpaObjectRetrievalFailureException.class
	})
	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
		return new ErrorMessage(exception, request.getRequestURI());
	}

	@ExceptionHandler({
			BadRequestException.class,
			DuplicateKeyException.class,
			HttpRequestMethodNotSupportedException.class,
			MissingRequestHeaderException.class,
			MissingServletRequestParameterException.class,
			MethodArgumentNotValidException.class,
			HttpMessageNotReadableException.class,
			DataIntegrityViolationException.class,
			MethodArgumentTypeMismatchException.class
	})
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage badRequest(HttpServletRequest request, Exception exception) {
		return new ErrorMessage(exception, request.getRequestURI());
	}

	@ExceptionHandler({
			ForbiddenException.class,
			AccessDeniedException.class
	})
	@ResponseBody
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorMessage ForbiddenRequest(HttpServletRequest request, Exception exception) {
		return new ErrorMessage(exception, request.getRequestURI());
	}

	@ExceptionHandler({
			UnauthorizedException.class,
			BadCredentialsException.class
	})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public void unauthorized() {
		// No se envia mensaje de error
	}

	@ExceptionHandler({
			Exception.class
	})
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage fatalErrorUnexpectedException(HttpServletRequest request, Exception exception) {
		return new ErrorMessage(exception, request.getRequestURI());
	}

}
