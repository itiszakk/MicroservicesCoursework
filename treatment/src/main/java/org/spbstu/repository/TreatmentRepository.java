package org.spbstu.repository;

import org.spbstu.entity.TreatmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentRepository
        extends JpaRepository<TreatmentEntity, Integer> {

    List<TreatmentEntity> findByPatientId(Integer id);
    void deleteAllByPatientId(Integer id);
}
