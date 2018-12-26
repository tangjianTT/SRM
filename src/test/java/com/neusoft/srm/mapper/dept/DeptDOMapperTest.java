package com.neusoft.srm.mapper.dept;

import java.util.Date;
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

import com.neusoft.srm.model.dept.DeptDO;

/**
 * 
 * @部门： 软件开发事业部
 * @作者： HaoXin.Liu
 * @开发日期： 2018年12月7日
 * @功能描述：部门类DAO层(CRUD)操作测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptDOMapperTest {
	private static final Logger log = LoggerFactory.getLogger(DeptDOMapperTest.class);
	@Autowired
	public DeptDOMapper deptMapper;

	/**
	 * 测试数据库状态连接
	 */
	@Test
	public void testConnection() {
		// SQL数据库引擎
		String JDriver = "com.mysql.jdbc.Driver";
		// 数据源
		String connectDB = "jdbc:mysql://10.138.10.25:5722/srm";
		try {
			// 加载数据库引擎，返回给定字符串名的类
			Class.forName(JDriver);
			log.info("数据库驱动成功");
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			log.error("加载数据库引擎失败");
			System.exit(0);
		}
	}

	/**
	 * 测试查询所有部门
	 */
	@Test
	public void tesFindListDept() {
		List<DeptDO> deptDOList = deptMapper.findListDept();
		/*for (DeptDO deptDO : deptDOList) {
			log.info("======一级======="+deptDO.toString()+"====="+deptDO.getDeptDOList().size());
			int i =0;
			List<DeptDO> deptDOChildList = deptDO.getDeptDOList();
			for (DeptDO deptDO2 : deptDOChildList) {
				log.info("=========="+(i++)+"级======="+deptDO2.toString());
			}
		}*/
	}

	/**
	 * 插入一个部门信息
	 */
	@Test
	public void tesInsertDept() {
		DeptDO deptDO = new DeptDO("123", "DEPT_NAME", "DEPT_NAME_J", "PARENT_DEPT_CODE", "AUTH_CODE",
				"DEPT_TYPE_CODE", "REMARK", 1, "ID11111", 1, new Date(), "CREATE_BY", new Date(), "LAST_MODIFIED_BY");
		
		int type = deptMapper.insertDept(deptDO);
		if (type == 1) {
			log.info("新增成功");
		}
	}

	/**
	 * 更新一个部门信息
	 */
	@Test
	public void tesUpdateDept() {
		DeptDO deptDO = new DeptDO("111", "DEPT_NAME", "DEPT_NAME_J", "PARENT_DEPT_CODE", "AUTH_CODE", "DEPT_TYPE_CODE",
				"REMARK", 1, "ID", 1, new Date(), "CREATE_BY", new Date(), "LAST_MODIFIED_BY");
		deptDO.setDeptName("部门已经");
		int type = deptMapper.updateDept(deptDO);
		if (type == 1) {
			log.info("修改成功");
		} else {
			log.info("修改失败");
		}
	}

	/**
	 * 逻辑删除部门信息
	 */
	@Test
	public void testDeleteDeptByDeptCode() {
		int delType = deptMapper.deleteDeptByDeptCode("111","张三");
		log.info(delType + "");
	}
	
	/**
	 * 统计部门和子部门用户数量
	 */
	@Test
	public void testCountDeptUserByDeptCodAndAuthCode() {
		int delType = deptMapper.countDeptUserByDeptCodAndAuthCode("1");
		log.info(delType + "");
	}
	/**
	 * 
	 * 部门：上海软件研发中心
	 * 功能：通过父类部门编码获取父类部门信息
	 * 描述：
	 *返回值：
	 * 作成者：刘昊鑫
	 * 作成时间： 2018年12月17日
	 */
	@Test
	public void testQueryParentDeptByParentDeptCode() {
		DeptDO deptDO = deptMapper.queryParentDeptByParentDeptCode("2018072517042574984");
		log.info(deptDO.toString());
	}
	
	@Test
	public void testQueryMaxAuthCodeByParentDeptCode() {
		String maxAuthCode = deptMapper.queryMaxAuthCodeByParentDeptCode("2018072517042574984");
		log.info(maxAuthCode);
	}
}
