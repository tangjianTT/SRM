package com.neusoft.srm.model.dept;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月7日
 * @功能描述：部门封装类
 */
@Repository
public class DeptDO implements Serializable {
	private static final long serialVersionUID = 1L;
	/**部门编码*/
	private String deptCode;
	/**部门名称*/
	private String deptName;
	/**部门简称*/
	private String deptNameJ;
	/**父类部门编码*/
	private String parentDeptCode;
	/**部门职能范围编码*/
	private String authCode;
	/**部门状态编码*/
	private String deptTypeCode;
	/**备注*/
	private String remark;
	/**作废标记*/
	private Integer delFlag;
	/**部门id*/
	private String id;
	/**序号*/
	private Integer sortNo;
	/**创建时间*/
	private Date gmtCreate;
	/**创建人*/
	private String createBy;
	/**更新时间*/
	private Date gmtModified;
	/**更新人*/
	private String lastModifiedBy;
	/**业务类型集合*/
	private List<BizTypeDO> bizTypeList;
	/**部门类型类*/
	private DeptTypeDO deptType;
	/**子部门信息*/
	List<DeptDO> deptChildList;

	public DeptDO() {
		super();
	}

	public DeptDO(String deptCode, String deptName, String deptNameJ, String parentDeptCode, String authCode,
			String deptTypeCode, String remark, Integer delFlag, String id, Integer sortNo, Date gmtCreate,
			String createBy, Date gmtModified, String lastModifiedBy) {
		super();
		this.deptCode = deptCode;
		this.deptName = deptName;
		this.deptNameJ = deptNameJ;
		this.parentDeptCode = parentDeptCode;
		this.authCode = authCode;
		this.deptTypeCode = deptTypeCode;
		this.remark = remark;
		this.delFlag = delFlag;
		this.id = id;
		this.sortNo = sortNo;
		this.gmtCreate = gmtCreate;
		this.createBy = createBy;
		this.gmtModified = gmtModified;
		this.lastModifiedBy = lastModifiedBy;
	}

	
	

	public List<DeptDO> getDeptChildList() {
		return deptChildList;
	}

	public void setDeptChildList(List<DeptDO> deptChildList) {
		this.deptChildList = deptChildList;
	}

	public List<BizTypeDO> getBizTypeList() {
		return bizTypeList;
	}

	public void setBizTypeList(List<BizTypeDO> bizTypeList) {
		this.bizTypeList = bizTypeList;
	}

	public DeptTypeDO getDeptType() {
		return deptType;
	}

	public void setDeptType(DeptTypeDO deptType) {
		this.deptType = deptType;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode == null ? null : deptCode.trim();
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName == null ? null : deptName.trim();
	}

	public String getDeptNameJ() {
		return deptNameJ;
	}

	public void setDeptNameJ(String deptNameJ) {
		this.deptNameJ = deptNameJ == null ? null : deptNameJ.trim();
	}

	public String getParentDeptCode() {
		return parentDeptCode;
	}

	public void setParentDeptCode(String parentDeptCode) {
		this.parentDeptCode = parentDeptCode == null ? null : parentDeptCode.trim();
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode == null ? null : authCode.trim();
	}

	public String getDeptTypeCode() {
		return deptTypeCode;
	}

	public void setDeptTypeCode(String deptTypeCode) {
		this.deptTypeCode = deptTypeCode == null ? null : deptTypeCode.trim();
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

	@Override
	public String toString() {
		return "DeptDO [deptCode=" + deptCode + ", deptName=" + deptName + ", deptNameJ=" + deptNameJ
				+ ", parentDeptCode=" + parentDeptCode + ", authCode=" + authCode + ", deptTypeCode=" + deptTypeCode
				+ ", remark=" + remark + ", delFlag=" + delFlag + ", id=" + id + ", sortNo=" + sortNo + ", gmtCreate="
				+ gmtCreate + ", createBy=" + createBy + ", gmtModified=" + gmtModified + ", lastModifiedBy="
				+ lastModifiedBy + ", deptType=" + deptType + "]";
	}

}