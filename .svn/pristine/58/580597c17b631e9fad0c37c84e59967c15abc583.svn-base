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
 * @开发日期： 2018年12月11日
 * @功能描述： 记录日志 封装类
 */
@Repository
public class AccessLogDO implements Serializable{
	private static final long serialVersionUID = 1L;
	/**id*/
	private String id;
	/**日志编码*/
	private String accessCode;
	/**应用标识*/
	private String appid;
	/**日志类型*/
	private String method;
	/**所属应用系统名称*/
	private String applicationName;
	/**客户端ip*/
	private String clientIp;
	/**客户端端口*/
	private String clientPort;
	/**目标ip*/
	private String targetIp;
	/**目标实例ip*/
	private String instanceIp;
	/**目标实例端口*/
	private String instancePort;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	/**请求时间点*/
	private Date readTime;
	/**时区*/
	private String timezones;
	/**请求响应时间*/
	private String processTime;
	/**请求协议*/
	private String protocol;
	/**请求方式*/
	private String httpMethod;
	/**请求的url地址*/
	private String url;
	/**返回状态*/
	private String status;
	/**请求页面的大小*/
	private String receiveSize;
	/**返回数据包大小*/
	private String sendSize;
	/**访问的来源链接*/
	private String referrer;
	/**操作系统*/
	private String userAgent;
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
	/**用户名*/
	private String userName;
	/**会话ID*/
	private String sessionid;

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

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode == null ? null : accessCode.trim();
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid == null ? null : appid.trim();
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method == null ? null : method.trim();
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName == null ? null : applicationName.trim();
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp == null ? null : clientIp.trim();
	}

	public String getClientPort() {
		return clientPort;
	}

	public void setClientPort(String clientPort) {
		this.clientPort = clientPort == null ? null : clientPort.trim();
	}

	public String getTargetIp() {
		return targetIp;
	}

	public void setTargetIp(String targetIp) {
		this.targetIp = targetIp == null ? null : targetIp.trim();
	}

	public String getInstanceIp() {
		return instanceIp;
	}

	public void setInstanceIp(String instanceIp) {
		this.instanceIp = instanceIp == null ? null : instanceIp.trim();
	}

	public String getInstancePort() {
		return instancePort;
	}

	public void setInstancePort(String instancePort) {
		this.instancePort = instancePort == null ? null : instancePort.trim();
	}

	public Date getReadTime() {
		return readTime;
	}

	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}

	public String getTimezones() {
		return timezones;
	}

	public void setTimezones(String timezones) {
		this.timezones = timezones == null ? null : timezones.trim();
	}

	public String getProcessTime() {
		return processTime;
	}

	public void setProcessTime(String processTime) {
		this.processTime = processTime == null ? null : processTime.trim();
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol == null ? null : protocol.trim();
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod == null ? null : httpMethod.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public String getReceiveSize() {
		return receiveSize;
	}

	public void setReceiveSize(String receiveSize) {
		this.receiveSize = receiveSize == null ? null : receiveSize.trim();
	}

	public String getSendSize() {
		return sendSize;
	}

	public void setSendSize(String sendSize) {
		this.sendSize = sendSize == null ? null : sendSize.trim();
	}

	public String getReferrer() {
		return referrer;
	}

	public void setReferrer(String referrer) {
		this.referrer = referrer == null ? null : referrer.trim();
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent == null ? null : userAgent.trim();
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid == null ? null : sessionid.trim();
	}

	@Override
	public String toString() {
		return "AccessLogDO [id=" + id + ", accessCode=" + accessCode + ", appid=" + appid + ", method=" + method
				+ ", applicationName=" + applicationName + ", clientIp=" + clientIp + ", clientPort=" + clientPort
				+ ", targetIp=" + targetIp + ", instanceIp=" + instanceIp + ", instancePort=" + instancePort
				+ ", readTime=" + readTime + ", timezones=" + timezones + ", processTime=" + processTime + ", protocol="
				+ protocol + ", httpMethod=" + httpMethod + ", url=" + url + ", status=" + status + ", receiveSize="
				+ receiveSize + ", sendSize=" + sendSize + ", referrer=" + referrer + ", userAgent=" + userAgent
				+ ", feature=" + feature + ", delFlag=" + delFlag + ", sortNo=" + sortNo + ", gmtCreate=" + gmtCreate
				+ ", createBy=" + createBy + ", gmtModified=" + gmtModified + ", lastModifiedBy=" + lastModifiedBy
				+ ", userName=" + userName + ", sessionid=" + sessionid + ", requestParamJson=" + requestParamJson
				+ "]";
	}

	
}