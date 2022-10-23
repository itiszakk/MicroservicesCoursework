package org.spbstu.repository;

import org.spbstu.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository
        extends JpaRepository<PatientEntity, Integer>, JpaSpecificationExecutor<PatientEntity> {

}
