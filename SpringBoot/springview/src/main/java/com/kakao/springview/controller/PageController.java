package com.kakao.springview.controller;

import com.kakao.springview.domain.SampleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@Slf4j
public class PageController {
    @GetMapping("/")
    public String main(Model model) {
        Map<String, Object> map = new HashMap<>();
        map.put("language", "Java");
        map.put("buildtool", "Gradle");
        map.put("ide", "IntelliJ");
        model.addAttribute("map", map);

        List<String> list = new ArrayList<>();
        list.add("Developer");
        list.add("Operator");
        list.add("MLOps");
        list.add("DevOps");
        list.add("DBA");

        model.addAttribute("list", list);

        return "main";
    }

    @GetMapping("/ex1")
    // 리턴 타입이 void 이면 출력하는 뷰 이름은 요청 URL
    // view 의 이름은 ex1
    public void ex1(Model model) {
        log.info("ex1 요청");
    }

    @GetMapping("/ex2")
    public void ex2(Model model) {
        List<SampleVO> list = IntStream.rangeClosed(1, 20).asLongStream().mapToObj(
                i-> {
                    SampleVO vo = SampleVO.builder()
                            .sno(i)
                            .first("First.." + i)
                            .last("Last.." + i)
                            .regTime(LocalDateTime.now())
                            .build();

                    return vo;
                }
        ).collect(Collectors.toList());
        model.addAttribute("list", list);
    }
}
