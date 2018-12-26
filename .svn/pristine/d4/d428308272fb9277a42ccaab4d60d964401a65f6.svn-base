package com.neusoft.srm.service.log.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.mapper.log.AccessLogMapper;
import com.neusoft.srm.mapper.log.LoginLogMapper;
import com.neusoft.srm.mapper.log.OperaLogMapper;
import com.neusoft.srm.model.log.AccessLogDO;
import com.neusoft.srm.model.log.LoginLogDO;
import com.neusoft.srm.model.log.OperaLogDO;
import com.neusoft.srm.service.log.LogService;
import com.neusoft.srm.util.ResponseCode;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月13日
 * @功能描述：日志服务实现类
 */
@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private LoginLogMapper loginLogMapper;
	@Autowired
	private AccessLogMapper accessLogMapper;
	@Autowired
	private OperaLogMapper operaLogMapper;

	@Override
	public Object queryLogByLogType(String userName, String gmtCreateFrom, String gmtCreateEnd, String logType,
			String pageNo, String pageSize) {
		// 页码和分业跨度解析
		Integer newPageNo = Integer.parseInt(pageNo);
		Integer newPageSize = Integer.parseInt(pageSize);
		//分页操作
		PageHelper.startPage(newPageNo, newPageSize);
		
		// 判断日志类型
		if (ResponseCode.LOGIN_LOG_TYPE_CODE.equals(logType)) {
			List<LoginLogDO> loginLogList = loginLogMapper.selectLoginLogByCond(userName, gmtCreateFrom, gmtCreateEnd);
		   return new PageInfo<>(loginLogList);
		}
		if (ResponseCode.RECORD_LOG_TYPE_CODE.equals(logType)) {
			List<AccessLogDO> accessLogList = accessLogMapper.selectAccessLogByCond(userName, gmtCreateFrom, gmtCreateEnd);
			return new PageInfo<>(accessLogList);
		}
		List<OperaLogDO> operaLogList = operaLogMapper.selectOperaLogByCond(userName, gmtCreateFrom, gmtCreateEnd);
		return new PageInfo<>(operaLogList);
	}

	@Override
	public Integer countLogByLogTypeAndCond(String logType, String userName, String gmtCreateFrom,
			String gmtCreateEnd) {
		// 判断日志类型
		if (ResponseCode.LOGIN_LOG_TYPE_CODE.equals(logType)) {
			return loginLogMapper.countLoginLogByCond(userName, gmtCreateFrom, gmtCreateEnd);
		}
		if (ResponseCode.RECORD_LOG_TYPE_CODE.equals(logType)) {
			return accessLogMapper.countAccessLogByCond(userName, gmtCreateFrom, gmtCreateEnd);
		}
		return operaLogMapper.countOperaLogByCond(userName, gmtCreateFrom, gmtCreateEnd);
	}

	@Override
	public Integer acceptPageNumByPageCount(Integer pageCount,Integer pageSize) {
		return (pageCount+pageSize-1)/pageSize;
	}

}
