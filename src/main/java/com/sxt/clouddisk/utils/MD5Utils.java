package com.sxt.clouddisk.utils;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 对字符串进行MD5加密
 * @author Think
 *
 */
public class MD5Utils {
	/**
	 * 对字符串进行加密
	 * @param str
	 * @return
	 */
	public static String createMD5(String str){
		try {
			MessageDigest messageDigest =MessageDigest.getInstance("MD5");
			//将字符串转换为字节数组
			byte[] oldBytes=  str.getBytes("iso-8859-1");
			//对字节数组进行加密
			byte[] md5Bytes = messageDigest.digest(oldBytes);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				byte b = md5Bytes[i];
				int val = ((int)b)&0xff;//与一个16进制的数值进行与运算
				if(val<10){
					sb.append(0);
				}
				sb.append(Integer.toHexString(val));//转换为16进制
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		String hello="123";
		System.out.println(MD5Utils.createMD5(hello));
	}
}
