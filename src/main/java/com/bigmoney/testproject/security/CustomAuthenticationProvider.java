package com.bigmoney.testproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private UserDetailsService userDetilasService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("1踰�) CustomAuthenticationProvider�뿉 �뱾�뼱���꽌 id, pwd 鍮꾧탳�븿");
		//userName means m_id
		System.out.println(userDetilasService); 
		String username = (String)authentication.getPrincipal();
		String password = (String)authentication.getCredentials();
		System.out.println(username);
		System.out.println(password);
		CustomUserDetails user = (CustomUserDetails)userDetilasService.loadUserByUsername(username);
		
		if(!matchPassword(password, user.getPassword())) {
			System.out.println("1-1) pwd ��由щ㈃ �뜑 吏꾪뻾 �븞�븿");
			throw new BadCredentialsException("鍮꾨�踰덊샇 ��由�");
		}
		
		if(!user.isEnabled()) {
			System.out.println("1-2) 怨꾩젙 鍮꾪솢�꽦�솕 �긽�깭硫� �뜑 吏꾪뻾 �븞�븿");
			throw new BadCredentialsException("怨꾩젙�솢�꽦�솕 �븞�릺�뼱�엳�쓬");
		}
		return new UsernamePasswordAuthenticationToken(username, password,user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
	
	private boolean matchPassword(String loginPwd, String password) {
        return loginPwd.equals(password);
    }

}
