package com.bigmoney.testproject.security;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private long m_number;
	private String m_id;
	private String m_pwd;
	private String m_name;
	private String m_phone;
	private String m_email;
	private Timestamp m_regdate;
	private String m_auth;
	private boolean ENABLED;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(m_auth));
		return auth;
	}

	public long getM_number() {
		return m_number;
	}

	public String getM_id() {
		return m_id;
	}

	public String getM_pwd() {
		return m_pwd;
	}

	public String getM_name() {
		return m_name;
	}

	public String getM_phone() {
		return m_phone;
	}

	public String getM_email() {
		return m_email;
	}

	public Timestamp getM_regdate() {
		return m_regdate;
	}

	public String getM_auth() {
		return m_auth;
	}

	public boolean isENABLED() {
		return ENABLED;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return m_pwd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return m_id;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Long getMemberNumber() {
		return m_number;
	}

}
