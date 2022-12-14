package org.spbstu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@FieldNameConstants
public class Treatment {
    private final int id;
    private final int patientId;
    private final String description;
    private final String treatmentDate;
}
