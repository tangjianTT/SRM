package com.neusoft.srm.model.notice;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @部门：上海软件研发中心
 * @功能   NoticeFileDO实体类
 * @描述： 定义 NoticeFileDO实体属性
 * @作成者：汤健 
 * @作成时间：2018-12-17
 * @author TJ
 */
public class NoticeFileDO {
    private String noticeFileCode;

    private String noticeFileName;

    private String noticeFileUrl;

    private String noticeCode;

    private Integer delFlag;

    private String id;

    private Integer sortNo;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtCreate;

    private String createBy;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtModified;

    private String lastModifiedBy;

    public String getNoticeFileCode() {
        return noticeFileCode;
    }

    @Override
	public String toString() {
		return "NoticeFileDO [noticeFileCode=" + noticeFileCode + ", noticeFileName=" + noticeFileName
				+ ", noticeFileUrl=" + noticeFileUrl + ", noticeCode=" + noticeCode + ", delFlag=" + delFlag + ", id="
				+ id + ", sortNo=" + sortNo + ", gmtCreate=" + gmtCreate + ", createBy=" + createBy + ", gmtModified="
				+ gmtModified + ", lastModifiedBy=" + lastModifiedBy + "]";
	}

	public void setNoticeFileCode(String noticeFileCode) {
        this.noticeFileCode = noticeFileCode == null ? null : noticeFileCode.trim();
    }

    public String getNoticeFileName() {
        return noticeFileName;
    }

    public void setNoticeFileName(String noticeFileName) {
        this.noticeFileName = noticeFileName == null ? null : noticeFileName.trim();
    }

    public String getNoticeFileUrl() {
        return noticeFileUrl;
    }

    public void setNoticeFileUrl(String noticeFileUrl) {
        this.noticeFileUrl = noticeFileUrl == null ? null : noticeFileUrl.trim();
    }

    public String getNoticeCode() {
        return noticeCode;
    }

    public void setNoticeCode(String noticeCode) {
        this.noticeCode = noticeCode == null ? null : noticeCode.trim();
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
}