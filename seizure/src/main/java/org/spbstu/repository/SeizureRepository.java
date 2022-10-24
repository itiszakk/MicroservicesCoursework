package org.spbstu.repository;

import org.spbstu.entity.SeizureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeizureRepository extends JpaRepository<SeizureEntity, Integer>{
    List<SeizureEntity> findByPatientId(Integer id);
    void deleteAllByPatientId(Integer id);
}
