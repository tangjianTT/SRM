package com.neusoft.srm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @部门：上海软件研发中心 
 * @功能：实现自动生成Code 
 * @描述：AutoProduceCode工具类 
 * @作成者：汤健 
 * @作成时间：2018-12-11
 * @author TJ
 */
public class AutoProduceCode {

	public String produceCode() {
		// 获取当前时间
		Date date = new Date();
		// 根据时间戳获得需要的时间类型
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssss");
		// 转换成String类型
		String format = sdf.format(date);
		// 随机产生三位数
		int i=(int)(Math.random()*900)+100;
		//拼接字符串
		format+=i;
		// 返回字符串
		return format;
	}
	
}
