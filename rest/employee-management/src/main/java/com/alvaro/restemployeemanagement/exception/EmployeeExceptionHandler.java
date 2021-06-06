package com.alvaro.restemployeemanagement.exception;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest webRequest) {
        EmployeeExceptionResponse response = new EmployeeExceptionResponse(ex.getMessage(),
            webRequest.getDescription(false), new Date());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleAllNotFoundExceptions(Exception ex, WebRequest webRequest) {
        EmployeeExceptionResponse response = new EmployeeExceptionResponse(ex.getMessage(),
            webRequest.getDescription(false), new Date());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,
        WebRequest request) {
        EmployeeExceptionResponse response = new EmployeeExceptionResponse("Invalid input",
            ex.getBindingResult().toString(), new Date());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
