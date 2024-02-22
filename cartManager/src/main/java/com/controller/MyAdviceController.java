package com.controller;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class MyAdviceController extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		System.err.println(e.getClass());
		System.err.println(e.getMessage());
		return ResponseEntity.badRequest().body(e.getClass() + "   " + e.getMessage());
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> exceptionHandlingConstraint(ConstraintViolationException e) {
		System.err.println(e.getClass());
		System.err.println(e.getMessage());
		return ResponseEntity.badRequest().body(e.getClass() + "   " + e.getMessage());
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> noSuchElementExceptionHandler(NoSuchElementException e) {
		System.err.println(e.getClass());
		System.err.println(e.getMessage());
		return ResponseEntity.badRequest().body(e.getMessage());
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<?> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e) {
		System.err.println(e.getClass());
		System.err.println(e.getMessage());
		return ResponseEntity.badRequest().body("Can't convert");
	}

}
