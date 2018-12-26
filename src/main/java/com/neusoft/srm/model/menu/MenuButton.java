package com.neusoft.srm.model.menu;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class MenuButton {
    private String buttonCode;

    private String buttonName;

    private String buttonPicUrl;

    private String buttonUrl;

    private String buttonStyle;

    private String menuCode;

    private String remark;

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
		return "MenuButton [buttonCode=" + buttonCode + ", buttonName=" + buttonName + ", buttonPicUrl=" + buttonPicUrl
				+ ", buttonUrl=" + buttonUrl + ", buttonStyle=" + buttonStyle + ", menuCode=" + menuCode + ", remark="
				+ remark + ", delFlag=" + delFlag + ", id=" + id + ", sortNo=" + sortNo + ", gmtCreate=" + gmtCreate
				+ ", createBy=" + createBy + ", gmtModified=" + gmtModified + ", lastModifiedBy=" + lastModifiedBy
				+ "]";
	}

	public String getButtonCode() {
        return buttonCode;
    }

    public void setButtonCode(String buttonCode) {
        this.buttonCode = buttonCode == null ? null : buttonCode.trim();
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName == null ? null : buttonName.trim();
    }

    public String getButtonPicUrl() {
        return buttonPicUrl;
    }

    public void setButtonPicUrl(String buttonPicUrl) {
        this.buttonPicUrl = buttonPicUrl == null ? null : buttonPicUrl.trim();
    }

    public String getButtonUrl() {
        return buttonUrl;
    }

    public void setButtonUrl(String buttonUrl) {
        this.buttonUrl = buttonUrl == null ? null : buttonUrl.trim();
    }

    public String getButtonStyle() {
        return buttonStyle;
    }

    public void setButtonStyle(String buttonStyle) {
        this.buttonStyle = buttonStyle == null ? null : buttonStyle.trim();
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode == null ? null : menuCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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