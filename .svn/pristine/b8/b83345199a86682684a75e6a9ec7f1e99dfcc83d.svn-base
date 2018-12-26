package com.neusoft.srm.service.operFlow;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.model.operaflow.OperaDO;
import com.neusoft.srm.model.operaflow.OperaFileDO;
import com.neusoft.srm.service.navigation.AppSiteService;
import com.neusoft.srm.service.operaflow.OperFlowService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OperFlowServiceTest {

	@Autowired
	private OperFlowService operFlowService;
	
	@Test
	public void testGetList() {
		PageInfo<Map<String,Object>> li=operFlowService.getList("", "", "", "", "", 1, 100);
		for (Map<String, Object> map : li.getList()) {
	        	System.out.println(map.values());
		}
	}

	@Test
	public void testDelete(){
		System.out.println(operFlowService.delete("2018103118311335576,2018102913362297245", "1"));
	}
	
	@Test
	public void testSave()
	{
		/*OperaDO operaDo=new OperaDO();
		operaDo.setAuthAuthCode("66666");
		operaDo.setAuthDeptCode("66666");
		operaDo.setAuthDeptTypeCode("6666");
		operaDo.setBizTypeCode("1");
		operaDo.setOnlineFileName("xixi");
		operaDo.setOnlineFileUrl("66666");
		operaDo.setOperaFlowTitle("6666");
	
		OperaFileDO operFile1=new OperaFileDO();
		operFile1.setAttachFileName("777777");
		operFile1.setAttachFileUrl("www.baidu,com");
		
		OperaFileDO operFile2=new OperaFileDO();
		operFile2.setAttachFileName("88888");
		operFile2.setAttachFileUrl("www.baidu,com");
		
		OperaFileDO operFile3=new OperaFileDO();
		operFile3.setAttachFileName("99999");
		operFile3.setAttachFileUrl("www.baidu,com");
		
		List<OperaFileDO> op=new ArrayList<>();
		op.add(operFile1);
		op.add(operFile2);
		op.add(operFile3);
		String userCode="123456";
		System.out.println(operFlowService.save(operaDo, op, userCode, "0", ""));*/
		
		OperaDO operaDo=new OperaDO();
		operaDo.setOperaFlowCode("2018121914040051591");
		operaDo.setBizTypeCode("2");
		operaDo.setOnlineFileName("777");
		operaDo.setOnlineFileUrl("7777");
		operaDo.setOperaFlowTitle("7777");
		
		List<OperaFileDO> op=new ArrayList<>();
		OperaFileDO operFile1=new OperaFileDO();
		operFile1.setAttachFileName("AAAAA");
		operFile1.setAttachFileUrl("www.baidu,com");
		
		OperaFileDO operFile2=new OperaFileDO();
		operFile2.setAttachFileName("BBBBB");
		operFile2.setAttachFileUrl("www.baidu,com");
		
		OperaFileDO operFile3=new OperaFileDO();
		operFile3.setAttachFileName("CCCCC");
		operFile3.setAttachFileUrl("www.baidu,com");
		
		op.add(operFile1);
		op.add(operFile2);
		op.add(operFile3);
		String userCode="123456";
		
		System.out.println(operFlowService.save(operaDo, op, userCode, "0", "ffd22736-0353-11e9-b718-00163e123e47,ffd22a4c-0353-11e9-b718-00163e123e47"));

	}
	
	
}
