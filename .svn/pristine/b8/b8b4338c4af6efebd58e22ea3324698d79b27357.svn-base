package com.neusoft.srm.aop.dept;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.transform.impl.AddPropertyTransformer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.mysql.fabric.Response;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.constant.Constant;
import com.neusoft.srm.mapper.dept.DeptDOMapper;
import com.neusoft.srm.mapper.log.AccessLogMapper;
import com.neusoft.srm.mapper.log.LoginLogMapper;
import com.neusoft.srm.mapper.log.OperaLogMapper;
import com.neusoft.srm.model.dept.DeptDO;
import com.neusoft.srm.model.log.AccessLogDO;
import com.neusoft.srm.model.log.LoginLogDO;
import com.neusoft.srm.model.log.OperaLogDO;
import com.neusoft.srm.util.AddressUtils;
import com.neusoft.srm.util.AutoProduceCode;
import com.neusoft.srm.util.ServerResponse;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月19日
 * @功能描述：登陸日志AOP
 */
@Aspect
@Component
@Transactional(rollbackFor = { Exception.class, RuntimeException.class })
public class LoginLogAspect {
	private final static Logger logger = LoggerFactory.getLogger(LoginLogAspect.class);
	@Autowired
	private LoginLogMapper loginLogMapper;
	@Autowired
	private AccessLogMapper accessLogMapper;
	@Autowired
	private OperaLogMapper operaLogMapper;
	@Autowired
	private DeptDOMapper deptDOMapper;

	@Pointcut("@annotation(com.neusoft.srm.annotation.LogOperat)")
	private void loginLog() {
	}

