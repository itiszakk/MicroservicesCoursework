package org.spbstu.exception;

public class SeizureDTOException extends RuntimeException {

    public SeizureDTOException(String field) {
        super(String.format("Field '%s' is missing or not supported", field));
    }
}
