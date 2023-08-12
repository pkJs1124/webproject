package com.bigmoney.testproject.service;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bigmoney.testproject.security.CustomUserDetails;

public interface MemberService {
	BCryptPasswordEncoder bCryptPasswordEncoder();
	
	CustomUserDetails loginID(String m_id);

	Map<String, Object> getMember(String m_id);

	Integer updateMember(Map<String, Object> map);

	Map<String, Object> getBuy(String b_id);

	Map<String, Object> getSold(String s_id);

	List<Map<String, Object>> getSoldList( int m_number);

	List<Map<String, Object>> getBuyList(  int m_number);

	Integer regist(Map<String, Object> map);
}