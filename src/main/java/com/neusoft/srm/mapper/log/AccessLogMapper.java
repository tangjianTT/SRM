package com.neusoft.srm.mapper.log;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.log.AccessLogDO;

/**
 * 
 * @部门： 软件开发事业部
 * @作者： HaoXin.Liu
 * @开发日期： 2018年12月11日
 * @功能描述：记录日志Mapper接口
 */
/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月11日
 * @功能描述：记录日志Mapper接口
 */
@Mapper
public interface AccessLogMapper {
	/**
	 * @部门：上海软件研发中心
	 * @功能：按条件查询模糊查询所有记录日志
	 * @描述：userName 			查询用户名
	 * 	  gmtCreateFrom 	开始创建时间
	 * 	  gmtCreateEnd		 结束创建时间
	 * @返回值：List集合 装载AccessLogDO对象  符合条件的所有记录日志文件
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	List<AccessLogDO> selectAccessLogByCond(@Param("userName") String userName,
			@Param("gmtCreateFrom") String gmtCreateFrom, @Param("gmtCreateEnd") String gmtCreateEnd);

	/**
	 * @部门：上海软件研发中心
	 * @功能：按条件统计记录日志总数
	 * @描述：userName 查询用户名
	 * 	  gmtCreateFrom 开始创建时间
	 * 	  gmtCreateEnd 结束创建时间
	 * @返回值：Integer  返回符合条件的记录日志总数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	Integer countAccessLogByCond(@Param("userName") String userName, @Param("gmtCreateFrom") String gmtCreateFrom,
			@Param("gmtCreateEnd") String gmtCreateEnd);
	/**
	 * @部门：上海软件研发中心
	 * @功能：插入记录日志
	 * @描述：accessLogDO	  记录日志DO数据
	 * @返回值：Integer	 返回插入数据条数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	Integer insertAccessLog(@Param("accessLogDO")AccessLogDO accessLogDO);
}