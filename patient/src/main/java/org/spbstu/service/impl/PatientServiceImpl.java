package org.spbstu.service.impl;

import org.spbstu.controller.PatientRequestParameters;
import org.spbstu.dto.Patient;
import org.spbstu.entity.PatientEntity;
import org.spbstu.exception.PatientDTOException;
import org.spbstu.exception.PatientNotFoundException;
import org.spbstu.repository.PatientRepository;
import org.spbstu.service.PatientMapper;
import org.spbstu.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;
    private final PatientMapper mapper;

    @Autowired
    public PatientServiceImpl(PatientRepository repository, PatientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Patient> getAll(PatientRequestParameters parameters) {
        Specification<PatientEntity> specification = Specification.where(getSpecification(parameters));

        return repository.findAll(specification).stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public Patient getById(int id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new PatientNotFoundException(id));
    }

    @Transactional
    @Override
    public Patient save(Patient patient) {
        checkPatientDTO(patient);
        return mapper.toDTO(repository.save(mapper.toEntity(patient)));
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        Optional<PatientEntity> optionalPatientEntity = repository.findById(id);

        if (optionalPatientEntity.isEmpty()) {
            throw new PatientNotFoundException(id);
        }

        repository.deleteById(id);
    }

    private Specification<PatientEntity> getSpecification(PatientRequestParameters parameters) {
        Specification<PatientEntity> lastNameLike = fieldLike(
                PatientEntity.Fields.lastName,
                parameters.getLastName()
        );

        Specification<PatientEntity> firstNameLike = fieldLike(
                PatientEntity.Fields.firstName,
                parameters.getFirstName()
        );

        Specification<PatientEntity> patronymicLike = fieldLike(
                PatientEntity.Fields.patronymic,
                parameters.getPatronymic()
        );

        return Specification.where(lastNameLike).and(firstNameLike).and(patronymicLike);
    }

    private Specification<PatientEntity> fieldLike(String field, String value) {
        if (value == null)
            return null;

        return (root, query, builder) ->
                builder.like(root.get(field), "%" + value + "%");
    }

    private void checkPatientDTO(Patient patient) {
        if (patient.getLastName() == null || patient.getLastName().length() == 0) {
            throw new PatientDTOException(Patient.Fields.lastName);
        }

        if (patient.getFirstName() == null || patient.getFirstName().length() == 0) {
            throw new PatientDTOException(Patient.Fields.firstName);
        }

        try {
            LocalDate.parse(patient.getBirthdate());
        } catch (NullPointerException | DateTimeParseException e) {
            throw new PatientDTOException(Patient.Fields.birthdate);
        }
    }
}