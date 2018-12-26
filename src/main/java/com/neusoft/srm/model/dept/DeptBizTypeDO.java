package com.neusoft.srm.model.dept;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.neusoft.srm.util.AutoProduceCode;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期：  2018年12月11日
 * @功能描述：业务关系类
 */
@Repository
public class DeptBizTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	/**部门编码*/
	private String deptCode;
	/**部门业务关系编码*/
	private String bizTypeCode;
	/**废弃状态*/
	private Integer delFlag;
	/**id*/
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

	public DeptBizTypeDO() {
		super();
	}

	public DeptBizTypeDO(DeptDO deptDO) {
		//id生成器
		AutoProduceCode autoProduceCode = new AutoProduceCode();
		this.deptCode=deptDO.getDeptCode();
		this.delFlag=0;
		this.id = autoProduceCode.produceCode();
		this.sortNo=0;
		this.gmtCreate = deptDO.getGmtCreate();
		this.createBy = deptDO.getCreateBy();
		this.gmtModified = deptDO.getGmtModified();
		this.lastModifiedBy = deptDO.getLastModifiedBy();
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode == null ? null : deptCode.trim();
	}

	public String getBizTypeCode() {
		return bizTypeCode;
	}

	public void setBizTypeCode(String bizTypeCode) {
		this.bizTypeCode = bizTypeCode == null ? null : bizTypeCode.trim();
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
		return "DeptBizTypeDO [deptCode=" + deptCode + ", bizTypeCode=" + bizTypeCode + ", delFlag=" + delFlag + ", id="
				+ id + ", sortNo=" + sortNo + ", gmtCreate=" + gmtCreate + ", createBy=" + createBy + ", gmtModified="
				+ gmtModified + ", lastModifiedBy=" + lastModifiedBy + "]";
	}
}