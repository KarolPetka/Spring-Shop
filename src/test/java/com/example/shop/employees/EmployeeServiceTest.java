package com.example.shop.employees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repositoryTest;
    private EmployeeService serviceTest;

    @BeforeEach
    void setUp() {
        serviceTest = new EmployeeService(repositoryTest);
    }

    @Test
    void getProducts() {
        //when
        serviceTest.getProducts();

        //then
        verify(repositoryTest).findAll();
    }

    @Test
    void postEmployee() {
        //given
        Employee employee = new Employee("Karo", "Petka", "CEO");

        //when
        serviceTest.postEmployee(employee.getName(), employee.getSurname(), employee.getPosition());

        //then
        ArgumentCaptor<Employee> employeeArgumentCaptor = ArgumentCaptor.forClass(Employee.class);
        verify(repositoryTest).save(employeeArgumentCaptor.capture());
        Employee capturedEmployee = employeeArgumentCaptor.getValue();

        assertEquals(employee.getName(), capturedEmployee.getName());
        assertEquals(employee.getSurname(), capturedEmployee.getSurname());
        assertEquals(employee.getPosition(), capturedEmployee.getPosition());
    }

    @Test
    void deleteStore() {
        //given
        Employee employee = new Employee(1L,"Karo", "Petka", "CEO");

        //when
        serviceTest.deleteStore(employee.getId());

        //then
        verify(repositoryTest, times(1)).deleteById(employee.getId());
    }
}