package com.ironhack.hospital.controller;

import com.ironhack.hospital.model.Patient;
import com.ironhack.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @GetMapping("/dob")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByDateOfBirthRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return patientRepository.findByDateOfBirthBetween(startDate, endDate);
    }

    @GetMapping("/admitted-by-department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByAdmittingDoctorDepartment(@PathVariable String department) {
        return patientRepository.findByAdmittedByDepartment(department);
    }

    @GetMapping("/admitted-by-status/OFF")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getPatientsByAdmittingDoctorStatusOff() {
        return patientRepository.findByAdmittedByStatus("OFF");
    }
}