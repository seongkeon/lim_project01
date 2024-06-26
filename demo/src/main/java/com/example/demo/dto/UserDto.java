package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto {
	private Integer tableId;
    private String description;
    private String userId;
    private String userPw;
    private String userAge;
    private String userGender;
    private String userMail;
    private String userName;
}
