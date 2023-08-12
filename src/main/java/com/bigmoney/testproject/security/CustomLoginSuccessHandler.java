package com.bigmoney.testproject.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Category;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.warn("Login success");
		System.out.println("3踰�) �꽦怨듯븯硫� CustomLoginSuccessHandler濡� 媛�");

		List<String> roleNames = new ArrayList<>();

		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());

		});

		log.warn("ROLE NAMES : " + roleNames);

		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/");
			return;
		}
		if (roleNames.contains("ROLE_MEMBER")) {
			HttpSession session = request.getSession();
			// getName�씠 �궗�떎 m_id 媛��졇�삤�뒗 嫄곕씪 m_name媛��졇�삤寃� 諛붽퓭�빞�븿
			session.setAttribute("m_id", authentication.getName());
			response.sendRedirect("/");
			return;
		}
//		if (roleNames.contains("ROLE_USER")) {
//			response.sendRedirect("/");
//			return;
//
//		}

		response.sendRedirect("/");
		System.out.println("�씠嫄� 臾댁뒯 寃쎌슦吏�?");
	}

}
