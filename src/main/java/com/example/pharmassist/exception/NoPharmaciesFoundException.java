package com.example.pharmassist.exception;

public class NoPharmaciesFoundException extends RuntimeException{
	
	private final String message;

	public NoPharmaciesFoundException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	
	
	

}
