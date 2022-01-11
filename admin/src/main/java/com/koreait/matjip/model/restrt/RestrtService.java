package com.koreait.matjip.model.restrt;

import java.util.List;

import com.koreait.matjip.domain.Restrt;

// 상점을 관리하는 서비스
public interface RestrtService {
	
	public List selectAll();
	public Restrt select(int restrt_id); //한건 가져오기
	public void regist(Restrt restrt);
	public void update(Restrt restrt);
	public void delete(int restrt_id);
}
