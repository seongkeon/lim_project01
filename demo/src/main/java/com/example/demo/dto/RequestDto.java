package com.example.demo.dto;

import lombok.Data;

@Data
public class RequestDto {
	private Integer reqId;
    private String reqClient;
    private String reqTitle;
    private String reqPay;
    private String reqOrder;
    private String reqContent;
    private String reqAssigned;
    private String reqTime;
}
