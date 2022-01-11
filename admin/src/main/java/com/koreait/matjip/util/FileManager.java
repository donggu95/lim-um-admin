package com.koreait.matjip.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.koreait.matjip.domain.Review;
import com.koreait.matjip.exception.UploadException;

//파일 처리와 관련된 다양한 업무를 처리해주는 전담자 클래스
public class FileManager { 

	
	//파일 저장 (웹으로 전달된...)
	public static String saveAsFile(HttpServletRequest request, Review review) throws UploadException{
		MultipartFile multi=review.getMyFile();
		
		System.out.println("getName() : "+multi.getName());
		System.out.println("getOriginalFilename() : "+multi.getOriginalFilename());
		
		
		ServletContext application=request.getServletContext();
		String saveDir = application.getRealPath("/resources/data");
		System.out.println("saveDir is "+saveDir);
		
		String filename= createFilename(multi.getOriginalFilename());
		
		File file = new File(saveDir+"/"+filename); //full path
		boolean result=false;
		
		try {
			multi.transferTo(file); //물리적 저장!!!  (메모리 --> 하드)
			System.out.println("파일 업로드 완료");
			result=true;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			result=false;
		} catch (IOException e) {
			e.printStackTrace();
			result=false;
		}
		
		if(result==false) {
			throw new UploadException("파일업로드 실패");
		}
		return filename;
	}
	
	
	//확장자 추출
	public static String getExt(String path) {
		int index = path.lastIndexOf(".");
		return path.substring(index+1 , path.length()); 
	}
	
	//파일명 생성 
	public static String createFilename(String path) {
		long time=System.currentTimeMillis(); //파일명
		String ext = getExt(path); //확장자
		return time+"."+ext;
	}
	
}