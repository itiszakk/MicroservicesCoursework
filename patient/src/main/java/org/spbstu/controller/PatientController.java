package org.spbstu.controller;

import controller.PatientRequestParameters;
import dto.Patient;
import dto.Treatment;
import org.spbstu.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class PatientController {

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
        return (parameters.allEmpty())
                ? service.getAll()
                : service.getAll(parameters);
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
        //this.<Treatment>deleteRelatedEntities("treatment", id);

        service.deleteById(id);
    }

    //private <T> void deleteRelatedEntities(String serviceName, int patientId) {
    //    Class dtoClass = Class<T[]>;
//
    //    ResponseEntity<dtoClass> response = restTemplate.getForEntity(
    //            "http://{service}?patient={id}",
    //            dtoClass,
    //            serviceName,
    //            patientId
    //    );
//
    //    List<Treatment> treatmentList = Arrays.stream(response.getBody()).toList();
//
    //    treatmentList.forEach(treatment -> {
    //        restTemplate.delete("http://treatment/{id}", treatment.getId());
    //    });
    //}
}
