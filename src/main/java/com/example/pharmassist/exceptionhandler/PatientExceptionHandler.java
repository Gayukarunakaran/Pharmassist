package com.example.pharmassist.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassist.exception.NoPatientsFoundException;
import com.example.pharmassist.exception.PatientNotFoundByIdException;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.ErrorStructure;

@RestControllerAdvice
public class PatientExceptionHandler {
    private final AppResponseBuilder appResponseBuilder;

    public PatientExceptionHandler(AppResponseBuilder appResponseBuilder) {
        super();
        this.appResponseBuilder = appResponseBuilder;
    }

    @ExceptionHandler(NoPatientsFoundException.class)
    public static <T> ResponseEntity<ErrorStructure<String>> handleNoPatientsFoundException(NoPatientsFoundException ex) {
        return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "No patients found for the given Pharmacy ID");
    }
    
    @ExceptionHandler(PatientNotFoundByIdException.class)
    public static <T> ResponseEntity<ErrorStructure<String>> handlePatientNotFoundByIdException(PatientNotFoundByIdException ex) {
        return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(), "Patient found by Id");
    }
}
