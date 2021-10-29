package com.example.shop.employees;

import com.example.shop.exceptions.EmployeeNotFoundException;
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
        Employee employee = new Employee(name, surname, position);
        employeeRepository.save(employee);
        return ResponseEntity.ok().body("Employee add to database");
    }

    public ResponseEntity<String> deleteStore(Long employeeId) {
        if (employeeRepository.findById(employeeId).isPresent()) {
            employeeRepository.deleteById(employeeId);
            return ResponseEntity.ok().body("Successfully deleted store with id " + employeeId);
        } else throw new EmployeeNotFoundException("Could not find store with id " + employeeId + " to delete");
    }
}
