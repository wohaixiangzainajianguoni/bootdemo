package com.zqg.bootdemo.service.impl;

import com.zqg.bootdemo.entities.Department;
import com.zqg.bootdemo.mapper.DepartmentMapper;
import com.zqg.bootdemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Override
    public Collection<Department> getDepartments() {
        return departmentMapper.getDepartments();
    }
}
