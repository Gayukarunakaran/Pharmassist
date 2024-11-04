package com.example.pharmassist.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassist.exception.AdminNotFoundByIdException;
import com.example.pharmassist.exception.PharmacyNotFoundException;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.ErrorStructure;

@RestControllerAdvice
public class PharmacyExceptionHandler {
	private final AppResponseBuilder appResponseBuilder;

	public PharmacyExceptionHandler(AppResponseBuilder appResponseBuilder)	{
		super();
		this.appResponseBuilder = appResponseBuilder;
	}

	@ExceptionHandler(PharmacyNotFoundException.class)
	public static <T> ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(AdminNotFoundByIdException ex) {
		
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"Pharmacy not found by Id");

	}

	

}
