package edu.uci.java2.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordUtil {
	
	private static MessageDigest messageDigest;
	
	public static String getHash(char[] password){
		String passwordHash = null;
		if(messageDigest==null){
			try {
				messageDigest = MessageDigest.getInstance("SHA");
				messageDigest.update(new String(password).getBytes("UTF-8"));
				byte[] bytes = messageDigest.digest();
				StringBuffer hexString = new StringBuffer();
		    	for (int i=0;i<bytes.length;i++) {
		    	  hexString.append(Integer.toHexString(0xFF & bytes[i]));
		    	}
		    	passwordHash = hexString.toString();
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return passwordHash;
	}

}
