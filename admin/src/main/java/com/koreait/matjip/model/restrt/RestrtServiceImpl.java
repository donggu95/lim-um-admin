package com.koreait.matjip.model.restrt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.matjip.domain.Restrt;
import com.koreait.matjip.exception.RestrtException;

@Service
public class RestrtServiceImpl implements RestrtService{
	@Autowired
	private RestrtDAO restrtDAO;

	@Override
	public List selectAll() {
		return restrtDAO.selectAll();
	}

	@Override
	public Restrt select(int restrt_id) {
		return restrtDAO.select(restrt_id);
	}

	//적어도 맛집 등록이란
	@Override
	public void regist(Restrt restrt) throws RestrtException{
		restrtDAO.insert(restrt); //restrt에 대한 테이블 인서트 맛집 정보
	}

	@Override
	public void update(Restrt restrt) throws RestrtException{
		restrtDAO.update(restrt);
	}

	@Override
	public void delete(int restrt_id) throws RestrtException{
		restrtDAO.delete(restrt_id);
	}

}
