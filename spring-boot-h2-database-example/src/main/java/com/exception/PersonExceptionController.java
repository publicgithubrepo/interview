package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class PersonExceptionController extends ResponseEntityExceptionHandler  {
	
   @ExceptionHandler(value = PersonNotFoundException.class)
   public ResponseEntity<Object> exception(PersonNotFoundException exception) {
      return new ResponseEntity<>("Person not found", HttpStatus.NOT_FOUND);
   }
}
