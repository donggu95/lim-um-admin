package com.koreait.matjip.exception;

public class RestrtException extends RuntimeException{
	
	public RestrtException(String msg) {
		super(msg);
	}
	public RestrtException(Throwable e) {
		super(e);
	}
	public RestrtException(String msg, Throwable e) {
		super(msg, e);
	}

}