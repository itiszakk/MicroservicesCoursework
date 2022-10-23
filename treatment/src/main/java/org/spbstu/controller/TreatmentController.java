package org.spbstu.controller;

import dto.Treatment;
import org.spbstu.service.TreatmentMapper;
import org.spbstu.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
    public List<Treatment> findByPatientId(@RequestParam(name = "patient") String patientId) {
        return service.findByPatientId(Integer.valueOf(patientId));
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
}