	@Around("loginLog()")
	public Object doAround(ProceedingJoinPoint joinPoint) {
		// 获取注解方法
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		LogOperat logOperat = methodSignature.getMethod().getAnnotation(LogOperat.class);
		// 执行操作方法
		Object res = null;
		try {
			res = joinPoint.proceed();
			// 获取日志状态码
			String logType = logOperat.logType().getValue();
			// 判断日志类型进行操作
			if (Constant.LOGIN_LOG_TYPE.equals(logType)) {
				// 插入登录日志
				addLoginLog(logOperat, res);
				return res;
			}
			if (Constant.ACCESS_LOG_TYPE.equals(logType)) {
				// 插入记录日志 和 操作 日志
				addAccessLog(logOperat);
				logger.info("========操作日志记录======");
				addOperaLog(logOperat);
				return res;
			}
			// 插入操作日志
			addOperaLog(logOperat);
			return res;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：添加操作日志
	 * @描述：joinPoint		连接点
	 * 		 logOperat		获取注解信息
	 * 		 request		前端请求
	 * @返回值：连接点执行后对象	
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	@SuppressWarnings("unused")
	private int addOperaLog(LogOperat logOperat) {
		logger.info("增加操作日志");
		// 获取前台信息
		logger.info("获取前台信息");
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
		// 获取userCode和userName
		HttpSession session = request.getSession();
		String userCode = (String) session.getAttribute("userCode");
		String userName = (String) session.getAttribute("userName");
		userCode = "2018092611464101926";
		userName = "张三";
		int insertNum = 0;
		try {
			// 根据用户查找部门信息
			DeptDO deptDO = deptDOMapper.queryDeptByUserCode(userCode);
			logger.info(deptDO.toString());
			// 获取操作日志
			OperaLogDO operaLogDO = new OperaLogDO();
			AutoProduceCode autoProduceCode = new AutoProduceCode();
			operaLogDO.setOperaCode(autoProduceCode.produceCode());
			operaLogDO.setStation(deptDO.getDeptName());
			operaLogDO.setStationCode(deptDO.getDeptCode());
			operaLogDO.setUserId(userCode);
			operaLogDO.setUserName(userName);
			operaLogDO.setSourceType(logOperat.sourceType());
			operaLogDO.setSourceApplication(request.getHeader("user-agent"));
			operaLogDO.setSourcePublicIp(AddressUtils.getInnetIp());
			operaLogDO.setCreateBy(userCode);
			operaLogDO.setLastModifiedBy(userCode);
			operaLogDO.setOperationType(logOperat.operationType().getValue());
			// 获取请求信息
			JSONObject obj = acceptRequestJson(request);
			operaLogDO.setRequestParamJson(obj.toJSONString());
			logger.info(operaLogDO.toString());
			// 操作日志插入数据库
			insertNum = operaLogMapper.insertOperaLog(operaLogDO);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return insertNum;
	}

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能	 获取请求JSON串
	 * @描述：request	前端页面数据请求
	 * @返回值：JSONObject 对象
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月20日
	 */
	private JSONObject acceptRequestJson(HttpServletRequest request) {
		Map<String, String[]> requestMap = request.getParameterMap();
		JSONObject obj = new JSONObject();
		obj.putAll(requestMap);
		return obj;
	}

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：添加记录日志
	 * @描述：joinPoint		连接点
	 * 		 logOperat		获取注解信息
	 * 		 request		前端请求
	 * @返回值：
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	@SuppressWarnings("unused")
	private Object addAccessLog(LogOperat logOperat) {
		logger.info("增加记录日志");
		// 获取前台信息
		logger.info("获取前台信息");
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
		// 获取userCode和userName
		HttpSession session = request.getSession();
		String userCode = (String) session.getAttribute("userCode");
		String userName = (String) session.getAttribute("userName");
		userCode = "2018092611464101926";
		userName = "张三";
		// 插入数量
		int insertNum = 0;
		try {
			long startTime = System.currentTimeMillis();
			long endTime = System.currentTimeMillis();
			// 获取记录日志数据
			AccessLogDO accessLogDO = new AccessLogDO();
			AutoProduceCode autoProduceCode = new AutoProduceCode();
			accessLogDO.setAccessCode(autoProduceCode.produceCode());
			accessLogDO.setClientIp(request.getRemoteAddr());
			accessLogDO.setClientPort(String.valueOf(request.getRemotePort()));
			accessLogDO.setTargetIp(AddressUtils.getInnetIp());
			accessLogDO.setInstanceIp(AddressUtils.getInnetIp());
			accessLogDO.setInstancePort(String.valueOf(request.getLocalPort()));
			// 计算时区
			String timeZone = DateFormatUtils.format(new Date(), "Z");
			accessLogDO.setTimezones(timeZone);
			accessLogDO.setProcessTime(String.valueOf((endTime - startTime) / 1000F));
			accessLogDO.setProtocol(request.getScheme());
			accessLogDO.setHttpMethod(request.getMethod());
			accessLogDO.setUrl(request.getRequestURL().toString());
			accessLogDO.setCreateBy(userCode);
			accessLogDO.setUserName(userName);
			accessLogDO.setLastModifiedBy(userCode);
			accessLogDO.setSessionid(session.getId());
			JSONObject obj = acceptRequestJson(request);
			accessLogDO.setRequestParamJson(obj.toJSONString());
			logger.info(accessLogDO.toString());
			// 记录日志插入数据库
			return accessLogMapper.insertAccessLog(accessLogDO);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return insertNum;
	}

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：插入登录日志信息
	 * @描述：joinPoint		连接点
	 * 		 logOperat		获取注解信息
	 * 		 request		前端请求
	 * @返回值：
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	private Object addLoginLog(LogOperat logOperat, Object res) {
		// 获取前台信息
		logger.info("获取前台信息");
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletResponse response = ((ServletRequestAttributes) requestAttributes).getResponse();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
		// 获取userCode和userName
		HttpSession session = request.getSession();
		String userCode = (String) session.getAttribute("userCode");
		String userName = (String) session.getAttribute("userName");
		userCode = "2018092611464101926";
		userName = "张三";
		// 登录日志开始执行
		logger.info("增加登录日志");
		// 日志执行数量
		int insertNum = 0;
		try {
			ServerResponse serverResponse = (ServerResponse) res;
			LoginLogDO loginLogDO = new LoginLogDO();
			// 判断你登录日志响应信息
			if (serverResponse.getresultCode() == 0) {
				loginLogDO.setResults("success");
			} else {
				loginLogDO.setResults("fail");
			}
			// 根据用户查找部门信息
			userCode = "2018092611464101926";
			DeptDO deptDO = deptDOMapper.queryDeptByUserCode(userCode);
			logger.info(deptDO.toString());
			// 登录之后 获取登录日志所需信息
			AutoProduceCode autoProduceCode = new AutoProduceCode();
			loginLogDO.setLoginCode(autoProduceCode.produceCode());
			loginLogDO.setSourceType(logOperat.sourceType());
			loginLogDO.setSourceApplication(request.getHeader("user-agent"));
			loginLogDO.setUserId(userCode);
			loginLogDO.setUserName(userName);
			loginLogDO.setStationId(deptDO.getDeptCode());
			loginLogDO.setStation(deptDO.getDeptName());
			loginLogDO.setLastModifiedBy(userCode);
			loginLogDO.setCreateBy(userCode);
			// 通过UserCode查询部门信息
			loginLogDO.setCreateBy(userCode);
			loginLogDO.setLastModifiedBy(userCode);
			loginLogDO.setOperationType(logOperat.operationType().getValue());
			loginLogDO.setSourcePublicIp(AddressUtils.getInnetIp());
			logger.info(loginLogDO.toString());
			// 获取请求信息
			JSONObject obj = acceptRequestJson(request);
			loginLogDO.setRequestParamJson(obj.toJSONString());
			// 插入数据库
			insertNum = loginLogMapper.insertLoginLog(loginLogDO);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return insertNum;
	}
}
