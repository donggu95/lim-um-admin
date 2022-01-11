package com.koreait.matjip.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import lombok.Getter;

//����¡ ó���� ���� ȿ�������� �����ϱ� ����
@Component
@Getter
public class Pager {
	int totalRecord;
	int pageSize=10;
	int totalPage;
	int blockSize=10;
	int currentPage=1;
	int firstPage;
	int lastPage;
	int curPos;
	int num;
	
	public void init(List list, HttpServletRequest request) {
		totalRecord=list.size();
		totalPage = (int)Math.ceil((float)totalRecord/pageSize);
		
		if(request.getParameter("currentPage")!=null) { //������ ��ȣ�� Ŭ���ؼ� ��û�ϴ� �����.. ?currentPage=3 
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		firstPage = currentPage-(currentPage-1)%blockSize;
		lastPage = firstPage+(blockSize-1);
		curPos=(currentPage-1)*pageSize; //�������� ���� Ŀ���� ��ġ(List ������)
		num = totalRecord - curPos; //�������� ���� ��ȣ
	}
	
}