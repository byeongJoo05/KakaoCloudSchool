package com.example.javaweb;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/javaweb")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.write("<html><head><title>Servlet");
        out.write("</title></head><body>");
        out.write("<h1>처음 만들어본 웹 애플리케이션</h1>");
        out.write("</body></html>");
        out.close();
    }

    public void destroy() {
    }
}