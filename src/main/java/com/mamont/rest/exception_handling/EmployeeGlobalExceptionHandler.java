package com.mamont.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exeption) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exeption.getMessage());

        return  new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exeption) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exeption.getMessage());

        return  new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
