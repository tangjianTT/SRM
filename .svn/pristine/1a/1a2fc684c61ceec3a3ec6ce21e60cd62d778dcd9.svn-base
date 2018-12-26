package com.neusoft.srm.model.log;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月20日
 * @功能描述：操作日志 封装类
 */
@Repository
public class OperaLogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	/**操作日志ID*/
	private String id;
	/**操作日志编码*/
	private String operaCode;
	/**日志类型*/
	private String method;
	/**操作时间*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date operationTime;
	/**部门名称*/
	private String station;
	/**部门编码*/
	private String stationCode;
	/**站点所在省份*/
	private String province;
	/**站点所在城市*/
	private String city;
	/**用户ID*/
	private String userId;
	/**用户名称*/
	private String userName;
	/**账户*/
	private String userAcnt;
	/**发起请求的终端应用类型*/
	private String sourceType;
	/**发起请求的应用\数据库*/
	private String sourceApplication;
	/**查询操作员公网IP*/
	private String sourcePublicIp;
	/**查询操作员内网IP*/
	private String sourcePrivateIp;
	/**查询操作员VPN IP*/
	private String sourceVpnIp;
	/**查询源MAC地址*/
	private String sourceMac;
	/**请求的目标应用\数据库*/
	private String targetApplication;
	/**查询目标端公网IP*/
	private String targetPublicIp;
	/**查询目标端内网IP*/
	private String targetPrivateIp;
	/**操作类型*/
	private String operationType;
	/**操作执行结果*/
	private String result;
	/**结果原因*/
	private String reason;
	/**查询\导出的信息内容*/
	private String content;
	/**运号单*/
	private String mailNo;
	/**物流订单号*/
	private String orderId;
	/**本次查询设计单号数据*/
	private String associationNumber;
	/**邮箱*/
	private String email;
	/**预留拓展字段*/
	private String feature;
	/**作废标记*/
	private Integer delFlag;
	/**序号*/
	private Integer sortNo;
	/**创建时间*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date gmtCreate;
	/**创建人*/
	private String createBy;
	/**修改时间*/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date gmtModified;
	/**修改人*/
	private String lastModifiedBy;

	private String appid;

	private String requestParamJson;

	public String getRequestParamJson() {
		return requestParamJson;
	}

	public void setRequestParamJson(String requestParamJson) {
		this.requestParamJson = requestParamJson;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getOperaCode() {
		return operaCode;
	}

	public void setOperaCode(String operaCode) {
		this.operaCode = operaCode == null ? null : operaCode.trim();
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method == null ? null : method.trim();
	}

	public Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station == null ? null : station.trim();
	}

	public String getStationCode() {
		return stationCode;
	}

	public void setStationCode(String stationCode) {
		this.stationCode = stationCode == null ? null : stationCode.trim();
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserAcnt() {
		return userAcnt;
	}

	public void setUserAcnt(String userAcnt) {
		this.userAcnt = userAcnt == null ? null : userAcnt.trim();
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType == null ? null : sourceType.trim();
	}

	public String getSourceApplication() {
		return sourceApplication;
	}

	public void setSourceApplication(String sourceApplication) {
		this.sourceApplication = sourceApplication == null ? null : sourceApplication.trim();
	}

	public String getSourcePublicIp() {
		return sourcePublicIp;
	}

	public void setSourcePublicIp(String sourcePublicIp) {
		this.sourcePublicIp = sourcePublicIp == null ? null : sourcePublicIp.trim();
	}

	public String getSourcePrivateIp() {
		return sourcePrivateIp;
	}

	public void setSourcePrivateIp(String sourcePrivateIp) {
		this.sourcePrivateIp = sourcePrivateIp == null ? null : sourcePrivateIp.trim();
	}

	public String getSourceVpnIp() {
		return sourceVpnIp;
	}

	public void setSourceVpnIp(String sourceVpnIp) {
		this.sourceVpnIp = sourceVpnIp == null ? null : sourceVpnIp.trim();
	}

	public String getSourceMac() {
		return sourceMac;
	}

	public void setSourceMac(String sourceMac) {
		this.sourceMac = sourceMac == null ? null : sourceMac.trim();
	}

	public String getTargetApplication() {
		return targetApplication;
	}

	public void setTargetApplication(String targetApplication) {
		this.targetApplication = targetApplication == null ? null : targetApplication.trim();
	}

	public String getTargetPublicIp() {
		return targetPublicIp;
	}

	public void setTargetPublicIp(String targetPublicIp) {
		this.targetPublicIp = targetPublicIp == null ? null : targetPublicIp.trim();
	}

	public String getTargetPrivateIp() {
		return targetPrivateIp;
	}

	public void setTargetPrivateIp(String targetPrivateIp) {
		this.targetPrivateIp = targetPrivateIp == null ? null : targetPrivateIp.trim();
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType == null ? null : operationType.trim();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result == null ? null : result.trim();
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason == null ? null : reason.trim();
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getMailNo() {
		return mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo == null ? null : mailNo.trim();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public String getAssociationNumber() {
		return associationNumber;
	}

	public void setAssociationNumber(String associationNumber) {
		this.associationNumber = associationNumber == null ? null : associationNumber.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature == null ? null : feature.trim();
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

	public Integer getSortNo() {
		return sortNo;
	}

	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy == null ? null : createBy.trim();
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy == null ? null : lastModifiedBy.trim();
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid == null ? null : appid.trim();
	}

	@Override
	public String toString() {
		return "OperaLogDO [id=" + id + ", operaCode=" + operaCode + ", method=" + method + ", operationTime="
				+ operationTime + ", station=" + station + ", stationCode=" + stationCode + ", province=" + province
				+ ", city=" + city + ", userId=" + userId + ", userName=" + userName + ", userAcnt=" + userAcnt
				+ ", sourceType=" + sourceType + ", sourceApplication=" + sourceApplication + ", sourcePublicIp="
				+ sourcePublicIp + ", sourcePrivateIp=" + sourcePrivateIp + ", sourceVpnIp=" + sourceVpnIp
				+ ", sourceMac=" + sourceMac + ", targetApplication=" + targetApplication + ", targetPublicIp="
				+ targetPublicIp + ", targetPrivateIp=" + targetPrivateIp + ", operationType=" + operationType
				+ ", result=" + result + ", reason=" + reason + ", content=" + content + ", mailNo=" + mailNo
				+ ", orderId=" + orderId + ", associationNumber=" + associationNumber + ", email=" + email
				+ ", feature=" + feature + ", delFlag=" + delFlag + ", sortNo=" + sortNo + ", gmtCreate=" + gmtCreate
				+ ", createBy=" + createBy + ", gmtModified=" + gmtModified + ", lastModifiedBy=" + lastModifiedBy
				+ ", appid=" + appid + ", requestParamJson=" + requestParamJson + "]";
	}

}