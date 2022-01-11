package com.koreait.matjip.model.admin;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.matjip.domain.Admin;
import com.koreait.matjip.exception.AdminException;

@Repository
public class MybatisAdminDAO implements AdminDAO{

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return sessionTemplate.selectList("Admin.selectAll");
	}

	@Override
	public Admin select(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		Admin result = sessionTemplate.selectOne("Admin.selectAll", admin);
		if(result == null) {
			throw new AdminException("愿�由ъ옄 �젙蹂닿� �삱諛붾Ⅴ吏� �븡�뒿�땲�떎");
		}
		return result;
	}

	@Override
	public void insert(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		int  result = sessionTemplate.insert("Admin.insert", admin);
		if(result == 0) {
			throw new AdminException("愿�由ъ옄 �벑濡� �떎�뙣");
		}
		
		
	}

	@Override
	public void update(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		int  result = sessionTemplate.update("Admin.update", admin);
		if(result == 0) {
			throw new AdminException("愿�由ъ옄 �닔�젙 �떎�뙣");
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Admin admin) throws AdminException {
		// TODO Auto-generated method stub
		int  result = sessionTemplate.delete("Admin.delete", admin);
		if(result == 0) {
			throw new AdminException("愿�由ъ옄 �궘�젣 �떎�뙣");
		}
		// TODO Auto-generated method stub
		
	}

	
}
