package com.green.greenGotell.controller;


import com.green.greenGotell.domain.dto.PasswordResetRequestDto;
import com.green.greenGotell.service.PasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/password-reset")
public class PasswordResetController {

    @Autowired
    private PasswordResetService passwordResetService;

    @PostMapping
    public String resetPassword(@RequestBody PasswordResetRequestDto passwordResetRequestDto) {
        String resetLink = passwordResetService.resetPassword(passwordResetRequestDto.getEmail());
        return "비밀번호 재설정 링크: " + resetLink;
    }
}
