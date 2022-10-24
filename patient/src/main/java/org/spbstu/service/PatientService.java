package org.spbstu.service;

import org.spbstu.controller.PatientRequestParameters;
import org.spbstu.dto.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAll(PatientRequestParameters parameters);
    Patient getById(int id);
    Patient save(Patient patient);
    void deleteById(int id);
}