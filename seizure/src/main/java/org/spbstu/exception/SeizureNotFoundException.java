package org.spbstu.exception;

public class SeizureNotFoundException  extends RuntimeException{
    public SeizureNotFoundException(Integer id) { super(String.format("Seizure with id '%d' not found", id)); }
}
