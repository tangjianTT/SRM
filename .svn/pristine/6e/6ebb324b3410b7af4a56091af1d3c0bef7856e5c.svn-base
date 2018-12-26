package com.neusoft.srm.service.user.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.srm.mapper.user.UserTypeMapper;
import com.neusoft.srm.model.user.UserType;
import com.neusoft.srm.service.user.UserTypeService;
   /**
	 * 部门：上海软件研发中心
	 * 功能：查找用户类型
	 * 描述：海尔1，客户3
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
@Service
@Transactional(rollbackFor= {Exception.class,RuntimeException.class})
 public class UserTypeServiceImpl implements UserTypeService {	
@Autowired
 private UserTypeMapper userTypeMapper;
   /**
	 * 部门：上海软件研发中心
	 * 功能：查找用户类型
	 * 描述：海尔1，客户3
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
	@Override
	public List<UserType> getUserTypeList() {
       List<UserType> userTypeList = userTypeMapper.findUserTypeList();
		return userTypeList;
	}
}
