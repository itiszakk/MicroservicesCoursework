package dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Patient {
    private final Integer id;
    private final String lastName;
    private final String firstName;
    private final String patronymic;
    private final LocalDate birthdate;
}
