package com.koreait.matjip.model.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.matjip.domain.Notice;
import com.koreait.matjip.exception.NoticeException;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Override
	public List selectAll() {
		return noticeDAO.selectAll();
	}

	@Override
	public Notice select(int notice_id) throws NoticeException{
		return noticeDAO.select(notice_id);
	}

	@Override
	public void insert(Notice notice) throws NoticeException{
		noticeDAO.insert(notice);
	}

	@Override
	public void update(Notice notice) throws NoticeException{
		noticeDAO.update(notice);
	}

	@Override
	public void delete(int notice_id) throws NoticeException{
		noticeDAO.delete(notice_id);
	}

}
