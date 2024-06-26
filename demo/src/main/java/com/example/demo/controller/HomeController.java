package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.RequestDto;
import com.example.demo.service.HomeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	@Autowired
	private HomeService hServ;
	
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
	
	@RequestMapping("/main/requestWrite")
	public String requestWrite(@RequestPart List<MultipartFile> files,
							   RequestDto request, HttpSession session,
							   RedirectAttributes rttr) {
		System.out.println("@@@@requestWrite");
		String view = hServ.requestWrite_hServ(files, request, session, rttr);
		return 
	}
}
