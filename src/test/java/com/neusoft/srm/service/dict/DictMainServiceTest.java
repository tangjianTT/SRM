package com.neusoft.srm.service.dict;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neusoft.srm.model.dict.DictMainDO;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月18日
 * @功能描述：字典管理服务接口测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DictMainServiceTest {
	private static final Logger log = LoggerFactory.getLogger(DictMainServiceTest.class);

	@Autowired
	DictMainService dictMainService;
	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：增加或修改主字典测试
	 * @描述：
	 * @返回值：
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	@Test
	public void testAddOrModifyDictMain() {
		/*DictMainDO dictMainDO = new DictMainDO();
		dictMainDO.setLableKey("2345");
		dictMainDO.setLableName("hhhhh");
		dictMainDO.setRemark("这是一个测试数据");
		String userCode = "123";
		Integer index = dictMainService.addOrModifyDictMain(dictMainDO, userCode);
		assertThat(index,is(1));*/
		
		DictMainDO dictMainDO = new DictMainDO();
		dictMainDO.setDictMainCode("2018121815540020188");
		dictMainDO.setLableKey("2345");
		dictMainDO.setLableName("hhhhh");
		dictMainDO.setRemark("这是一个测试数据修改过的数据");
		String userCode = "123";
		Integer index = dictMainService.addOrModifyDictMain(dictMainDO, userCode);
		assertThat(index,is(1));
	}

}
