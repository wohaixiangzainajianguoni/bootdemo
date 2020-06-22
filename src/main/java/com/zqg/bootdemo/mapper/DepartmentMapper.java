package com.zqg.bootdemo.mapper;

import com.zqg.bootdemo.entities.Department;

import java.util.Collection;

public interface DepartmentMapper {
    Collection<Department> getDepartments();
}
