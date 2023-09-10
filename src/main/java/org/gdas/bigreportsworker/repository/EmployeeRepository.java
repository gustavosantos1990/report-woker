package org.gdas.bigreportsworker.repository;

import org.gdas.bigreportsworker.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {}
