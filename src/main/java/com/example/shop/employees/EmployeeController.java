package com.example.shop.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getProducts();
    }

    @PostMapping("/add")
    public ResponseEntity<String> postEmployee(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("position") String position) {
        return employeeService.postEmployee(name, surname, position);
    }
}
