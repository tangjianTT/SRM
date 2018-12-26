package com.neusoft.srm.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @部门：上海软件研发中心
 * @功能：用户模块功能操作
 * @描述：用户与部门关系的相关方法
 * @作成者：王高亮
 * @author WGL
 * @作成时间：2018/12/13
 */
@Mapper
 public interface UserDeptMapper {
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：通过新增用户信息的同时，添加到与之关联的用户部门表里面,参数：用户代码，部门代码，创建人
	 * @返回值:新增用户部门成功返回的行数
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
 public int insertUserDept(@Param("userCode")String userCode,
		                   @Param("deptCode")String deptCode,
		                   @Param("createBy")String createBy);
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：通过修改用户信息的同时，修改与之关联的用户部门表（t_sys_user_dept）里面的信息
	 * @返回值:修改用户部门成功返回的行数
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
 public int updateUserDept(@Param("userCode")String userCode,
		                   @Param("deptCode")String deptCode,
		                   @Param("createBy")String createBy);
}
