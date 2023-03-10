package com.kakao.communications.controller;

import com.kakao.communications.service.WebPushService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ChatController {
    @GetMapping("/")
    public String chat() {
        return "chatting";
    }

    private final WebPushService webPushService;

    @GetMapping("/push")
    public void push(HttpServletRequest request, HttpServletResponse response) {
        webPushService.push(request, response);
    }
}
