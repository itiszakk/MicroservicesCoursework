package org.spbstu.service.impl;

import org.spbstu.dto.Treatment;
import org.spbstu.entity.TreatmentEntity;
import org.spbstu.exception.TreatmentDTOException;
import org.spbstu.exception.TreatmentNotFoundException;
import org.spbstu.repository.TreatmentRepository;
import org.spbstu.service.TreatmentMapper;
import org.spbstu.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    public List<Treatment> findAll() {
        return repository.findAll().stream()
                .map(treatmentMapper::toDTO)
                .toList();
    }

    @Override
    public Treatment findById(Integer id) {
        return repository.findById(id)
                .map(treatmentMapper::toDTO)
                .orElseThrow(() -> new TreatmentNotFoundException(id));
    }

    @Override
    public List<Treatment> findAllByPatientId(Integer id) {
        return repository.findByPatientId(id).stream().map(treatmentMapper::toDTO).toList();
    }

    @Transactional
    @Override
    public Treatment add(Treatment treatment) {
        checkTreatmentDTO(treatment);
        return treatmentMapper.toDTO(repository.save(treatmentMapper.toEntity(treatment)));
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        Optional<TreatmentEntity> optionalEntity = repository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new TreatmentNotFoundException(id);
        }

        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAllByPatientId(Integer id) {
        repository.deleteAllByPatientId(id);
    }

    private void checkTreatmentDTO(Treatment treatment) {
        if (treatment.getPatientId() == 0) {
            throw new TreatmentDTOException(Treatment.Fields.patientId);
        }

        if (treatment.getDescription() == null || treatment.getDescription().length() == 0) {
            throw new TreatmentDTOException(Treatment.Fields.description);
        }

        try {
            LocalDate.parse(treatment.getTreatmentDate());
        } catch (NullPointerException | DateTimeParseException e) {
            throw new TreatmentDTOException(Treatment.Fields.treatmentDate);
        }
    }
}
