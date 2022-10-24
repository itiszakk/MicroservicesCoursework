package org.spbstu.exception;

public class TreatmentNotFoundException extends RuntimeException {

    public TreatmentNotFoundException(Integer id) {
        super(String.format("Treatment with id '%d' not found", id));
    }
}
