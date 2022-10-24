package org.spbstu.controller;

import org.spbstu.dto.Patient;
import org.spbstu.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PatientController {

    @Value("${host.treatment}")
    private String treatmentHost;

    @Value("${host.treatment}")
    private String seizureHost;

    private final PatientService service;
    private final RestTemplate restTemplate;

    @Autowired
    public PatientController(PatientService service, RestTemplate restTemplate) {
        this.service = service;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<Patient> getAll(PatientRequestParameters parameters) {
        return service.getAll(parameters);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Patient getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Patient save(@RequestBody Patient patient) {
        return service.save(patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable int id) {
        // Delete patient itself
        service.deleteById(id);

        // Delete related entities
        restTemplate.delete(treatmentHost + "?patient={id}", id);
        restTemplate.delete(seizureHost + "?patient={id}", id);
    }
}