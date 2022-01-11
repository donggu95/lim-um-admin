package com.koreait.matjip.exception;

public class ReviewException extends RuntimeException{
	
	public ReviewException(String msg) {
		super(msg);
	}
	public ReviewException(Throwable e) {
		super(e);
	}
	public ReviewException(String msg, Throwable e) {
		super(msg, e);
	}
	
}