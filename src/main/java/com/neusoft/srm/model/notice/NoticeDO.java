package com.neusoft.srm.model.notice;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @部门：上海软件研发中心
 * @功能    Notice实体类
 * @描述： 定义 Notice实体属性
 * @作成者：汤健 
 * @作成时间：2018-12-13
 * @author TJ
 */
public class NoticeDO {
  

	private String noticeCode;

    private String noticeTitle;

    private String noticeKeyword;
    
    private String bizTypeCode;

    private String userCode;

    private String postCode;

    private String deptCode;

    private String authCode;

    private String authDeptTypeCode;

    private Integer topFlag;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date validDateStart;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date validDateEnd;

    private String prisonType;

    private Integer delFlag;

    private String id;

    private Integer sortNo;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtCreate;

    private String createBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtModified;

    private String lastModifiedBy;

    private String noticeContent;

    public String getNoticeCode() {
        return noticeCode;
    }

    public void setNoticeCode(String noticeCode) {
        this.noticeCode = noticeCode == null ? null : noticeCode.trim();
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle == null ? null : noticeTitle.trim();
    }

    public String getNoticeKeyword() {
        return noticeKeyword;
    }

    public void setNoticeKeyword(String noticeKeyword) {
        this.noticeKeyword = noticeKeyword == null ? null : noticeKeyword.trim();
    }

    public String getBizTypeCode() {
        return bizTypeCode;
    }

    public void setBizTypeCode(String bizTypeCode) {
        this.bizTypeCode = bizTypeCode == null ? null : bizTypeCode.trim();
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode == null ? null : authCode.trim();
    }

    public String getAuthDeptTypeCode() {
        return authDeptTypeCode;
    }

    public void setAuthDeptTypeCode(String authDeptTypeCode) {
        this.authDeptTypeCode = authDeptTypeCode == null ? null : authDeptTypeCode.trim();
    }

    public Integer getTopFlag() {
        return topFlag;
    }

    public void setTopFlag(Integer topFlag) {
        this.topFlag = topFlag;
    }

    public Date getValidDateStart() {
        return validDateStart;
    }

    public void setValidDateStart(Date validDateStart) {
        this.validDateStart = validDateStart;
    }

    public Date getValidDateEnd() {
        return validDateEnd;
    }

    public void setValidDateEnd(Date validDateEnd) {
        this.validDateEnd = validDateEnd;
    }

    public String getPrisonType() {
        return prisonType;
    }

    public void setPrisonType(String prisonType) {
        this.prisonType = prisonType == null ? null : prisonType.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }
    
    @Override
  	public String toString() {
  		return "NoticeDO [noticeCode=" + noticeCode + ", noticeTitle=" + noticeTitle + ", noticeKeyword="
  				+ noticeKeyword + ", bizTypeCode=" + bizTypeCode + ", userCode=" + userCode + ", postCode=" + postCode
  				+ ", deptCode=" + deptCode + ", authCode=" + authCode + ", authDeptTypeCode=" + authDeptTypeCode
  				+ ", topFlag=" + topFlag + ", validDateStart=" + validDateStart + ", validDateEnd=" + validDateEnd
  				+ ", prisonType=" + prisonType + ", delFlag=" + delFlag + ", id=" + id + ", sortNo=" + sortNo
  				+ ", gmtCreate=" + gmtCreate + ", createBy=" + createBy + ", gmtModified=" + gmtModified
  				+ ", lastModifiedBy=" + lastModifiedBy + ", noticeContent=" + noticeContent + "]";
  	}
}