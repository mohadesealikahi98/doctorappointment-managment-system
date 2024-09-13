package com.Doctorappointment.dms.customException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

public class GlobalExceptionHandler {

    @ExceptionHandler(AppointmentNotFoundException.class)
    public ResponseEntity<String> AppointmentNotFoundException(
            AppointmentNotFoundException exception,
            WebRequest webRequest){

        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(AppointmentTakenException.class)
    public ResponseEntity<String> AppointmentTakenException(
            AppointmentTakenException exception,
            WebRequest webRequest){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_ACCEPTABLE);
    }
}
