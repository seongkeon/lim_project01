package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserDto;

@Mapper
public interface UserDao {
	//회원 가입 메소드
	void insertUser(UserDto user);
	//회원의 비밀번호 검색 메소드
	String selectPass(String userId);
	//회원 정보를 가져오는 메소드
	UserDto selectUser(String userId);

}
