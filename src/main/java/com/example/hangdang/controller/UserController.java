package com.example.hangdang.controller;

import com.example.hangdang.dto.SignupRequestDto;
import com.example.hangdang.dto.UserInfoResponseDto;
import com.example.hangdang.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody SignupRequestDto requestDto) {
        userService.signup(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입이 완료되었습니다");
    }


    @GetMapping("/signup/check-name")
    public ResponseEntity<String> checkUsername(@RequestParam String username) {
        return userService.checkUsername(username);
    }


    @GetMapping("/userinfo/{userId}")
    public UserInfoResponseDto userInfo(@PathVariable Long userId) {
        return userService.userInfo(userId);
    }

}