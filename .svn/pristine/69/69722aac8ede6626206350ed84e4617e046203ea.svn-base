package com.neusoft.srm.mapper.log;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neusoft.srm.mapper.dept.BizTypeDOMapperTest;

/**
 * 
 * @部门： 软件开发事业部
 * @作者： HaoXin.Liu
 * @开发日期： 2018年12月13日
 * @功能描述：记录日志（Mapper）接口测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LogMapperTest {
	private static final Logger log = LoggerFactory.getLogger(BizTypeDOMapperTest.class);
	/**记录日志*/
	@Autowired
	private AccessLogMapper accessLogMapper;
	/**登录日志*/
	@Autowired
	private LoginLogMapper loginLogMapper;
	/**操作日志*/
	@Autowired
	private OperaLogMapper operaLogMapper;

	/**
	 * 按条件查询记录日志
	 */
	@Test
	public void testSelectAccessLogByCond() {
		accessLogMapper.selectAccessLogByCond("孔", "2018-7-6", "2018-9-6");
		accessLogMapper.countAccessLogByCond("孔", "2018-7-6", "2018-9-6");
	}

	/**
	 * 按条件查询登录日志
	 */
	@Test
	public void testSelectLoginLogByCond() {
		loginLogMapper.selectLoginLogByCond("孔", "2018-7-6", "2018-9-6");
		loginLogMapper.countLoginLogByCond("孔", "2018-7-6", "2018-9-6");
	}
	
	/**
	 * 按条件查询操作日志
	 */
	@Test
	public void testSelectOperaLogByCond() {
		operaLogMapper.selectOperaLogByCond("孔", "2018-7-6", "2018-9-6");
		operaLogMapper.countOperaLogByCond("孔", "2018-7-6", "2018-9-6");
	}
}
