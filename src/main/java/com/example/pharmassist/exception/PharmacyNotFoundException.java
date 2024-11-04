package com.example.pharmassist.exception;

@SuppressWarnings("serial")
public class PharmacyNotFoundException extends RuntimeException
{
	private String message;

	public PharmacyNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


}
