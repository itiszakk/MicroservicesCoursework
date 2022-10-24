package org.spbstu.service;

import org.spbstu.dto.Seizure;

import java.util.List;

public interface SeizureService {
    List<Seizure> findAll();
    Seizure findById(Integer id);
    List<Seizure> findAllByPatientId(Integer id);
    Seizure add(Seizure treatment);
    void deleteById(Integer id);
    void deleteAllByPatientId(Integer id);
}
