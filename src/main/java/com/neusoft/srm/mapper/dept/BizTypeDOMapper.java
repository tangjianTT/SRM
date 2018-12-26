package com.neusoft.srm.mapper.dept;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.dept.BizTypeDO;


/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月10日
 * @功能描述：业务类型接口
 */
@Mapper
public interface BizTypeDOMapper {

	/**
	 * @部门：上海软件研发中心
	 * @功能：查询所有业务类型的集合
	 * @描述：
	 * @返回值：业务类型集合
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	List<BizTypeDO> findListBizType();
}