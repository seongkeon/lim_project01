package com.example.demo.service;

import java.io.File;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dao.HomeDao;
import com.example.demo.dto.RequestDto;

import jakarta.servlet.http.HttpSession;

@Service
public class HomeService {
	@Autowired
    private HomeDao hDao;
	
	public String requestWrite_hServ(List<MultipartFile> files, RequestDto request, HttpSession session,
			RedirectAttributes rttr) {
		System.out.println("@@@@@requestWrite_hServ()");
		String view = null;
        String msg = null;
        
        try {
        	//글 내용 저장.
        	hDao.insertRequest(request);
        	
        	//파일 업로드 처리
        	FileUpload(files, session, request);
        	
        	
        }catch (Exception e) {
		
		}
		return view;
	}
	
	private void fileUpload(List<MultipartFile> files, HttpSession session,
							RequestDto request) {
		System.out.println("@@@@@fileUpload()");
		//파일 저장 위치
		String realPath = session.getServletContext().getContextPath("/");
		realPath += "upload/"; //업로드용 폴더 : upload
		File folder = new File(realPath);
		
		if(folder.isDirectory() == false) {
			folder.mkdir();//폴더 생성.
		}
		
	}

}
