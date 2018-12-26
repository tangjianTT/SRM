package com.neusoft.srm.util;

import java.security.MessageDigest;

/**
 * 部门：上海软件研发中心 
 * 功能：用户密码SHA256加密操作
 * 描述：SHA256工具类 
 * 作成者：汤健 
 * 作成时间：2018-12-10
 */
public class SHA256 {

	/**
	 * 部门：上海软件研发中心 
	 * 功能：实现用户密码SHA256加密操作
	 * 描述：userPwd    用户密码
	 * 返回值：SHA256加密后的密码
	 * 作成者：汤健 
	 * 作成时间：2018-12-10
	 */
	public String pwdEncryption(String userPwd) {
		
		StringBuilder pwd = new StringBuilder();
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-256");
			md.update(userPwd.getBytes("GBK"));
			for (byte b : md.digest()) {
				pwd.append(String.format("%02X", b));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pwd.toString();

	}

}
