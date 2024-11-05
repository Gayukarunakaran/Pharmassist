package com.example.pharmassist.exception;

@SuppressWarnings("serial")
public class PatientNotFoundByIdException extends RuntimeException {
    
    private String message;

    public PatientNotFoundByIdException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
