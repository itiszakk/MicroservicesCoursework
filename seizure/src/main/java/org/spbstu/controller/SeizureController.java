package org.spbstu.controller;

import org.spbstu.service.SeizureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeizureController {
    private final SeizureService service;

    @Autowired
    public SeizureController(SeizureService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Seizure> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Seizure findById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping(params = {"patient"})
    @ResponseStatus(HttpStatus.OK)
    public List<Seizure> findAllByPatientId(@RequestParam(name = "patient") int patientId) {
        return service.findAllByPatientId(patientId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Seizure add(@RequestBody Seizure seizure) {
        return service.add(seizure);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

    @DeleteMapping(params = {"patient"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllByPatientId(@RequestParam(name = "patient") int patientId) {
        service.deleteAllByPatientId(patientId);
    }
}
