package com.zqg.bootdemo.service.impl;

import com.zqg.bootdemo.entities.Employee;
import com.zqg.bootdemo.mapper.EmployeeMapper;
import com.zqg.bootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void  insertEmployee(Employee employee) {

                employeeMapper.insertEmployee(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Employee> getAll() {
        return employeeMapper.getAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Employee employee) {

        Integer id = employee.getId();
        if (id == null) {
            employeeMapper.insertEmployee(employee);
        } else {

            employeeMapper.updateEmployee(employee);

        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(int id) {
        employeeMapper.delete(id);
    }

    @Override
    public Employee get(int id) {
        return employeeMapper.get(id);
    }
}
