package com.example.pharmassist.exception;

@SuppressWarnings("serial")
public class PharmacyNotFoundByIdException extends RuntimeException
{
	private String message;

	public PharmacyNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


}
