package org.sicau.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tools {
	/*
	 * ��Ŀ������,�ṩMD5����
	 * 
	 * 
	 * */
	
	/**
	 * md5���ܲ���������128λ��bit����mac
	 * ��128bit Macת����16���ƴ���
	 * @param strSrc
	 * @param key
	 * @return
	 */
	public static String MD5Encode(String Strsrc, String key) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			md5.update(Strsrc.getBytes("UTF8"));
			String result = "";
			byte[] temp;
			temp = md5.digest(key.getBytes("UTF8"));
			for (int i = 0; i < temp.length; i++) {
				result += Integer.toHexString(
						(0x000000ff & temp[i]) | 0xffffff00).substring(6);
			}
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
}
