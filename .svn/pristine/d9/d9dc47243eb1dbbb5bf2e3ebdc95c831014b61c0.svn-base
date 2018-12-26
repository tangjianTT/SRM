package com.neusoft.srm.mapper.dict;

import static org.junit.Assert.*;

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

import com.neusoft.srm.model.dict.DictSubDO;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月18日
 * @功能描述：子字典Mapper接口测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DictSubDOMapperTest {
	private static final Logger log = LoggerFactory.getLogger(DictSubDOMapperTest.class);

	@Autowired
	DictSubDOMapper dictSubDOMapper;

	@Test
	public void testDelBatchDictSubByDictMainCodeAy() {
		String[] dictMainCodeAy = new String[] { "2018071015590959766" };
		int num = dictSubDOMapper.delBatchDictSubByDictMainCodeAy(dictMainCodeAy, "1234");
		log.info(num + "");
	}

	@Test
	public void testSubDictListByDictSubCode() {
		List<DictSubDO> dictSubList = dictSubDOMapper.selectSubDictListByDictMainCode("2018071015590959766");
		for (DictSubDO dictSubDO : dictSubList) {
			log.info(dictSubDO.toString());
		}
	}

}
