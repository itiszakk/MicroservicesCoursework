package org.spbstu.service.impl;

import org.spbstu.dto.Seizure;
import org.spbstu.entity.SeizureEntity;
import org.spbstu.exception.SeizureDTOException;
import org.spbstu.exception.SeizureNotFoundException;
import org.spbstu.repository.SeizureRepository;
import org.spbstu.service.SeizureMapper;
import org.spbstu.service.SeizureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class SeizureServiceImpl implements SeizureService {

    private final SeizureRepository repository;
    private final SeizureMapper seizureMapper;

    @Autowired
    public SeizureServiceImpl(SeizureRepository repository, SeizureMapper seizureMapper) {
        this.repository = repository;
        this.seizureMapper = seizureMapper;
    }

    @Override
    public List<Seizure> findAll() {
        return repository.findAll().stream()
                .map(seizureMapper::toDto).toList();
    }

    @Override
    public Seizure findById(Integer id) {
        return repository.findById(id)
                .map(seizureMapper::toDto)
                .orElseThrow(() -> new SeizureNotFoundException(id));
    }

    @Override
    public List<Seizure> findAllByPatientId(Integer id) {
        return repository.findByPatientId(id).stream().map(seizureMapper::toDto).toList();
    }

    @Transactional
    @Override
    public Seizure add(Seizure seizure) {
        checkSeizureDTO(seizure);
        return seizureMapper.toDto(repository.save(seizureMapper.toEntity(seizure)));
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        Optional<SeizureEntity> optionalEntity = repository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new SeizureNotFoundException(id);
        }

        repository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAllByPatientId(Integer id) {
        repository.deleteAllByPatientId(id);
    }

    private void checkSeizureDTO(Seizure seizure) {
        if (seizure.getPatientId() == 0) {
            throw new SeizureDTOException(Seizure.Fields.patientId);
        }

        if (seizure.getDescription() == null || seizure.getDescription().length() == 0) {
            throw new SeizureDTOException(Seizure.Fields.description);
        }

        try {
            LocalDate.parse(seizure.getSeizureDate());
        } catch (NullPointerException | DateTimeParseException e) {
            throw new SeizureDTOException(Seizure.Fields.seizureDate);
        }
    }
}
