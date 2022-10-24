package org.spbstu.service;

import org.spbstu.dto.Treatment;

import java.util.List;
import java.util.Optional;

public interface TreatmentService {
    List<Treatment> findAll();
    Treatment findById(Integer id);
    List<Treatment> findAllByPatientId(Integer id);
    Treatment add(Treatment treatment);
    void deleteById(Integer id);
    void deleteAllByPatientId(Integer id);
}
