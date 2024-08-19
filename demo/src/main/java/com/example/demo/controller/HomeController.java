package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.ReqContractDto;
import com.example.demo.dto.RequestDto;
import com.example.demo.dto.RfileDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.HomeService;
import com.example.demo.service.UserService;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@Autowired
	private HomeService hServ;
	
	@Autowired
	private UserService uServ;
	
	@Autowired
	private UserDao uDao;
	
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
	
	@GetMapping("download")
	public ResponseEntity<InputStreamResource> fileDownload(RfileDto rfile,
												 HttpSession session)
	       throws IOException{
		log.info("fileDownload()");
		ResponseEntity<InputStreamResource> resp =
				hServ.fileDownload(rfile,session);
		return resp;
	}
	
	/*마이페이지*/
	@RequestMapping("/main/myInfo")
	public ModelAndView myInfo(@RequestParam("tableId") String tableId, UserDto uDto) {
		System.out.println("@@@@@myInfo");
		System.out.println("//" + tableId);
		
		
		System.out.println("///" + uDto.getTableId());
		mv = uServ.getMyInfo(tableId);
		
		return mv;
	}
	
	/*수락버튼*/
	@RequestMapping("/main/requestList/requestAccept")
	public String requestAccept(@RequestParam(value = "reqId") Integer reqId, 
								ReqContractDto rConDto,HttpSession session,
								RedirectAttributes rttr) {
		System.out.println("@@@@requestAccept() - " + reqId);
		
		String view = hServ.insertReqContract(reqId,rConDto,session,rttr);
		
		return view;		
	}
	
}

