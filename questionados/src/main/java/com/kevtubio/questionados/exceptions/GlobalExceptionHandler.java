package com.kevtubio.questionados.exceptions;

import com.kevtubio.questionados.exceptions.custom.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

/**
 * Basado en
 * https://springframework.guru/exception-handling-in-spring-boot-rest-api/
 * 
 * @author ihsanch
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ //
			ResourceNotFoundException.class, //
			JpaObjectRetrievalFailureException.class //
	})
	@ResponseBody
	public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
		return new ErrorMessage(exception, request.getRequestURI());
	}

	/**
	 * Capturo una serie de errores de Spring, para que, cuando se produzcan, se
	 * devuelva un mensaje homogeneo (Nuestra clase ErrorMessage)
	 * 
	 * @param request
	 * @param exception
	 * @return
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
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
	public ErrorMessage badRequest(HttpServletRequest request, Exception exception) {
		return new ErrorMessage(exception, request.getRequestURI());
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler({ ForbiddenException.class })
	@ResponseBody
	public ErrorMessage ForbiddenRequest(HttpServletRequest request, Exception exception) {
		return new ErrorMessage(exception, request.getRequestURI());
	}

	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	@ExceptionHandler({ UnauthorizedException.class
	// , org.springframework.security.access.AccessDeniedException.class
	})
	public void unauthorized() {
		// No se envia mensaje de error
	}

	/**
	 * Aca se maneja todo lo que yo no controle. Excepciones aun no manejadas o algo
	 * que se me escapa de momento. Hay que evitar las llamadas a este metodo.
	 * 
	 * @param request
	 * @param exception
	 * @return
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler({ Exception.class })
	@ResponseBody
	public ErrorMessage fatalErrorUnexpectedException(HttpServletRequest request, Exception exception) {
		return new ErrorMessage(exception, request.getRequestURI());
	}

}
