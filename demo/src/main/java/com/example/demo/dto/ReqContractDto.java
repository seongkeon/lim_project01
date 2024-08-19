package com.example.demo.dto;

import lombok.Data;

@Data
public class ReqContractDto {
	private Integer reqConId; //의뢰계약번호
	private Integer tableId; //회원번호
	private Integer reqId; //의뢰번호 
	private String reqConValid; //계약효력
	private String reqConTime; //계약한 시간
}
