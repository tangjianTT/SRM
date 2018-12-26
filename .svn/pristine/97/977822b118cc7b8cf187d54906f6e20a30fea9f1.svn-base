package com.neusoft.srm.model.dict;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月18日
 * @功能描述：字典主表 封装类
 */
@Repository
public class DictMainDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String dictMainCode;

	private String id;

	private String lableKey;

	private String lableName;

	private Integer sortNo;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date gmtCreate;

	private String createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date gmtModified;

	private String lastModifiedBy;

	private String delFlag;

	private String remark;

	private String txt1;

	private String txt2;

	public String getDictMainCode() {
		return dictMainCode;
	}

	public void setDictMainCode(String dictMainCode) {
		this.dictMainCode = dictMainCode == null ? null : dictMainCode.trim();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getLableKey() {
		return lableKey;
	}

	public void setLableKey(String lableKey) {
		this.lableKey = lableKey == null ? null : lableKey.trim();
	}

	public String getLableName() {
		return lableName;
	}

	public void setLableName(String lableName) {
		this.lableName = lableName == null ? null : lableName.trim();
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

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag == null ? null : delFlag.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public String getTxt1() {
		return txt1;
	}

	public void setTxt1(String txt1) {
		this.txt1 = txt1 == null ? null : txt1.trim();
	}

	public String getTxt2() {
		return txt2;
	}

	public void setTxt2(String txt2) {
		this.txt2 = txt2 == null ? null : txt2.trim();
	}

	@Override
	public String toString() {
		return "DictMainDO [dictMainCode=" + dictMainCode + ", id=" + id + ", lableKey=" + lableKey + ", lableName="
				+ lableName + ", sortNo=" + sortNo + ", gmtCreate=" + gmtCreate + ", createBy=" + createBy
				+ ", gmtModified=" + gmtModified + ", lastModifiedBy=" + lastModifiedBy + ", delFlag=" + delFlag
				+ ", remark=" + remark + ", txt1=" + txt1 + ", txt2=" + txt2 + "]";
	}
}