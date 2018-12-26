package com.neusoft.srm.model.operaflow;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @部门：上海软件研发中心
 * @功能    OperaFile实体类
 * @描述： 定义 OperaFile实体属性
 * @作成者：汤健 
 * @作成时间：2018-12-18
 * @author TJ
 */
public class OperaFileDO {
    private String id;

    private String operaFlowCode;

    private String attachFileName;

    private String attachFileOldName;

    private String attachFileUrl;

    private Integer delFlag;

    private Integer sortNo;
    
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtCreate;

    private String createBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtModified;

    private String lastModifiedBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOperaFlowCode() {
        return operaFlowCode;
    }

    public void setOperaFlowCode(String operaFlowCode) {
        this.operaFlowCode = operaFlowCode == null ? null : operaFlowCode.trim();
    }

    public String getAttachFileName() {
        return attachFileName;
    }

    public void setAttachFileName(String attachFileName) {
        this.attachFileName = attachFileName == null ? null : attachFileName.trim();
    }

    public String getAttachFileOldName() {
        return attachFileOldName;
    }

    public void setAttachFileOldName(String attachFileOldName) {
        this.attachFileOldName = attachFileOldName == null ? null : attachFileOldName.trim();
    }

    public String getAttachFileUrl() {
        return attachFileUrl;
    }

    public void setAttachFileUrl(String attachFileUrl) {
        this.attachFileUrl = attachFileUrl == null ? null : attachFileUrl.trim();
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
}