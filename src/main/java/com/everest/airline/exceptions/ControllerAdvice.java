package com.everest.airline.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;


@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException e, WebRequest request)
    {
        HashMap<String,Object> body = new HashMap<>();
        body.put("timeStamp", LocalDate.now());
        body.put("message","No flights are available with entered details");
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }


}
