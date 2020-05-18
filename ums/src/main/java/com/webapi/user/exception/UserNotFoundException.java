package com.webapi.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -2250239907387184557L;

		public UserNotFoundException(String string) {
			
			 super(String.valueOf(string));
			 //System.out.println("in const");
		}
}
