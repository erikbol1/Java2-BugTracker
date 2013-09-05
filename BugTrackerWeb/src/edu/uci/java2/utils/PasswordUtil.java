package edu.uci.java2.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordUtil {
	
	private static MessageDigest messageDigest;//Expensive construction, instance will be cached and reused.
	public static final int PASSWORDMINIMALLENGHT = 4;
	
	public static String getHash(char[] password){
		String passwordHash = null;
		if(messageDigest==null){
			try {
				messageDigest = MessageDigest.getInstance("SHA");				
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		messageDigest.reset();
		try {
			messageDigest.update(new String(password).getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] bytes = messageDigest.digest();
		StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<bytes.length;i++) {
    	  hexString.append(Integer.toHexString(0xFF & bytes[i]));
    	}
    	passwordHash = hexString.toString().toUpperCase();
		return passwordHash;
	}
	
	public static boolean passWordValidation(char[] passWord){
		//The only rule that we will implement is for the password is long enough
		return passWord.length >= PASSWORDMINIMALLENGHT;
	}
}
