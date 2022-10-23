package org.spbstu.service;

import controller.PatientRequestParameters;
import dto.Patient;

import java.util.List;

public interface PatientService {

    List<Patient> getAll();
    List<Patient> getAll(PatientRequestParameters parameters);
    Patient getById(int id);
    Patient save(Patient patient);
    void deleteById(int id);
}