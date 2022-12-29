package com.example.javaweb;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebListener
public class SessionListener implements HttpSessionListener {
    // 접속자 수를 저장
    private static int count;

    public static int getCount() {
        return count;
    }

    public SessionListener() {
    }

    // 세션이 만들어 질 때 - 새로운 접속이 온 경우
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        count++;
        System.out.println("접속자 수 : "+count);

        HttpSession session = se.getSession();
        System.out.println("세션 아이디:"+session.getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }
}
