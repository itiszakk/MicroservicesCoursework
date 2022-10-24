package org.spbstu.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientRequestParameters {
    private String firstName;
    private String lastName;
    private String patronymic;
}