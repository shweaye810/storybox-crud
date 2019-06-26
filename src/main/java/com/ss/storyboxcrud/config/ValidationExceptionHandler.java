package com.ss.storyboxcrud.config;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Object> handleEverything(ValidationException e) {
		Map<String, String> map = new HashMap<>();
		map.put("error", e.getMessage());
		
		return new ResponseEntity<Object>(map, HttpStatus.BAD_REQUEST);
	}
}
