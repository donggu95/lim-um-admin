package com.koreait.matjip.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Review {
	
	private int review_id;
	private int restrt_id;
	private int member_id;
	private String review_title;
	private String review_content;
	private String review_regdate;
	private String filename;
	
	private MultipartFile myFile;

}