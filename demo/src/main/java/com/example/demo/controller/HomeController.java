package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.RequestDto;
import com.example.demo.service.HomeService;

import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@Autowired
	private HomeService hServ;
	
	private ModelAndView mv;
	
	@RequestMapping("/main")
	public String gomain() {
		System.out.println("@@@gomain()");
		return "main";
	}
	
	@GetMapping("/main/requestForm")
	public String requestForm() {
		System.out.println("@@@requestForm()");
		return "requestForm";
	}
	
	@PostMapping("/main/requestWrite")
	public String requestWrite(@RequestPart(required = false) List<MultipartFile> files,
							   RequestDto request, HttpSession session,
							   RedirectAttributes rttr) {
		System.out.println("@@@@requestWrite");
		String view = hServ.requestWrite_hServ(files, request, session, rttr);
		return view;
	}
	
	@GetMapping("/main/requestList")
	public ModelAndView requestList(RequestDto rDto, HttpSession session) {
		System.out.println("@@@requestList()");
		log.info("requestList()");
		mv = hServ.getRequestList(rDto,session);
		return mv;		
	}
	
	@RequestMapping("/main/requestList/requestDetail")
	public ModelAndView requestDetail(RequestDto rDto) {
		System.out.println("@@@@@requestDetail()");
		System.out.println(rDto.getReqId());
		mv = hServ.getRequestDetail(rDto.getReqId());
		return mv;
	}
	
	 
}
