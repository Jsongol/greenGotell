package com.green.greenGotell.security;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        
        PrintWriter out = response.getWriter();
        out.println("<script>alert('접근 권한이 없습니다.'); location.href='/';</script>");
        out.flush();
		
	}

}
