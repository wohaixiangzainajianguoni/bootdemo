package com.zqg.bootdemo.controller;

import com.zqg.bootdemo.dao.DepartmentDao;
import com.zqg.bootdemo.dao.EmployeeDao;
import com.zqg.bootdemo.entities.Department;
import com.zqg.bootdemo.entities.Employee;
import com.zqg.bootdemo.service.DepartmentService;
import com.zqg.bootdemo.service.EmployeeService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RequestMapping("/employee")
@Controller
public class EmployeeController {



    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/list")
    public String list(Model model)
    {

        Collection<Employee> all = employeeService.getAll();

        model.addAttribute("employees",all);

        return "emps/list";


    }

    @GetMapping(value = "/emp")
    public String toAddPage(Model model)
    {

        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";

    }

    @PostMapping(value = "/emp")
    public String add(Employee employee){

        employeeService.save(employee);
        System.out.println(employee.getId());

        return "redirect:/employee/list";


    }
    @PutMapping(value = "/emp")
    public String update(Employee employee){

        employeeService.save(employee);


        return "redirect:/employee/list";


    }

    @DeleteMapping( value = "/emp/{id}")
    public String delete( @PathVariable(value = "id") int id){

        employeeService.delete(id);
        Collection<Employee> all = employeeService.getAll();
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/toEdit/{id}")
    public String toEdit(@PathVariable(value = "id") int id,Model model)
    {
        Employee employee = employeeService.get(id);

        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentService.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";




    }




}
