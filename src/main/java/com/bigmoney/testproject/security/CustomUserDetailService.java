package com.bigmoney.testproject.security;

import org.apache.log4j.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bigmoney.testproject.dao.MemberServiceDao;


import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private MemberServiceDao memberServiceDao;
	
	@Override
	public UserDetails loadUserByUsername(String m_id) throws UsernameNotFoundException {
		System.out.println("2踰�) Provide�뿉�꽌 �슂泥��븳 �븿�닔 CustomUserDetailService�뿉�꽌 �떎�뻾�빐�꽌 db�뿉�꽌 id�뿉 留욌뒗 member �젙蹂� 由ы꽩 ");
	
		log.warn("2. Load User By UserName(m_id) : " + m_id);
		
		CustomUserDetails member = memberServiceDao.loginID(m_id);
		if(member==null) {
			throw new UsernameNotFoundException(m_id);
		}
		log.warn("3. queried by member mapper : " + m_id);
		
		return member;
	}

	
}
