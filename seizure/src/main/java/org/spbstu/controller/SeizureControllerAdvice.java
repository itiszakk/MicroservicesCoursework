package org.spbstu.controller;

import org.spbstu.exception.SeizureDTOException;
import org.spbstu.exception.SeizureNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SeizureControllerAdvice {

    @ExceptionHandler(value = SeizureNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleSeizureNotFoundException(SeizureNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(value = SeizureDTOException.class)
    public ResponseEntity<ErrorResponse> handleSeizureDTOException(SeizureDTOException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }
}
