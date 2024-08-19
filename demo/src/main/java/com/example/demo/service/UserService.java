package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;

import jakarta.servlet.http.HttpSession;

@Service
public class UserService {

	private ModelAndView mv;

	@Autowired
	private UserDao uDao;

	// 비밀번호 암호화를 위한 인코더 객체
	private BCryptPasswordEncoder pEncoder = new BCryptPasswordEncoder();

	public String insertUser(UserDto user, RedirectAttributes rttr) {
		String view = null;
		String msg = null;

		// 비밀번호 암호화 처리
		String encpwd = pEncoder.encode(user.getUserPw());
		System.out.println("####encpwd: " + encpwd);
		// 평문인 비밀번호를 암호문으로 덮어씀.
		user.setUserPw(encpwd);

		try {
			System.out.println("@@@@insertUser()");
			uDao.insertUser(user);
			view = "redirect:/login";
			msg = "가입 성공";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "가입 실패";
		}
		rttr.addFlashAttribute("msg", msg);
		return view;
	}

	public String loginProc(UserDto user, HttpSession session, RedirectAttributes rttr) {
		String view = null;
		String msg = null;
		
		//DB에서 회원의 비밀번호 구하기(암호문)
        String encPwd = uDao.selectPass(user.getUserId());
        System.out.println("loginproc-encpwd: " + encPwd);
        if(encPwd != null){
        	if(pEncoder.matches(user.getUserPw(), encPwd)){
        		user = uDao.selectUser(user.getUserId());
        		System.out.println("loginproc-user: " + user);
        		//세션에 dto 저장.
        		session.setAttribute("user", user);
        		session.setAttribute("tableId", user.getTableId());
        		view = "redirect:/main";
        		msg = "로그인 성공";
        	}
    		else {
        		System.out.println("비번틀림");
        		view = "redirect:/login";
        		msg = "비밀번호가 틀립니다.";
        	}
        	
        }else {
        	System.out.println("아이디없음");
        	view = "redirect:/login";
        	msg = "아이디가 존재하지 않습니다.";
        }
		
        rttr.addFlashAttribute("msg", msg);
        
		return view;
	}

	public ModelAndView getMyInfo(String tableId) {
		System.out.println("@@@@getMyInfo()");
		System.out.println("//" + tableId);
		mv = new ModelAndView();

		UserDto myinfo = uDao.getMyInfo(tableId);

		mv.addObject("myinfo", myinfo);

		mv.setViewName("myInfo");

		return mv;
	}

}
