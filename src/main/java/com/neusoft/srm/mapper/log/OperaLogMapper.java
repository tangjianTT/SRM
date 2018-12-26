package com.neusoft.srm.mapper.log;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.log.AccessLogDO;
import com.neusoft.srm.model.log.OperaLogDO;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月18日
 * @功能描述：操作日志Mapper接口
 */
@Mapper
public interface OperaLogMapper {
	/**
	 * @部门：上海软件研发中心
	 * @功能：按条件查询模糊查询所有操作日志
	 * @描述：userName 			查询用户名
	 * 	  gmtCreateFrom 	开始创建时间
	 * 	  gmtCreateEnd		 结束创建时间
	 *    pageCurrentSize 	从第多少条开始
	 *    pageSize 			分页跨度
	 * @返回值：List集合 装载OperaLogDO对象  符合条件的所有操作日志文件
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	List<OperaLogDO> selectOperaLogByCond(@Param("userName") String userName,
			@Param("gmtCreateFrom") String gmtCreateFrom, @Param("gmtCreateEnd") String gmtCreateEnd);

	/**
	 * @部门：上海软件研发中心
	 * @功能：按条件统计操作日志总数
	 * @描述：userName 查询用户名
	 * 	  gmtCreateFrom 开始创建时间
	 * 	  gmtCreateEnd 结束创建时间
	 * @返回值：Integer  返回符合条件的操作日志总数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	Integer countOperaLogByCond(@Param("userName") String userName, @Param("gmtCreateFrom") String gmtCreateFrom,
			@Param("gmtCreateEnd") String gmtCreateEnd);
	/**
	 * @部门：上海软件研发中心
	 * @功能：插入操作日志
	 * @描述：operaLogDO	插入操作日志
	 * @返回值：Integer 	返回插入数据条数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	Integer insertOperaLog(@Param("operaLogDO")OperaLogDO operaLogDO);
}