package org.spbstu.dto;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@FieldNameConstants
public class Patient {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final String birthdate;
}
