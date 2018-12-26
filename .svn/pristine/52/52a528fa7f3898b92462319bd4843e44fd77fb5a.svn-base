package com.neusoft.srm.service.index;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class IndexServiceTest {

	@Autowired
	private IndexService indexService;
	@Test
	public void testUpdatePwd() {
		System.out.println(indexService.updatePwd("2018112816233699544", "12345", "123456", "123456"));
	}

	@Test
	public void updateUserMsg()
	{
		System.out.println(indexService.updateUserMsg("2018112816233699544", "1234", "1234@qq.com", "1", "1"));
	}
	
	
	@Test
	public void getUserCodes()
	{
		/*List<String> li=indexService.getUserCodes("11");
		for (String string : li) {
			System.out.println(string);
		}*/
	/*	System.out.println(indexService.getDeptCodeList("2018072517061104266"));*/
		
		List<String> A = new ArrayList<String>();
		A.add("张三");
		A.add("李四");
		A.add("王五");
		A.add("刘大");
		
		List<String>B = new ArrayList<String>();
		B.add("刘大");
		B.add("刘二");
		B.add("刘三");

		
		List<String> C = new ArrayList<String>();
		C.addAll(A);
		C.removeAll(B);
		System.out.println(C);
	}
	

	@Test
	public void getUserCodeList()
	{
        String[] a= indexService.getUserCodeList(indexService.getDeptCodeList("2018072517061104266"));
	   for (String string : a) {
		System.out.println(string);
	}
	}
}
