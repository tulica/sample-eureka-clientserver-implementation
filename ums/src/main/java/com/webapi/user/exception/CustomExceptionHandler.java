package com.webapi.user.exception;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
//	@Autowired
	
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
//		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
//		System.out.println(ex.toString());
//		return new ResponseEntity(exceptionresponse, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
//	@ExceptionHandler(UserNotFoundException.class)
//	public final ResponseEntity UserNotFoundExceptions(UserNotFoundException ex, WebRequest request){
//		ExceptionResponse exceptionresponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
//		
//		return new ResponseEntity(exceptionresponse, HttpStatus.NOT_FOUND);
//	}
//	
	

}
