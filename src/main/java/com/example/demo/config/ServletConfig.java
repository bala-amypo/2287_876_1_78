// package com.example.demo.config;

// import com.example.demo.servlet.HelloServlet;
// import org.springframework.boot.web.servlet.ServletRegistrationBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class ServletConfig {

//     @Bean
//     public HelloServlet helloServlet() {
//         return new HelloServlet(); // Bean create panrom
//     }

//     @Bean
//     public ServletRegistrationBean<HelloServlet> helloServletRegistration(HelloServlet helloServlet) {
//         ServletRegistrationBean<HelloServlet> registrationBean = new ServletRegistrationBean<>(helloServlet, "/hello");
//         return registrationBean;
//     }
// }
