package com.neusoft.srm.model.user;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @部门：上海软件研发中心
 * @功能：用户模块功能操作
 * @描述：用户部门关联表属性
 * @作成者：王高亮
 * @author WGL
 * @作成时间：2018/12/13
 */
public class UserDept {
    private String userCode;

    private String deptCode;

    private Integer delFlag;

    private String id;

    private Integer sortNo;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtCreate;

    private String createBy;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtModified;

    private String lastModifiedBy;

    
    @Override
	public String toString() {
		return "UserDept [userCode=" + userCode + ", deptCode=" + deptCode + ", delFlag=" + delFlag + ", id=" + id
				+ ", sortNo=" + sortNo + ", gmtCreate=" + gmtCreate + ", createBy=" + createBy + ", gmtModified="
				+ gmtModified + ", lastModifiedBy=" + lastModifiedBy + "]";
	}

	public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
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