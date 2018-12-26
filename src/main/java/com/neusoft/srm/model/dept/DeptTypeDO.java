package com.neusoft.srm.model.dept;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;


/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月10日
 * @功能描述：部门类型封装类
 */
@Repository
public class DeptTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	/**部门类型编码*/
	private String deptTypeCode;
	/**部门类型名称*/
	private String deptTypeName;
	/**废弃状态*/
	private Integer delFlag;
	/**部门id*/
	private String id;
	/**序号*/
	private Integer sortNo;
	/**创建时间*/
	private Date gmtCreate;
	/**创建人*/
	private String createBy;
	/**修改时间*/
	private Date gmtModified;
	/**修改人*/
	private String lastModifiedBy;

	public String getDeptTypeCode() {
		return deptTypeCode;
	}

	public void setDeptTypeCode(String deptTypeCode) {
		this.deptTypeCode = deptTypeCode == null ? null : deptTypeCode.trim();
	}

	public String getDeptTypeName() {
		return deptTypeName;
	}

	public void setDeptTypeName(String deptTypeName) {
		this.deptTypeName = deptTypeName == null ? null : deptTypeName.trim();
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
		return "DeptTypeDO [deptTypeCode=" + deptTypeCode + ", deptTypeName=" + deptTypeName + ", delFlag=" + delFlag
				+ ", id=" + id + ", sortNo=" + sortNo + ", gmtCreate=" + gmtCreate + ", createBy=" + createBy
				+ ", gmtModified=" + gmtModified + ", lastModifiedBy=" + lastModifiedBy + "]";
	}
}