package com.koreait.matjip.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.matjip.domain.Notice;
import com.koreait.matjip.exception.NoticeException;
import com.koreait.matjip.model.notice.NoticeService;
import com.koreait.matjip.util.Message;

@Controller
public class RestNoticeController {

	@Autowired
	private NoticeService noticeService; 
	
	@GetMapping("/rest/notice")
	@ResponseBody
	public List getList(HttpServletRequest request) {
		//�Խù� ���
		List<Notice> noticeList=noticeService.selectAll();
		
		return noticeList; //   
	}
	
	//�Ѱ��� ������ rest ��û ó��   /admin     /rest/notice/1
	@RequestMapping(value="/rest/notice/{notice_id}", method=RequestMethod.GET)
	@ResponseBody
	public Notice getDetail(@PathVariable(name = "notice_id") int  notice_id) {
		Notice notice = noticeService.select(notice_id);
		return notice;
	}
	
	//��� ��ûó��
	@RequestMapping(value="/rest/notice", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Message> insert(Notice notice) {
		noticeService.insert(notice);
		
		Message message=new Message();
		message.setMsg("��ϼ���");
		message.setCode(1);
		
		ResponseEntity<Message> entity=new ResponseEntity<Message>(message , HttpStatus.OK); //200
		return entity;
	}
	
	//�Ѱ� ���� ��ûó�� 
	@RequestMapping(value="/rest/notice", method=RequestMethod.PUT)
	public ResponseEntity<Message> update(Notice notice){
		noticeService.update(notice);
		
		Message message=new Message();
		message.setMsg("��������");
		message.setCode(1);
		
		ResponseEntity<Message> entity=new ResponseEntity<Message>(message , HttpStatus.OK); //200
		return entity;
	}
	
	//�Ѱ� ���� ��û 
	@RequestMapping(value="/rest/notice/{notice_id}", method=RequestMethod.DELETE)
	public ResponseEntity<Message> delete(@PathVariable(name = "notice_id") int notice_id){
		noticeService.delete(notice_id);
		Message message=new Message();
		message.setMsg("��������");
		message.setCode(1);
		ResponseEntity<Message> entity=new ResponseEntity<Message>(message , HttpStatus.OK); //200
		return entity;
	}
	
	@ExceptionHandler(NoticeException.class)
	public ResponseEntity<Message> handle(NoticeException e) {
		Message message=new Message();
		message.setMsg(e.getMessage());
		message.setCode(0);
		
		ResponseEntity<Message> entity=new ResponseEntity<Message>(message , HttpStatus.OK); //200
		
		return entity;
	}
}