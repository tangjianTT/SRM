package com.neusoft.srm.util;

/**
 * @Author：Jingyang.Wu
 * @Date：2017/6/19.
 * @Description:
 */
public class ResponseCode {
	public static final int SUCCESS = 0;
	public static final String SUCCESS_MESSAGE = "操作成功!";

	public static final int ERORR = 1;
	public static final String ERORR_MESSAGE = "服务端异常!";

	// 需要登陆 状态码
	public static final int NEED_LOGIN = -1;
	public static final String NEED_LOGIN_MESSAGE = "用户未登录，请登录!";

	// 日志类型 状态码
	public static final String LOGIN_LOG_TYPE_CODE = "0";
	public static final String RECORD_LOG_TYPE_CODE = "1";
	public static final String OPERATE_LOG_TYPE_CODE = "2";
	
	//父类根节点 状态码
	public static final String DEPT_PARENT_CODE_ROOT_TYPE="0";

}