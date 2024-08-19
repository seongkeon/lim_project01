package com.example.demo.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
//import java.net.http.HttpHeaders;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.CacheControl;
import org.springframework.http.ContentDisposition;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.HomeDao;
import com.example.demo.dto.ReqContractDto;
import com.example.demo.dto.RequestDto;
import com.example.demo.dto.RfileDto;
import com.example.demo.dto.UserDto;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;


@Service
@Slf4j
public class HomeService {
	@Autowired
    private HomeDao hDao;
	
	private ModelAndView mv;
	
	public String requestWrite_hServ(List<MultipartFile> files, RequestDto request, HttpSession session,
			RedirectAttributes rttr) {
		System.out.println("####requestWrite_hServ()");
		String view = null;
        String msg = null;
       
        Date date = new Date();
        SimpleDateFormat format01 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
        String today_format01 = format01.format(date);
        
        System.out.println("####"+today_format01);
        
        try {
        	request.setReqTime(today_format01);
        	//글 내용 저장.        	
        	hDao.insertRequest(request);
        	
        	//파일 업로드 처리
        	fileUpload(files, session, request);
        	
        	
        	view = "redirect:/main";
        	
        	msg = "글 작성 성공";
        }catch (Exception e) {
        	e.printStackTrace();
            view = "redirect:/requestForm";
            msg = "글 작성 실패";
		}
        rttr.addFlashAttribute("msg", msg);
		return view;
	}
	
	private void fileUpload(List<MultipartFile> files, HttpSession session,
							RequestDto request) throws Exception{
		Date date = new Date();
        SimpleDateFormat format02 = new SimpleDateFormat("yyyy-MM-dd"); 
        String today_format02 = format02.format(date);
        System.out.println("####fileUpload()");
		
		
		//파일 저장 위치
		String realPath = session.getServletContext().getRealPath("/");
		realPath += "upload/"; //업로드용 폴더 : upload
		File folder = new File(realPath);
		
		if(folder.isDirectory() == false) {
			folder.mkdir();//폴더 생성.
		}
		
		//파일 저장 처리(목록이므로 반복 처리)
		for(MultipartFile mf : files) {
			//파일명(원래 이름) 추출.
			String orname = mf.getOriginalFilename();
			if(orname.equals("")) {
				return;
			}
			
			//파일 정보 저장.
			RfileDto rf = new RfileDto();
			rf.setRf_reqId(request.getReqId());
			rf.setRf_oriname(orname);
			String sysname = today_format02 + "_" + orname;
			rf.setRf_sysname(sysname);
			
			//파일 저장.
			File file = new File(realPath + sysname);
			mf.transferTo(file);
			
			//파일 정보 저장.(DB)
			hDao.insertFile(rf);
		}
	}

	public ModelAndView getRequestList(RequestDto rDto, HttpSession session) {
		System.out.println("####getRequestList");
		log.info("getRequestList()");
	    mv = new ModelAndView();
	    
	    List<RequestDto> rList = hDao.selectRequestList(rDto);
	    
	    mv.addObject("rList", rList);
	    
	    mv.setViewName("requestList");
	    
		return mv;
	}

	public ModelAndView getRequestDetail(Integer num) {
		System.out.println("####getRequestDetail()");
		mv = new ModelAndView();
		System.out.println("num: "+num);
		RequestDto request = hDao.selectRequest(num);
		
		List<RfileDto> fList = hDao.selectFile(num);
		
		mv.addObject("req",request);
		mv.addObject("fList",fList);
		
		mv.setViewName("requestDetail");
		
		return mv;
	}

	public ResponseEntity<InputStreamResource> fileDownload(RfileDto rfile, 
												 HttpSession session)
		throws IOException{
		System.out.println("####fileDownload");
		log.info("fileDownload()");
		
		//파일 저장 경로
		String realpath = session.getServletContext().getRealPath("/");
		realpath += "upload/" + rfile.getRf_sysname();
		
		//실제 파일이 저장된 하드디스크까지 경로를 수립
		InputStreamResource fResource = 
				new InputStreamResource(new FileInputStream(realpath));
		
		//파일명이 한글인 경우의 처리(UTF-8로 인코딩)
		String fileName = URLEncoder.encode(rfile.getRf_oriname(),"UTF-8");
		
		return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .cacheControl(CacheControl.noCache())
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=" + fileName)
                .body(fResource);
	}

	public String insertReqContract(Integer reqId,ReqContractDto rConDto,HttpSession session,RedirectAttributes rttr) {
		System.out.println("####insertReqContract() - " + reqId);
		String view = null;
		String msg = null;
		
		UserDto user = (UserDto)session.getAttribute("user");
       
        Date date = new Date();
        SimpleDateFormat format01 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
        String today_format01 = format01.format(date);        
    
//        int num_tableId = Integer.parseInt(tableId);
//        int num_reqId = Integer.parseInt(reqId);
//        System.out.println("num_tableId = " + num_tableId);
//        System.out.println("num_reqId = " + num_reqId);
        
        try {
        	rConDto.setTableId(user.getTableId());
        	rConDto.setReqId(reqId);
        	rConDto.setReqConValid("true");
        	rConDto.setReqConTime(today_format01);
        	System.out.println("#####" + rConDto.getTableId());
        	System.out.println("#####" + rConDto.getReqId());
        	
        	hDao.insertReqContract(rConDto);
        	view = "redirect:/main/requestList";
        	msg = "계약 성공";
		} catch (Exception e) {
			e.printStackTrace();
            view = "redirect:/main/requestList";
            msg = "계약 실패";
		}
        rttr.addFlashAttribute("msg", msg);
        System.out.println(msg);
		return view;
	}

}
