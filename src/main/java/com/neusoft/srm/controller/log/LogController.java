package com.neusoft.srm.controller.log;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.log.AccessLogDO;
import com.neusoft.srm.model.log.LoginLogDO;
import com.neusoft.srm.model.log.OperaLogDO;
import com.neusoft.srm.service.log.LogService;
import com.neusoft.srm.util.ResponseCode;
import com.neusoft.srm.util.ServerResponse;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月18日
 * @功能描述：日志控制类
 */
@MapperScan("com.neusoft.srm.mapper")
@RequestMapping("log")
@RestController
public class LogController {
	private static Logger log = LoggerFactory.getLogger(LogController.class);
	@Autowired
	private LogService logService;

	/**
	 * @部门：上海软件研发中心
	 * @功能：查询日志
	 * @描述：userName 用户名
	 *    gmtCreateFrom 开始创建时间
	 *    logType 日志状态   0 登陆日志  1 记录日志   2 操作日志
	 *    pageNo 页码     默认1
	 *    pageSize 分页跨度   默认跨度 10
	 * @返回值：对应日志信息JSON串
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	@LogOperat(detail = "查询日志", logType = LogType.ACCESS,operationType = OperaLogType.SELECT)
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "queryByFuzzyLog", method = RequestMethod.GET)
	public Object queryByFuzzyLog(@RequestParam(name = "userName",required=false) String userName,
			@RequestParam(name = "gmtCreateFrom",required=false) String gmtCreateFrom,
			@RequestParam(name = "gmtCreateEnd",required=false) String gmtCreateEnd,
			@RequestParam(name = "logType", required = true) String logType,
			@RequestParam(name = "pageNo", defaultValue = "1") String pageNo,
			@RequestParam(name = "pageSize", defaultValue = "10") String pageSize) {
		log.info("=========queryByFuzzyLog============");
		// 判断日志状态
		Map<String, Object> logMap = new HashMap<>(0);
		PageInfo<Object> pageInfo = null;
		if (ResponseCode.LOGIN_LOG_TYPE_CODE.equals(logType)) {
			// 登录日志查询
			pageInfo = (PageInfo<Object>) logService.queryLogByLogType(userName, gmtCreateFrom, gmtCreateEnd, logType,
					pageNo, pageSize);
			// 获取 日志总数 和 页数
			addPageCountAndNum(logMap, pageInfo);
			logMap.put("loginLogList", pageInfo.getList());
			return ServerResponse.createBySuccess("登录日志查询成功", logMap);
		}
		if (ResponseCode.RECORD_LOG_TYPE_CODE.equals(logType)) {
			// 记录日志查询
			pageInfo = (PageInfo<Object>) logService.queryLogByLogType(userName, gmtCreateFrom, gmtCreateEnd, logType,
					pageNo, pageSize);
			addPageCountAndNum(logMap, pageInfo);
			logMap.put("accessLogList", pageInfo.getList());
			return ServerResponse.createBySuccess("记录日志查询成功", logMap);
		}
		// 操作日志查询
		pageInfo = (PageInfo<Object>) logService.queryLogByLogType(userName, gmtCreateFrom, gmtCreateEnd, logType,
				pageNo, pageSize);
		addPageCountAndNum(logMap, pageInfo);
		logMap.put("operaLogList", pageInfo.getList());
		// 返回服务响应信息
		return ServerResponse.createBySuccess("操作日志查询成功", logMap);
	}

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：添加当前页数和总页数
	 * @描述：logMap  日志反馈数据Map集合
	 * 		pageInfo 分页数据
	 * @返回值：
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	private void addPageCountAndNum(Map<String, Object> logMap, PageInfo<Object> pageInfo) {
		logMap.put("pageCount", pageInfo.getPageNum());
		logMap.put("pageNum", pageInfo.getTotal());
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能：统计总页数和条目数量
	 * @描述：userName 用户名
	 *    gmtCreateFrom 开始创建时间
	 *    gmtCreateEnd 结束创建时间
	 *    logType 日志状态   0 登陆日志  1 记录日志   2 操作日志
	 *    pageSize 分页跨度   默认跨度 10
	 *    loginMap 日志反馈Map
	 * @返回值：
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	private void counLogNumAndPageNum(String userName, String gmtCreateFrom, String gmtCreateEnd, String logType,
			String pageSize, Map<String, Object> loginMap) {
		// 获取总数
		int countLogNum = logService.countLogByLogTypeAndCond(logType, userName, gmtCreateFrom, gmtCreateEnd);
		// 获取总页数
		int countPageNum = logService.acceptPageNumByPageCount(countLogNum, Integer.parseInt(pageSize));
		loginMap.put("pageNum", countLogNum);
		loginMap.put("pageCount", countPageNum);
	}
}
