package com.neusoft.srm.service.navigation.impl;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.model.navigation.AppSiteDO;
import com.neusoft.srm.service.navigation.AppSiteService;
import com.neusoft.srm.util.AutoProduceCode;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppSiteServiceImplTest {

	@Autowired
	private AppSiteService appSiteService;
	@Test
	public void testGetList() {
		String appSiteName="";
		int pageNo=1;
		int pageSize=10;
	PageInfo<AppSiteDO> page=appSiteService.getList(appSiteName, pageNo, pageSize);
 
	System.out.println(page);
	
	 System.out.println(page.getTotal()+"     "+page.getPages());
	}
	@Test
	public void delete(){
		String code="2018052816455283091,2018052817031341294";
		System.out.println(appSiteService.delete("2018051910181764801",code));
	}

}
