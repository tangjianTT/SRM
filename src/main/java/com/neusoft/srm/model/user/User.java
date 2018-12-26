package com.neusoft.srm.model.user;

/**
 * @部门：上海软件研发中心
 * @功能：用户模块功能操作
 * @描述：用户信息属性
 * @作成者：王高亮
 * @author WGL
 * @作成时间：2018/12/13
 */
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

    private String userCode;
    
    private String userAcnt;
    
    private String userName;
    
    private String userPwd;
    
    private Integer adminFlag;
    
    private String tel;
    
    private String phone;
    
    private String email;
    
    private String deptCode;
    
    private String deptTypeCode;
    
    private String userTypeCode;
    
    private Integer loginErrNo;
    
    private Integer freezeFlag;
    
    private String supplierCode;
    
    private Integer subacntFlag;
    
    private Integer supplierFlag;
    
    private Integer joinCarFlag;
    
    private Date changePwdDate;
    
    private Date lastLoginTime;
    
    private Integer sendMsgFlag;
    
    private Integer sendEmailFlag;
    
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
    
    private String roleName;
    
    private String postName;
    
    private String deptName;
	

    
	@Override
	public String toString() {
		return "User [userCode=" + userCode + ", userAcnt=" + userAcnt + ", userName=" + userName + ", userPwd="
				+ userPwd + ", adminFlag=" + adminFlag + ", tel=" + tel + ", phone=" + phone + ", email=" + email
				+ ", deptCode=" + deptCode + ", deptTypeCode=" + deptTypeCode + ", userTypeCode=" + userTypeCode
				+ ", loginErrNo=" + loginErrNo + ", freezeFlag=" + freezeFlag + ", supplierCode=" + supplierCode
				+ ", subacntFlag=" + subacntFlag + ", supplierFlag=" + supplierFlag + ", joinCarFlag=" + joinCarFlag
				+ ", changePwdDate=" + changePwdDate + ", lastLoginTime=" + lastLoginTime + ", sendMsgFlag="
				+ sendMsgFlag + ", sendEmailFlag=" + sendEmailFlag + ", remark=" + remark + ", delFlag=" + delFlag
				+ ", id=" + id + ", sortNo=" + sortNo + ", gmtCreate=" + gmtCreate + ", createBy=" + createBy
				+ ", gmtModified=" + gmtModified + ", lastModifiedBy=" + lastModifiedBy + ", roleName=" + roleName
				+ ", postName=" + postName + ", deptName=" + deptName + "]";
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserAcnt() {
        return userAcnt;
    }

    public void setUserAcnt(String userAcnt) {
        this.userAcnt = userAcnt == null ? null : userAcnt.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

    public Integer getAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(Integer adminFlag) {
        this.adminFlag = adminFlag;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    public String getDeptTypeCode() {
        return deptTypeCode;
    }

    public void setDeptTypeCode(String deptTypeCode) {
        this.deptTypeCode = deptTypeCode == null ? null : deptTypeCode.trim();
    }

    public String getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(String userTypeCode) {
        this.userTypeCode = userTypeCode == null ? null : userTypeCode.trim();
    }

    public Integer getLoginErrNo() {
        return loginErrNo;
    }

    public void setLoginErrNo(Integer loginErrNo) {
        this.loginErrNo = loginErrNo;
    }

    public Integer getFreezeFlag() {
        return freezeFlag;
    }

    public void setFreezeFlag(Integer freezeFlag) {
        this.freezeFlag = freezeFlag;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode == null ? null : supplierCode.trim();
    }

    public Integer getSubacntFlag() {
        return subacntFlag;
    }

    public void setSubacntFlag(Integer subacntFlag) {
        this.subacntFlag = subacntFlag;
    }

    public Integer getSupplierFlag() {
        return supplierFlag;
    }

    public void setSupplierFlag(Integer supplierFlag) {
        this.supplierFlag = supplierFlag;
    }

    public Integer getJoinCarFlag() {
        return joinCarFlag;
    }

    public void setJoinCarFlag(Integer joinCarFlag) {
        this.joinCarFlag = joinCarFlag;
    }

    public Date getChangePwdDate() {
        return changePwdDate;
    }

    public void setChangePwdDate(Date changePwdDate) {
        this.changePwdDate = changePwdDate;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getSendMsgFlag() {
        return sendMsgFlag;
    }

    public void setSendMsgFlag(Integer sendMsgFlag) {
        this.sendMsgFlag = sendMsgFlag;
    }

    public Integer getSendEmailFlag() {
        return sendEmailFlag;
    }

    public void setSendEmailFlag(Integer sendEmailFlag) {
        this.sendEmailFlag = sendEmailFlag;
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