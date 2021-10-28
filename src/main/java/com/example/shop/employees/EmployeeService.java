package com.example.shop.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getProducts() {
        return employeeRepository.findAll();
    }

    public ResponseEntity<String> postEmployee(String name, String surname, String position) {
        return ResponseEntity.status(500).body("Method not implemented");
    }
}
