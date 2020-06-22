package com.zqg.bootdemo.service;

import com.zqg.bootdemo.entities.Employee;

import java.util.Collection;

public interface EmployeeService {
    public void insertEmployee(Employee employee);

    Collection<Employee> getAll();

    void save(Employee employee);

    void delete(int id);

    Employee get(int id);
}
