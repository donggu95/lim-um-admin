package com.koreait.matjip.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashBuilder {

	public String convertStringToHash(String pass) {
		//알고리즘 선택
		StringBuffer sb = new StringBuffer();
		
		try {
			MessageDigest digest=MessageDigest.getInstance("SHA-256");
			byte[] hash=digest.digest(pass.getBytes());
		
			for(int i=0; i<hash.length; i++) {
				String hex=Integer.toHexString(0xff&hash[i]);
				if(hex.length()==1) {
					sb.append("0");
				}
				sb.append(hex);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}

}
