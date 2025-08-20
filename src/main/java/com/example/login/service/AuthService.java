package com.example.login.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    /**
     * 요구사항:
     * - 비밀번호는 영어 대소문자와 숫자만 허용
     * - 최소 8자 이상
     * - (데모) 아이디는 비어있지만 않으면 통과
     *
     * @return 실패 시 사유(한국어), 성공 시 null
     */
    public String validate(String id, String password) {
        if (id == null || id.isBlank()) {
            return "아이디를 입력하세요.";
        }
        if (password == null || password.isBlank()) {
            return "비밀번호를 입력하세요.";
        }
        if (password.length() < 8) {
            return "비밀번호는 8자 이상이어야 합니다.";
        }
        if (!password.matches("^[A-Za-z0-9]+$")) {
            return "비밀번호는 영어와 숫자만 사용할 수 있습니다.";
        }
        // 여기서 실제 인증(예: DB 조회)을 하고 싶다면 추가하세요.
        return null; // null이면 성공
    }
}
