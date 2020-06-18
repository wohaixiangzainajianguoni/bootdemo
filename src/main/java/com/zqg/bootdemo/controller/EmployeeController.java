package com.zqg.bootdemo.controller;

import com.zqg.bootdemo.dao.DepartmentDao;
import com.zqg.bootdemo.dao.EmployeeDao;
import com.zqg.bootdemo.entities.Department;
import com.zqg.bootdemo.entities.Employee;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Collection;

@RequestMapping("/employee")
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/list")
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

    @PostMapping(value = "/emp")
    public String add(Employee employee){

        employeeDao.save(employee);

        return "redirect:/employee/list";


    }
    @PutMapping(value = "/emp")
    public String update(Employee employee){

        employeeDao.save(employee);


        return "redirect:/employee/list";


    }

    @DeleteMapping( value = "/emp/{id}")
    public String delete( @PathVariable(value = "id") int id){

       employeeDao.delete(id);
        Collection<Employee> all = employeeDao.getAll();
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/toEdit/{id}")
    public String toEdit(@PathVariable(value = "id") int id,Model model)
    {
        Employee employee = employeeDao.get(id);

        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emps/add";




    }




}
