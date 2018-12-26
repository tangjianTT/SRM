package com.neusoft.srm.mapper.dept;

import java.util.Date;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neusoft.srm.model.dept.DeptBizTypeDO;
import com.neusoft.srm.model.dept.DeptDO;

/**
 * 
 * @部门： 软件开发事业部
 * @作者： HaoXin.Liu
 * @开发日期： 2018年12月11日
 * @功能描述：部门业务类mapper
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptBizTypeMapperTest {
	private static final Logger log = LoggerFactory.getLogger(DeptDOMapperTest.class);
	@Autowired
	public DeptBizTypeMapper deptBizTypeMapper;

	/**
	 * 根据部门id删除部门和业务类型关系表
	 */
	@Test
	public void testDeleteBizTypeAndDeptByDeptCode() {
		int type = deptBizTypeMapper.deleteBizTypeAndDeptByDeptCode("2018060117015095508","张三");
	}

	/**
	 * 批量插入部门和业务类型表
	 */
	@Test
	public void testInsertBatchBizTypeAndDept() {
		DeptDO deptDO = new DeptDO("2018060814243090770", "集团总部", "总部", "0", "2018060814243090770", "1", "1", 0,
				"df19d272de640249555167427e4ce95", 1, new Date(), "2018051817264703695", new Date(),
				"2018051817264703695");
		String[] bizTypeAy = { "0", "1" };
		// 插入数据
		int num = deptBizTypeMapper.insertBatchBizTypeAndDept(new DeptBizTypeDO(deptDO), bizTypeAy);
		log.info(num + "");
	}

	/**
	 * 批量更新部门和业务类型表
	 */
	@Test
	public void testUpdateBatchBizTypeAndDept() {
		String[] str = { "0", "1" };
		int num = deptBizTypeMapper.updateBatchBizTypeAndDept("2018060814243090770", str);
		log.info(num + "");
	}

}
