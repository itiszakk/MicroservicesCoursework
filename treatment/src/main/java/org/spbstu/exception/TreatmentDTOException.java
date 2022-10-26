package org.spbstu.exception;

public class TreatmentDTOException extends RuntimeException {

    public TreatmentDTOException(String field) {
        super(String.format("Field '%s' is missing or not supported", field));
    }
}
