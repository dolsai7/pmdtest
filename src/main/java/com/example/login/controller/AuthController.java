package com.example.login.controller;

import com.example.login.dto.LoginRequest;
import com.example.login.dto.LoginResponse;
import com.example.login.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req) {
        String reason = authService.validate(req.getId(), req.getPassword());
        if (reason != null) {
            return ResponseEntity.ok(new LoginResponse(false, reason, req.getId()));
        }
        return ResponseEntity.ok(new LoginResponse(true, "로그인 성공", req.getId()));
    }
}