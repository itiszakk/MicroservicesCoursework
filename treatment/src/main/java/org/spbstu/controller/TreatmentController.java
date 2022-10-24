package org.spbstu.controller;

import org.spbstu.dto.Treatment;
import org.spbstu.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TreatmentController {

    private final TreatmentService service;

    @Autowired
    public TreatmentController(TreatmentService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Treatment> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Treatment findAll(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping(params = {"patient"})
    @ResponseStatus(HttpStatus.OK)
    public List<Treatment> findByAllPatientId(
            @RequestParam(name = "patient") int patientId) {
        return service.findAllByPatientId(patientId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Treatment add(@RequestBody Treatment treatment) {
        return service.add(treatment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable int id) {
        service.deleteById(id);
    }

    @DeleteMapping(params = {"patient"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllByPatientId(
            @RequestParam(name = "patient") int patientId) {
        service.deleteAllByPatientId(patientId);
    }
}
