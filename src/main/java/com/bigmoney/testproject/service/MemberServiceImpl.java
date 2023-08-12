package com.bigmoney.testproject.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bigmoney.testproject.dao.MemberServiceDao;
import com.bigmoney.testproject.security.CustomUserDetails;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberServiceDao memberServiceDao;
	
	@Override
	public CustomUserDetails loginID(String m_id) {
		return memberServiceDao.loginID(m_id);
	}
	
	@Override
	public Map<String, Object> getMember(String m_id) {
		return memberServiceDao.getMember(m_id);
	}

	@Override
	public Integer updateMember(Map<String, Object> map) {
		Integer result = memberServiceDao.updateMember(map);
		return result ;
	}

	@Override
	public Map<String, Object> getBuy(String b_id) {
		return memberServiceDao.getBuy(b_id);
	}

	@Override
	public Map<String, Object> getSold(String s_id) {
		return memberServiceDao.getSold(s_id);
	}

	@Override
	public List<Map<String, Object>> getSoldList(int m_number) {
		return memberServiceDao.getSoldList(  m_number);
	}

	@Override
	public List<Map<String, Object>> getBuyList(int m_number) {
		return memberServiceDao.getBuyList( m_number);
	}

	@Override
	public Integer regist(Map<String, Object> map) {
		Integer result = memberServiceDao.regist(map);
		return result ;
	}

	@Override
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}


}