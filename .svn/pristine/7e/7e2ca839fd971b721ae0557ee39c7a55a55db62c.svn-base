package com.neusoft.srm.service;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.neusoft.srm.model.navigation.AppSiteDO;
import com.neusoft.srm.service.login.LoginService;
import com.neusoft.srm.service.navigation.AppSiteService;
import com.neusoft.srm.util.SHA256;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {
	@Autowired public LoginService loginService;
	
	@Autowired
	private AppSiteService appSiteService;
	
	@Test
	public void testCheckLogin() throws NoSuchAlgorithmException, UnsupportedEncodingException {
	/*	System.out.println(loginService.checkLogin("tangjian", "12345","123","123"));
		
		
		String userPwdSHA256=new SHA256().pwdEncryption("123456");
		System.out.println(userPwdSHA256);*/
		/*List<Map<String,Object>>list=loginService.getUserDept("2018052023245986258");
        for (Map<String, Object> map : list) {
			System.out.println(map.values());
		}*/
		
        List<Map<String,Object>> li=loginService.getUserMsg("2018052023245986258");
        for (Map<String, Object> map : li) {
        	System.out.println(map.values());
		}
/*		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(t.getBytes("GBK"));
	    StringBuilder psw=new StringBuilder();
		for(byte b:md.digest())
		{
		System.out.format("%02X",b);
		System.out.println(String.format("%02X", b));
		psw.append(String.format("%02X", b));
		}
		
		System.out.println(md.digest().toString());*/
		/*System.out.println(new SHA256().pwdEncryption("123456"));*/
	
	} 
	
	@Test
	public void getUserMenus(){
		List<Map<String,Object>> map=loginService.getUserMenus("2018051512082612395", "2018051512021710566");
		for (Map<String, Object> map2 : map) {
			System.out.println("  "+map2+":"+map2.values());
		}
	}
	@Test
	public void getUserButtons(){
		List<Map<String,Object>> map=loginService.getUserButtons("2018051512052795871");
		for (Map<String, Object> map2 : map) {
			System.out.println("  "+map2+":"+map2.values());
		}
	}
}
