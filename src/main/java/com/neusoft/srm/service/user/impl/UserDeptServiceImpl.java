package com.neusoft.srm.service.user.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neusoft.srm.mapper.user.DeptMapper;
import com.neusoft.srm.model.dept.Dept;
import com.neusoft.srm.service.user.UserDeptService;

/**
 * 部门：上海软件研发中心
 * 功能：用户管理模块，新增，修改接口
 * 描述：查询所有部门信息
 * 作成者：王高亮
 * 作成时间：2018/12/13
 */
@Service
@Transactional(rollbackFor= {Exception.class,RuntimeException.class})
public class UserDeptServiceImpl implements UserDeptService {
	@Autowired
	private DeptMapper deptMapper;
	/**
	 * 部门：上海软件研发中心
	 * 功能：获取部门信息
	 * 描述：用户管理模块，新增，修改接口需要的部门信息
	 * 返回值：List集合，装载dept对象，发牛所有部门信息
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
	@Override
	public List<Dept> getDeptNameList() {
		List<Dept> deptTypeList = deptMapper.findListDept();
		return deptTypeList;
	}
}
