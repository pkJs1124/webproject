package com.bigmoney.testproject.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bigmoney.testproject.security.CustomAuthenticationProvider;
import com.bigmoney.testproject.security.CustomUserDetails;
import com.bigmoney.testproject.service.MemberService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired 
	CustomAuthenticationProvider customAuthenticationProvider;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("/member/detail")
	public ModelAndView detail(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		Map<String, Object> member =  memberService.getMember(m_id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("isFaile", false);
		mv.addObject("member", member);
		mv.setViewName("/member/detail");
		return mv;		
	}
	@GetMapping("/member/test")
	public String ttt() {
		return "home";
	}
	@PostMapping("/member/update")
	public ModelAndView modify(@RequestParam Map<String, Object> map) {		
		ModelAndView mv = new ModelAndView();
		memberService.updateMember(map);
		mv.setViewName("/home");
		return mv;		
	}
	
	@GetMapping("/member/changePassword")
	public ModelAndView changePassword() {
		return new ModelAndView("/member/changePassword");
	}
	
	@PostMapping("/member/changePassword")
	public ModelAndView changePassword_post(@RequestParam Map<String, Object> map
			, HttpServletRequest request) {
//		//�뿬湲� �닔�젙
//		BCryptPasswordEncoder passwordEncoder = memberService.bCryptPasswordEncoder();
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		Map<String, Object> member =  memberService.getMember(m_id);
		String rawPwd = (String) map.get("m_pwd"); 
		String encodedPwd = (String) member.get("m_pwd");
		System.out.println(rawPwd);
		System.out.println(encodedPwd);
		if( !passwordEncoder.matches(rawPwd , encodedPwd) ) {
			mv.addObject("password", "fail");
			mv.setViewName("/member/changePassword");
			return mv;
		};
		mv.addObject("member", member);
		mv.setViewName("redirect:/");
		return mv;		
	}
	
	@GetMapping("/member/point")
	public ModelAndView review(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		// 湲곕뒫援ы쁽 �쟾�씠�씪 �씪�떒 怨좎젙 媛믪쑝濡� �뀒�뒪�듃 以� : b_id
		String b_id = "1";
		Map<String, Object> member =  memberService.getMember(m_id);
		Map<String, Object> buy =  memberService.getBuy(b_id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("member", member);
		mv.addObject("buy", buy);
		mv.setViewName("/member/point");
		return mv;		
	}
	
	@GetMapping("/member/buyList")
	public ModelAndView buyList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		Map<String, Object> member =  memberService.getMember(m_id);
		int m_number = (int) member.get("m_number");
		List<Map<String, Object>> buyList =  memberService.getBuyList(m_number);
		ModelAndView mv = new ModelAndView();
		mv.addObject("buyList", buyList);
		mv.setViewName("/member/buyList");
		return mv;		
	}
	
	
	@GetMapping("/member/soldList")
	public ModelAndView soldList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		Map<String, Object> member =  memberService.getMember(m_id);
		int m_number = (int) member.get("m_number");
		List<Map<String, Object>> soldList =  memberService.getSoldList(m_number);
		ModelAndView mv = new ModelAndView();
		mv.addObject("isFaile", false);
		mv.addObject("soldList", soldList);
		mv.setViewName("/member/soldList");
		return mv;		
	}
	
	@GetMapping("/member/review")
	public ModelAndView getReviewList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String m_id =  (String) session.getAttribute("m_id");
		Map<String, Object> member =  memberService.getMember(m_id);
		int m_number = (int) member.get("m_number");
		List<Map<String, Object>> soldList =  memberService.getSoldList(m_number);
		int sum = 0 ;
		for (Map<String, Object> sold : soldList) {
			sum += (int) sold.get("s_score");
		}
		int avgScore = (int) Math.ceil(sum/ soldList.size()) ;
		ModelAndView mv = new ModelAndView();
		mv.addObject("soldList", soldList);
		mv.addObject("avgScore", avgScore);
		mv.setViewName("/member/review");
		return mv;		
	}
	
	@GetMapping("/member/login")
	public ModelAndView login() {
		return new ModelAndView("member/login");
	}
	
	@GetMapping("/member/loginFail")
	public ModelAndView loginFail() { 
		// �굹以묒뿉 ajax濡� 諛붽� �삁�젙 
		ModelAndView mv = new ModelAndView();
		mv.addObject("login", "fail");
		mv.setViewName("/member/login");
		return mv;
	}
	
	// /member/loginSuccess�뒗 CustomLoginSuccessHandler�뿉�꽌 �씠�룞�븿
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		session.invalidate();
		mv.setViewName("redirect:/"); // �솢 �솃�솕硫댁씠 �븘�땲�씪 濡쒓렇�씤李쎌쑝濡� �뿰寃곕릺吏�?
		return mv;
	}
	
	@GetMapping("/member/regist")
	public ModelAndView regist() {
		return new ModelAndView("member/regist");
	}
	
	@PostMapping("/member/regist")
	public ModelAndView regist_post(@RequestParam Map<String, Object> map) {
		System.out.println("媛��엯�븯湲� POST");
		ModelAndView mv = new ModelAndView();
		String pwd1 = (String) map.get("m_pwd");
//		// �뿬湲� �닔�젙
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		passwordEncoder = memberService.encodePasswordService(passwordEncoder);
		String pwd2 = passwordEncoder.encode(pwd1);
		map.put("m_pwd", pwd2);
		memberService.regist(map);
		System.out.println(map.toString());
		mv.setViewName("/member/login");
		return mv;		
	}
	
	
	
	
}