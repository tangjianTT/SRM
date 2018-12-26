package com.neusoft.srm.service.dept;

import java.util.List;
import java.util.Map;

import com.neusoft.srm.model.common.Tree;
import org.apache.ibatis.annotations.Mapper;

import com.neusoft.srm.model.dept.BizTypeDO;
import com.neusoft.srm.model.dept.DeptDO;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月7日
 * @功能描述：部门功能实现接口
 */
public interface DeptService {
	/**
	 * @部门：上海软件研发中心
	 * @功能：按条件查询所有数据
	 * @描述：
	 * @返回值：List集合 装载DeptDO对象 ，返回符合条件的部门集合
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	List<DeptDO> queryAllDeptList();

	/**
	 * @部门：上海软件研发中心
	 * @功能：增加或更新部门信息
	 * @描述：deptDO				部门封装类
	 *    bizTypeDO			业务状态封装类
	 *    lastModifiedBy	更新人
	 * @返回值：int  返回增加或更新状态
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	int addDept(DeptDO deptDO, String bizTypeDO, String lastModifiedBy);

	/**
	 * @部门：上海软件研发中心
	 * @功能：删除部门信息
	 * @描述：deptCode 部门编码
	 * 	  lastModifiedBy 更新人
	 * @返回值：int  返回删除数据
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	int removeDept(String deptCode, String lastModifiedBy);

	/**
	 * 获取树结构
	 * @作者 武京阳
	 * @时间 2018年12月14日
	 */
	Tree getAllDept(String deptRoot);

	/**
	 * 获取部门类别集合
	 * @作者 武京阳
	 * @时间 2018年12月14日
	 */
	public List<Map<String, String>> getDeptTypeList();

	/**
	 * 功能描述：
	 * @部门：上海软件研发中心
	 * 作者：武京阳
	 * 时间：2018/12/14
	 */
	int removeDept(String deptCode);
}
