package com.neusoft.srm.service.navigation;

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
import com.neusoft.srm.model.navigation.WebSiteDO;
@RunWith(SpringRunner.class)
@SpringBootTest
public class WebSiteServiceTest {
	@Autowired
	private WebSiteService webSiteService;
	@Test
	public void testGetList() {
		String webSiteName="";
		int pageNo=1;
		int pageSize=10;
	PageInfo<WebSiteDO> page=webSiteService.getList(webSiteName, pageNo, pageSize);
 
	System.out.println(page);
	
	 System.out.println(page.getTotal()+"     "+page.getPages());
}
	@Test
	public void delete(){
		String code="2018052817144857996";
		System.out.println(webSiteService.delete("2018051910181764801",code));
	}

	
}
