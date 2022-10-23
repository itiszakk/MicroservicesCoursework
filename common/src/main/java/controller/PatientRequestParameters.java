package controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PatientRequestParameters {
    private String firstName;
    private String lastName;
    private String patronymic;

    public boolean allEmpty() {
        boolean firstNameEmpty = (firstName == null || firstName.length() == 0);
        boolean lastNameEmpty = (lastName == null || lastName.length() == 0);
        boolean patronymicEmpty = (patronymic == null || patronymic.length() == 0);

        return firstNameEmpty && lastNameEmpty && patronymicEmpty;
    }
}