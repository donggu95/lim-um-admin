package com.koreait.matjip.model.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.matjip.domain.Category;
import com.koreait.matjip.exception.CategoryException;

@Repository
public class MybatisCategoryDAO implements CategoryDAO{
	
	@Autowired
	private SqlSessionTemplate sessionTemlate;
	
	@Override
	public List selectAll() {
		return sessionTemlate.selectList("Category.selectAll");
	}

	@Override
	public Category select(int category_id) {
		return sessionTemlate.selectOne("Category.select", category_id);
	}

	@Override
	public void insert(Category category) throws CategoryException{
		int result=sessionTemlate.insert("Category.insert", category);
		if(result==0) {
			throw new CategoryException("카테고리 등록 실패");
		}
	}
	@Override
	public void updateTeam(int team) throws CategoryException{
		int result = sessionTemlate.update("Category.updateTeam", team);
		if(result==0) {
			throw new CategoryException("team값 업데이트 실패" );
		}
	}
	
	@Override
	public void update(Category category) {
	}

	@Override
	public void delete(int category_id) {
	}

	@Override
	public void updateStep(Category category) {
		sessionTemlate.update("Category.updateStep", category);
	}

	@Override
	public void insertSub(Category category) throws CategoryException{
		int result=sessionTemlate.insert("Category.insertSub", category);
		if(result==0) {
			throw new CategoryException("하위 카테고리 입력 실패");
		}
	}

}
