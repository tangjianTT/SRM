package com.neusoft.srm.model.navigation;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.neusoft.srm.model.login.UserLoginDO;

/**
 * @部门：上海软件研发中心
 * @功能    AppSite实体类
 * @描述： 定义 AppSite实体属性
 * @作成者：汤健 
 * @作成时间：2018-12-11
 * @author TJ
 */
public class AppSiteDO {
    private String appsiteCode;

    private String appsiteName;

    private String appsitePicUrl;

    private String delFlag;

    private String id;

    private Integer sortNo;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtCreate;

    private String createBy;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmtModified;

    private String lastModifiedBy;
    
    private UserLoginDO userLoginDO;

    @Override
	public String toString() {
		return "AppSite [appsiteCode=" + appsiteCode + ", appsiteName=" + appsiteName + ", appsitePicUrl="
				+ appsitePicUrl + ", delFlag=" + delFlag + ", id=" + id + ", sortNo=" + sortNo + ", gmtCreate="
				+ gmtCreate + ", createBy=" + createBy + ", gmtModified=" + gmtModified + ", lastModifiedBy="
				+ lastModifiedBy + ", userLoginDO=" + userLoginDO + "]";
	}

	public UserLoginDO getUserLoginDO() {
		return userLoginDO;
	}

	public void setUserLoginDO(UserLoginDO userLoginDO) {
		this.userLoginDO = userLoginDO;
	}

	public String getAppsiteCode() {
        return appsiteCode;
    }

    public void setAppsiteCode(String appsiteCode) {
        this.appsiteCode = appsiteCode == null ? null : appsiteCode.trim();
    }

    public String getAppsiteName() {
        return appsiteName;
    }

    public void setAppsiteName(String appsiteName) {
        this.appsiteName = appsiteName == null ? null : appsiteName.trim();
    }

    public String getAppsitePicUrl() {
        return appsitePicUrl;
    }

    public void setAppsitePicUrl(String appsitePicUrl) {
        this.appsitePicUrl = appsitePicUrl == null ? null : appsitePicUrl.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
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