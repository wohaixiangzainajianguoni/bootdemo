package com.zqg.bootdemo.config;

import com.zqg.bootdemo.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ViewConfig {


    @Bean
    public WebMvcConfigurerAdapter  webMvcConfigurerAdapter(){

        WebMvcConfigurerAdapter webMvcConfigurationSupport = new WebMvcConfigurerAdapter(){

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {

                registry.addInterceptor(new LoginInterceptor()
                ).addPathPatterns("/**").excludePathPatterns("/").
                        excludePathPatterns("/index.html","/","/user/login")

                ;
            }
        };
        return  webMvcConfigurationSupport;


    }


}
