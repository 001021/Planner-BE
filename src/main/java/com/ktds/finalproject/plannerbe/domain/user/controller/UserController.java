package com.ktds.finalproject.plannerbe.domain.user.controller;

import com.ktds.finalproject.plannerbe.domain.user.dto.User;
import com.ktds.finalproject.plannerbe.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/join")
    public String showJoinForm() {
        return "create-account";
    }

    @PostMapping("/join")
    public String joinUser(User user, RedirectAttributes redirectAttributes) {
        try {
            userService.registerUser(user);
            redirectAttributes.addFlashAttribute("message", "회원가입이 완료되었습니다.");
            return "redirect:login";
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
            return "redirect:join";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        try {
            User user = userService.login(email, password).orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다."));
            model.addAttribute("user", user);
            return "redirect:/"; // 로그인 성공 시 리다이렉트할 페이지
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "login"; // 로그인 실패 시 다시 로그인 페이지로
        }
    }





    // 로그인
    // 로그아웃
    // 회원정보 수정
    // 회원탈퇴
    // 회원정보 조회
    // 비밀번호 찾기
    // 비밀번호 변경
    // 이메일 인증
    // 이메일 재전송
    // 이메일 중복확인


}
