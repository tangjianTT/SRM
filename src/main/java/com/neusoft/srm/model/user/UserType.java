package com.neusoft.srm.model.user;
/**
 * @部门：上海软件研发中心
 * @功能：用户模块新增，修改模块选择用户类型
 * @描述：用户类型
 * @作成者：王高亮
 * @author WGL
 * @作成时间：2018/12/13
 */
public class UserType {
 private String userTypeCode;
 
 private String userTypeName;
 
 private String delFlag;

 
@Override
public String toString() {
	return "UserType [userTypeCode=" + userTypeCode + ", userTypeName=" + userTypeName + ", delFlag=" + delFlag + "]";
}

public String getUserTypeCode() {
	return userTypeCode;
}

public void setUserTypeCode(String userTypeCode) {
	this.userTypeCode = userTypeCode;
}

public String getUserTypeName() {
	return userTypeName;
}

public void setUserTypeName(String userTypeName) {
	this.userTypeName = userTypeName;
}

public String getDelFlag() {
	return delFlag;
}

public void setDelFlag(String delFlag) {
	this.delFlag = delFlag;
}
 
 
}
