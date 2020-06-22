package com.zqg.bootdemo.mapper;

import com.zqg.bootdemo.entities.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.Collection;


public interface EmployeeMapper {

    public  void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void delete(int id);

    Employee get(int id);

    Collection<Employee> getAll();
}
