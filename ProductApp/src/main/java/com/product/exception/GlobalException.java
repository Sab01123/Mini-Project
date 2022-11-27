package com.product.exception;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

	//product exception
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<Error> productException(ProductException e, WebRequest web){
		
		Error err = new Error(e.getMessage(),LocalDate.now(),LocalTime.now(),web.getDescription(false));
		
		return new ResponseEntity<Error>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<Error> adminException(AdminException e, WebRequest web){
		
		Error err = new Error(e.getMessage(),LocalDate.now(),LocalTime.now(),web.getDescription(false));
		
		return new ResponseEntity<Error>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<Error> categoryException(CategoryException e, WebRequest web){
		
		Error err = new Error(e.getMessage(),LocalDate.now(),LocalTime.now(),web.getDescription(false));
		
		return new ResponseEntity<Error>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> exception(Exception e, WebRequest web){
		
		Error err = new Error(e.getMessage(),LocalDate.now(),LocalTime.now(),web.getDescription(false));
		
		return new ResponseEntity<Error>(err, HttpStatus.BAD_REQUEST);
	}
}

