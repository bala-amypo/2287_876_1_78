package com.example.demo.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;

@Component
public class HelloServlet extends HttpServlet {

 @Override
public void doGet(HttpServletRequest request,
                  HttpServletResponse response) throws IOException {
    response.getWriter().write("Hello");
}


        PrintWriter out = response.getWriter();
        out.print("Hello Servlet");
        out.flush();
    }
}
