package org.spbstu.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Treatment {
    private final Integer id;
    private final Integer patientId;
    private final String description;
    private final LocalDate treatmentDate;
}
