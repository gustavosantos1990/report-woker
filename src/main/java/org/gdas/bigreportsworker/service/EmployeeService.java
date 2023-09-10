package org.gdas.bigreportsworker.service;

import org.gdas.bigreportsworker.model.entity.Employee;
import org.gdas.bigreportsworker.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class   EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

}
