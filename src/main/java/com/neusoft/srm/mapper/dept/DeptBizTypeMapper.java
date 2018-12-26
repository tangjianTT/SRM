package com.neusoft.srm.mapper.dept;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.dept.DeptBizTypeDO;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月11日
 * @功能描述：部门业务关系表
 */
@Mapper
public interface DeptBizTypeMapper {

	/**
	 * @部门：上海软件研发中心
	 * @功能：通过部门编码删除部门和业务关系表数据
	 * @描述：	deptCode 		部门编码
	*     	lastModifiedBy 	更新人
	 * @返回值： int 返回删除数据数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	public int deleteBizTypeAndDeptByDeptCode(@Param("deptCode") String deptCode,
			@Param("lastModifiedBy") String lastModifiedBy);

	/**
	 * @部门：上海软件研发中心
	 * @功能： 默认插入部门和业务关系表
	 * @描述：deptBizTypeDO 部门业务关系表封装类
	 * 	  bizTypeAy 	业务类型编码数组
	 * @返回值：int 返回批量插入数据数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	public int insertDefaultBatchBizTypeAndDept(@Param("deptBizType") DeptBizTypeDO deptBizTypeDO,
			@Param("bizTypeAy") String[] bizTypeAy);

	/**
	 * @部门：上海软件研发中心
	 * @功能：批量插入部门和业务关系表
	 * @描述：DeptBizTypeDO 部门业务关系表封装类
	 *    bizTypeAy 业务类型编码数组
	 * @返回值：int	返回批量插入数据数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	public int insertBatchBizTypeAndDept(@Param("deptBizType") DeptBizTypeDO deptBizTypeDO,
			@Param("bizTypeAy") String[] bizTypeAy);

	/**
	 * @部门：上海软件研发中心
	 * @功能： 批量更新部门和业务关系表
	 * @描述：deptCode 	部门编号
	 * @返回值：int 返回更新数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	public int updateBatchBizTypeAndDept(@Param("deptCode") String deptCode, @Param("bizTypeAy") String[] bizTypeAy);
}