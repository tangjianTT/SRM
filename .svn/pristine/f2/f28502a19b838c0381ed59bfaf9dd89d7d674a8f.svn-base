package com.neusoft.srm.mapper.log;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.log.LoginLogDO;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月11日
 * @功能描述：登录日志Mapper接口
 */
@Mapper
public interface LoginLogMapper {
	/**
	 * @部门：上海软件研发中心
	 * @功能：按条件查询模糊查询所有登录日志
	 * @描述：userName 			查询用户名
	 * 	  gmtCreateFrom 	开始创建时间
	 * 	  gmtCreateEnd		 结束创建时间
	 * @返回值：List集合 装载LoginLogMapper对象  符合条件的所有登录日志文件
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	List<LoginLogDO> selectLoginLogByCond(@Param("userName") String userName,
			@Param("gmtCreateFrom") String gmtCreateFrom, @Param("gmtCreateEnd") String gmtCreateEnd);

	/**
	 * @部门：上海软件研发中心
	 * @功能：按条件统计登录日志总数
	 * @描述：userName 查询用户名
	 * 	  gmtCreateFrom 开始创建时间
	 * 	  gmtCreateEnd 结束创建时间
	 * @返回值：Integer  返回符合条件的登录日志总数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	Integer countLoginLogByCond(@Param("userName") String userName, @Param("gmtCreateFrom") String gmtCreateFrom,
			@Param("gmtCreateEnd") String gmtCreateEnd);

	/**
	 * @部门：上海软件研发中心
	 * @功能：增加登录日志信息
	 * @描述：loginLogDO	登录日志DO对象
	 * @返回值：插入日志数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	Integer insertLoginLog(@Param("loginLogDO") LoginLogDO loginLogDO);
}