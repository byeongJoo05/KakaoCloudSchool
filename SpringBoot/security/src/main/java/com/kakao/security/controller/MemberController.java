package com.kakao.security.controller;

import com.kakao.security.dto.ClubMemberJoinDTO;
import com.kakao.security.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    // 회원 가입 페이지로 이동
    @GetMapping("/join")
    public void join() {

    }

    // 회원 가입 처리
    @PostMapping("/join")
    public String join(ClubMemberJoinDTO memberJoinDTO,
                       RedirectAttributes rattr) {
        log.info(memberJoinDTO);
        try{
            memberService.join(memberJoinDTO);
            // 성공
        }catch (Exception e){ // 아이디 중복이 일어나서 Exception이 나면 이 쪽으로 간다.
            rattr.addFlashAttribute("error", "mid");
            rattr.addFlashAttribute("dto", memberJoinDTO); // 만약 실패했을 때 dto에 넣어서 가면 join 페이지가 비어있는 것을 막을 수 있다.
            return "redirect:/member/join";
        }
        rattr.addFlashAttribute("result", "success");

        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public void login(String error, String logout) {
        // error는 로그인이 실패했을 경우의 파라미터
        log.info("error: " + error);

        // logout은 로그아웃한 후 로그인으로 이동했을 때 파라미터
        log.info("logout: " + logout);

        if (error != null) {

        }
        if (logout != null) {
            log.info("[MemberContoller] logout !");

        }

    }
}