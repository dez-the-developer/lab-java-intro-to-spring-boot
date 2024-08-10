package com.ironhack.hospital.repository;

import com.ironhack.hospital.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testFindByDateOfBirthBetween() {
        List<Patient> patients = patientRepository.findByDateOfBirthBetween(LocalDate.of(1980, 1, 1), LocalDate.of(2000, 12, 31));
        assertEquals(3, patients.size());
    }
}
