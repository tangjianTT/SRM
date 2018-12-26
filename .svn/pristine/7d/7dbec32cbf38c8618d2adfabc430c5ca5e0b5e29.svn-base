package com.neusoft.srm.mapper.dict;

import java.util.List;

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
 * @作者： HaoXin.Liu
 * @开发日期： 2018年12月17日
 * @功能描述： 主字典mapper接口
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DictMainDOMapperTest {
	private static final Logger log = LoggerFactory.getLogger(DictMainDOMapperTest.class);
	
	@Autowired
	DictMainDOMapper dictMainDOMapper;
	
	@Test
	public void testFindAllMainDictByCond() {
		List<DictMainDO> dictMainList = dictMainDOMapper.findAllMainDictByCond(null, null);
		for (DictMainDO dictMainDO : dictMainList) {
			
		}
	}
	
	
	@Test
	public void testDelBatchDictMainByDictMainCodeAy() {
		//批量删除主字典
		String[] dictMainCodeAy = new String[] {"2018062715414293319"};
		int num = dictMainDOMapper.delBatchDictMainByDictMainCodeAy(dictMainCodeAy, "1234");
		log.info(num+"");
	}
}
