package com.ktds.finalproject.plannerbe.domain.user.controller;

import com.ktds.finalproject.plannerbe.domain.user.dto.User;
import com.ktds.finalproject.plannerbe.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/join")
    public String joinForm() {
        return "join";
    }

    @PostMapping("/join")
    public ResponseEntity<User> join(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return ResponseEntity.ok(userService.login(user.getEmail(), user.getPassword()).orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 일치하지 않습니다.")));
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
