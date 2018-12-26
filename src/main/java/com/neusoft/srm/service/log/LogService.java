package com.neusoft.srm.service.log;

/** 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月13日
 * @功能描述：日志服务接口
 */
public interface LogService {
	/**
	 * 部门：上海软件研发中心
	 * 功能：通过日志状态查询日志信息
	 * 描述：userName 用户名
	 *    gmtCreateFrom 创建时间  开始时间
	 *    gmtCreateEnd  创建时间 结束时间
	 *    0登录日志 1记录日志 2操作日志
	 *    pageNo 页码 默认1页
	 *    pageSize 分页跨度   默认10
	 *返回值：Object对象  对应类型的日志文件信息
	 * 作成者：刘昊鑫
	 * 作成时间： 2018年12月17日
	 */
	Object queryLogByLogType(String userName, String gmtCreateFrom, String gmtCreateEnd, String logType, String pageNo,
			String pageSize);

	/**
	 * 部门：上海软件研发中心
	 * 功能：根据状态和查询条件 获取 日志 总数
	 * 描述：logType 		日志状态   0登录日志 1记录日志 2操作日志
	 *    userName 		用户名
	 *    gmtCreateFrom 创建时间  开始时间
	 *    gmtCreateEnd  创建时间 结束时间
	 *返回值： Integer  	符合条件的日志总数
	 * 作成者：刘昊鑫
	 * 作成时间： 2018年12月17日
	 */
	Integer countLogByLogTypeAndCond(String logType, String userName, String gmtCreateFrom, String gmtCreateEnd);

	/**
	 * 部门：上海软件研发中心
	 * 功能： 获取总页数
	 * 描述：pageCount 总记录数
	 *    pageSize	分业跨度
	 *返回值：Integer  总页数 
	 * 作成者：刘昊鑫
	 * 作成时间： 2018年12月17日
	 */
	Integer acceptPageNumByPageCount(Integer pageCount,Integer pageSize);

}
