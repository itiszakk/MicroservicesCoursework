package org.spbstu.service;

import dto.Treatment;

import java.util.List;
import java.util.Optional;

public interface TreatmentService {
    Optional<Treatment> findById(Integer id);
    Treatment add(Treatment treatment);
    void deleteById(Integer id);
    List<Treatment> findByPatientId(Integer patientId);
}
