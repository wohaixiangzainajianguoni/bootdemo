package com.zqg.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {




    @RequestMapping(value = "/success")
    public String toIndex()
    {


        return "success";

    }

    @RequestMapping(value = {"/","/index.html"})
    public String toIndex1()
    {


        return "index";

    }
}
