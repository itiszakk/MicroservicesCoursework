package org.spbstu.service;

import dto.Patient;
import org.mapstruct.Mapper;
import org.spbstu.entity.PatientEntity;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient toDTO(PatientEntity entity);
    PatientEntity toEntity(Patient dto);
}
