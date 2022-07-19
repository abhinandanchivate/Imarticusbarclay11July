package com.barclays.employeeMS.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.barclays.employeeMS.exception.IdNotFoundException;

@ControllerAdvice
public class EmployeeAppControllerAdvice {

	@ExceptionHandler(value = IdNotFoundException.class)
	public ResponseEntity<?> idNotFoundExceptionHandler(IdNotFoundException exception) {
		return new ResponseEntity(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
