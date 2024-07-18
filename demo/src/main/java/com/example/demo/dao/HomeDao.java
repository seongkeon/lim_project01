package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.RequestDto;
import com.example.demo.dto.RfileDto;

@Mapper
public interface HomeDao {
	//파일 저장
	void insertFile(RfileDto rf);
	//의뢰 글 작성
	void insertRequest(RequestDto request);
	//의뢰 리스트 가져오는 메소드
	List<RequestDto> selectRequestList(RequestDto rDto);
	//의뢰 게시글 1개 가져오는 메소드 선언
	RequestDto selectRequest(Integer num);
	//파일 목록 가져오는 메소드 선언
	List<RfileDto> selectFile(Integer num);

}
