package com.neusoft.srm.mapper.dept;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.LoginOperationType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.dept.DeptDO;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期：  2018年12月7日
 * @功能描述：部门数据库（CRUD）功能接口
 */
@Mapper
public interface DeptDOMapper {
	/**
	 * @部门：上海软件研发中心
	 * @功能：查询所有部门信息
	 * @描述：
	 * @返回值：List集合 装载DeptDO对象，返回部门信息集合
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	public List<DeptDO> findListDept();

	/** 
	 * @部门：上海软件研发中心
	 * @功能：插入部门信息
	 * @描述：deptDO 部门封装类
	 * @返回值：int 返回插入数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	public int insertDept(@Param("deptDO") DeptDO deptDO);

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：更新部门信息
	 * @描述：deptDO 部门封装类
	 * @返回值：int 返回更新数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	public int updateDept(@Param("deptDO") DeptDO deptDO);

	/**
	 * @部门：上海软件研发中心
	 * @功能：根据部门编号删除部门
	 * @描述：deptCode 部门编码
	 *	  lastModifiedBy 更新人
	 * @返回值：int  返回删除数据数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	public int deleteDeptByDeptCode(@Param("deptCode") String deptCode, @Param("lastModifiedBy") String lastModifiedBy);

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：根据部门编号和自动编码 统计 数量
	 * @描述：deptCode 部门编码
	 * @返回值：int  返回统计数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	public int countDeptUserByDeptCodAndAuthCode(@Param("deptCode") String deptCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：根据父类部门编码 获取 父类部门 信息
	 * @描述：parentDeptCode  父部门编码
	 * @返回值：deptDO 父部门类型信息
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	public DeptDO queryParentDeptByParentDeptCode(@Param("parentDeptCode") String parentDeptCode);

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：根据父类编码查找最大的AuthCode
	 * @描述：parentDeptCode  父部门编码
	 * @返回值：String 父类编码最大的AuthCode
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	public String queryMaxAuthCodeByParentDeptCode(@Param("parentDeptCode") String parentDeptCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：通过用户编码查询部门信息
	 * @描述：userCode	用户编码
	 * @返回值：DeptDO	部门DO类
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月20日
	 */
	public DeptDO queryDeptByUserCode(@Param("userCode") String userCode);

	/**
	 * @功能描述：
	 * @部门：上海软件研发中心
	 * @作者：武京阳
	 * @时间：2018/12/14
	 */
	List<Map<String, String>> getAllDept();

	/**
	 * @功能描述：
	 * @部门：上海软件研发中心
	 * @作者：武京阳
	 * @时间：2018/12/14
	 */
	public List<Map<String, String>> getDeptTypeList();

	/**
	 * @功能描述：
	 * @部门：上海软件研发中心
	 * @作者：武京阳
	 * @时间：2018/12/14
	 */
	int countUserUnderDept(String deptCode);
	
	/**
	 * @功能描述：查询Dept父类Code
	 * @部门：上海软件研发中心
	 * @作者：汤健
	 * @时间：2018/12/20
	 */
	public List<String> findListParentDeptCode();
	
	
	/**
	 * @功能描述：查询DeptCode
	 * @部门：上海软件研发中心
	 * @作者：汤健
	 * @时间：2018/12/20
	 */
	public List<String> findListDeptCode();
}