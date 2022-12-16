package com.example.springbootkeycloakexample.service;

import com.example.springbootkeycloakexample.entity.Employee;
import com.example.springbootkeycloakexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct // 의존성 주입이 이루어진 후 초기화를 수행하는 메서드, 다른 리소스에서 호출되지 않아도 수행
    public void initializeEmployeeTable() {
        employeeRepository.saveAll(
                Stream.of(
                        new Employee("Jitae", 20000),
                        new Employee("Jin", 55000),
                        new Employee("Minseok", 120000)
                ).collect(Collectors.toList()));
    }

    public Employee getEmployee(int employeeId) {
        return employeeRepository
                .findById(employeeId)
                .orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository
                .findAll();
    }
}
