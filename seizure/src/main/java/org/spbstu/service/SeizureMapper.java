package org.spbstu.service;

import org.spbstu.dto.Seizure;
import org.mapstruct.Mapper;
import org.spbstu.entity.SeizureEntity;

@Mapper(componentModel = "spring")
public interface SeizureMapper {
    Seizure toDto(SeizureEntity entity);
    SeizureEntity toEntity(Seizure dto);
}
