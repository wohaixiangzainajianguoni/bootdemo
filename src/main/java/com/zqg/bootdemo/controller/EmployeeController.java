package com.zqg.bootdemo.controller;

import com.zqg.bootdemo.dao.DepartmentDao;
import com.zqg.bootdemo.dao.EmployeeDao;
import com.zqg.bootdemo.entities.Department;
import com.zqg.bootdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.Collection;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/list")
    public String list(Model model)
    {

        Collection<Employee> all = employeeDao.getAll();

        model.addAttribute("employees",all);

        return "emps/list";


    }

    @GetMapping(value = "/emp")
    public String toAddPage(Model model)
    {

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";

    }


}
