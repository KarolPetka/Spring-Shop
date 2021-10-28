package com.example.shop.stores;

import com.example.shop.employees.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "storeId", referencedColumnName = "id")
    List<Employee> employees = new ArrayList<>();

    public Store() {
    }

    public Store(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public Store(Long id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
