package com.example.pharmassist.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassist.exception.AdminNotFoundByIdException;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.ErrorStructure;

@RestControllerAdvice
public class UserExceptionHandler {
	private final AppResponseBuilder appResponseBuilder;

	public UserExceptionHandler(AppResponseBuilder appResponseBuilder)	{
		super();
		this.appResponseBuilder = appResponseBuilder;
	}

	@ExceptionHandler(AdminNotFoundByIdException.class)
	public static <T> ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(AdminNotFoundByIdException ex) {
		
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"User not found by Id");

	}

	

}
