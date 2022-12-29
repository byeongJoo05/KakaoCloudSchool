package com.example.javaweb;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebListener
public class ApplicationListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public ApplicationListener() {
    }

    // 웹 서버가 구동될 때 호출되는 메서드
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.println("웹 서버 시작");
    }

    // 웹 서버가 종료된 때 호출되는 메서드
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("웹 서버 종료");
    }
}
