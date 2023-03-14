package com.kakao.apiserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/sample")
public class SampleController {
    @GetMapping("/adam")
    public List<String> adam() {
        return Arrays.asList("강진축구", "사이버가수 아담", "프리스톤테일");
    }
}
