package com.example.springbootkeycloakexample.repository;

import com.example.springbootkeycloakexample.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
