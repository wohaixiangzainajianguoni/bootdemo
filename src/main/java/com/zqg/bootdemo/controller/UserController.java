package com.zqg.bootdemo.controller;

import com.zqg.bootdemo.dao.EmployeeDao;
import com.zqg.bootdemo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    EmployeeDao employeeDao;

    @PostMapping(value = "/login")
    public String login(String Username, String Password, Model model, HttpSession session)
    {


        if("admin".equals(Username) && Password.equals("admin"))
        {

            session.setAttribute("currentUser",Username);

            Collection<Employee> all = employeeDao.getAll();

            model.addAttribute("employees",all);

// 防止表单的重复提交，使用重定向到新的页面,重定向配置在 ViewConfig类中webMvcConfigurerAdapter() 方法中配置
            //该配置相当于新建一个页面跳转的requestmapping();
           return  "redirect:/main.html";
        }else
        {
            model.addAttribute("loginError","用户名密码不匹配");
            return "index";
        }



    }
}
