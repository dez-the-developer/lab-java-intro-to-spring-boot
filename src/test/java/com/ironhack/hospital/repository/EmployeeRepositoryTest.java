package com.ironhack.hospital.repository;

import com.ironhack.hospital.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindByStatus() {
        List<Employee> onCallEmployees = employeeRepository.findByStatus("ON_CALL");
        assertEquals(2, onCallEmployees.size());
    }

    @Test
    public void testFindByDepartment() {
        List<Employee> cardiologyEmployees = employeeRepository.findByDepartment("cardiology");
        assertEquals(2, cardiologyEmployees.size());
    }
}
