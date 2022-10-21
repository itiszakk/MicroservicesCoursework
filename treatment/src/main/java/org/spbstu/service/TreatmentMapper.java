package org.spbstu.service;

import dto.Treatment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.spbstu.entity.TreatmentEntity;

@Mapper(componentModel = "spring")
public interface TreatmentMapper {
    TreatmentMapper INSTANCE = Mappers.getMapper(TreatmentMapper.class);
    Treatment toDTO(TreatmentEntity entity);
    TreatmentEntity toEntity(Treatment dto);
}
