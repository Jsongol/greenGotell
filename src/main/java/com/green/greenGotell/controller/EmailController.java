package com.green.greenGotell.controller;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @GetMapping("/email")
    public String showEmailForm() {
        return "email-form"; // Thymeleaf 템플릿 이름
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam("recipient") String recipient,
                            @RequestParam("subject") String subject,
                            @RequestParam("content") String content,
                            Model model) {

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("your_email@naver.com"); // 발신자 이메일
            helper.setTo(recipient); // 수신자 이메일
            helper.setSubject(subject); // 이메일 제목
            helper.setText(content, true); // 이메일 내용 (HTML 가능)

            mailSender.send(message);

            model.addAttribute("message", "이메일이 성공적으로 전송되었습니다.");
        } catch (MessagingException e) {
            e.printStackTrace();
            model.addAttribute("error", "이메일 전송 중 오류가 발생했습니다.");
        }

        return "result"; // 이메일 전송 결과 페이지 (resources/templates/result.html)
    }
}
