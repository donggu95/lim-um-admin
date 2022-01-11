package com.koreait.matjip.model.notice;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.koreait.matjip.domain.Notice;
import com.koreait.matjip.exception.NoticeException;

@Repository
public class MybatisNoticeDAO implements NoticeDAO{
	private SqlSessionTemplate sessionTemplate;
	@Override
	public List selectAll() {
		return sessionTemplate.selectList("Notice.selectAll");
	}

	@Override
	public Notice select(int notice_id) {
		return sessionTemplate.selectOne("Notice.select", notice_id);
	}

	@Override
	public void insert(Notice notice) throws NoticeException{
		int result=sessionTemplate.insert("Notice.insert", notice);
		if(result==0) {
			throw new NoticeException("게시물 등록 실패");
		}
	}

	@Override
	public void update(Notice notice) throws NoticeException{
		int result=sessionTemplate.update("Notice.update", notice);
		if(result==0) {
			throw new NoticeException("게시물 수정 실패");
		}
	}

	@Override
	public void delete(int notice_id) throws NoticeException{
		int result=sessionTemplate.delete("Notice.delete", notice_id);
		if(result==0) {
			throw new NoticeException("게시물 삭제 실패");
		}
	}

}
