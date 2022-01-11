package com.koreait.matjip.domain;

import lombok.Data;

@Data
public class Notice {
	private int notice_id;
	private String notice_title;
	private String notice_content;
	private String notice_regdate;
}
