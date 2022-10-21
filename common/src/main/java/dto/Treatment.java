package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class Treatment {
    private final Integer id;
    private final Integer patientId;
    private final String description;
    private final Date treatmentDate;
}
