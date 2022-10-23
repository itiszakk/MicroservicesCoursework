package org.spbstu.exception;

public class PatientNotFoundException extends RuntimeException {

    public PatientNotFoundException(int id) {
        super(String.format("Patient with id '%d' not found", id));
    }
}
