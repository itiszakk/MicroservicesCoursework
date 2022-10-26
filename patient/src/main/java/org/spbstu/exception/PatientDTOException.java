package org.spbstu.exception;

public class PatientDTOException extends RuntimeException {

    public PatientDTOException(String field) {
        super(String.format("Field '%s' is missing or not supported", field));
    }
}
