package com.green.greenGotell.controller;


import com.green.greenGotell.domain.User; // 사용자 엔티티 클래스 경로에 따라 수정 필요
import com.green.greenGotell.domain.dto.AddUserRequest;
import com.green.greenGotell.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserApiController {

    private final UserService userService;

    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public String signup(@ModelAttribute AddUserRequest request) {
        userService.save(request); // 회원 가입 메소드 호출
        return "redirect:/login";// 회원 가입이 완료된 후 로그인 페이지로 이동
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    @GetMapping("/find")
    public String showFindForm() {
        return "find"; // find.html Thymeleaf 템플릿 이름
    }

}