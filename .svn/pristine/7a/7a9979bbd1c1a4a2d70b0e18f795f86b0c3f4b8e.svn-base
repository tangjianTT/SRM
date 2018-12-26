package com.neusoft.srm.mapper.dept;

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

import com.neusoft.srm.model.dept.BizTypeDO;

/**
 * 
 * @部门： 软件开发事业部
 * @作者： HaoXin.Liu
 * @开发日期： 2018年12月10日
 * @功能描述： 业务类型Dao层测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BizTypeDOMapperTest {
	private static final Logger log = LoggerFactory.getLogger(BizTypeDOMapperTest.class);
	//业务类型dao层接口
	@Autowired
	private BizTypeDOMapper bizTypeDOMapper;
	@Test
	public void testFindListBizType() {
		List<BizTypeDO> bizTypeDOList = bizTypeDOMapper.findListBizType();
		for (BizTypeDO bizTypeDO : bizTypeDOList) {
			log.info(bizTypeDO.toString());
		}
	}

}
