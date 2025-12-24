package com.example.demo.config;

import com.example.demo.servlet.HelloServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean<HelloServlet> helloServletRegistration(
            HelloServlet servlet) {

        ServletRegistrationBean<HelloServlet> registration =
                new ServletRegistrationBean<>(servlet, "/hello");
        registration.setLoadOnStartup(1);
        return registration;
    }
}
