package org.spbstu.service;

import dto.Treatment;
import org.mapstruct.Mapper;
import org.spbstu.entity.TreatmentEntity;

@Mapper(componentModel = "spring")
public interface TreatmentMapper {
    Treatment toDTO(TreatmentEntity entity);
    TreatmentEntity toEntity(Treatment dto);
}
