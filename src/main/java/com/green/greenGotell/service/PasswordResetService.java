package com.green.greenGotell.service;

import com.green.greenGotell.domain.User;
import com.green.greenGotell.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PasswordResetService {

    @Autowired
    private UserRepository userRepository;

    public String resetPassword(String email) {
        // 이메일로 사용자 찾기
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 이메일로 등록된 사용자가 없습니다."));

        // 비밀번호 재설정 토큰 생성
        String token = generateResetToken();

        // 사용자에게 토큰 저장
        user.setResetToken(token);
        userRepository.save(user);

        // 비밀번호 재설정 링크 생성
        String resetUrl = "http://localhost:8080/password-reset/confirm?token=" + token;

        return resetUrl;
    }

    private String generateResetToken() {
        // 토큰 생성 로직 (UUID 등 사용)
        return UUID.randomUUID().toString();
    }
}
