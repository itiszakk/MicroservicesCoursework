package org.spbstu.service.impl;

import dto.Treatment;
import org.spbstu.entity.TreatmentEntity;
import org.spbstu.repository.TreatmentRepository;
import org.spbstu.service.TreatmentMapper;
import org.spbstu.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepository repository;
    private final TreatmentMapper treatmentMapper;

    @Autowired
    public TreatmentServiceImpl(TreatmentRepository repository, TreatmentMapper treatmentMapper) {
        this.repository = repository;
        this.treatmentMapper = treatmentMapper;
    }

    @Override
    public Optional<Treatment> findById(Integer id) {
        return repository.findById(id).map(treatmentMapper::toDTO);
    }

    @Override
    public Treatment add(Treatment treatment) {
        TreatmentEntity entity = repository.save(treatmentMapper.toEntity(treatment));
        System.out.println(entity);

        return treatmentMapper.toDTO(entity);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public List<Treatment> findByPatientId(Integer patientId) {
        return repository.findByPatientId(patientId).stream().map(treatmentMapper::toDTO).toList();
    }
}
