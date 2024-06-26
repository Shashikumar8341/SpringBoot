
package com.src.global;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headres, HttpStatusCode status, WebRequest request) {

		List<ObjectError> errorObjs = ex.getAllErrors();

		HashMap<String, String> errors = new HashMap<>();

		for (ObjectError objectError : errorObjs) {

			String fieldName = ((FieldError) objectError).getField();
			String errorMsg = ((FieldError) objectError).getDefaultMessage();
			errors.put(fieldName, errorMsg);

		}
		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);

	}

}
