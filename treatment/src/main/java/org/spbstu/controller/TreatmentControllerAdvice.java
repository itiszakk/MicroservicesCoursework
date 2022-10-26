package org.spbstu.controller;

import org.spbstu.exception.TreatmentDTOException;
import org.spbstu.exception.TreatmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TreatmentControllerAdvice {

    @ExceptionHandler(value=TreatmentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTreatmentNotFoundException(TreatmentNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(value=TreatmentDTOException.class)
    public ResponseEntity<ErrorResponse> handleTreatmentDTOException(TreatmentDTOException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }
}
