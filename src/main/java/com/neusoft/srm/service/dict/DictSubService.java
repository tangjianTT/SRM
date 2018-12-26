package com.neusoft.srm.service.dict;

import java.util.List;

import com.neusoft.srm.model.dict.DictSubDO;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月18日
 * @功能描述：子字典服务接口
 */
public interface DictSubService {
	/**
	 * @部门：上海软件研发中心
	 * @功能：查询父字典对应的子字典所有值
	 * @描述：dictMainCode	主字典编码
	 * @返回值：List集合 装载DictSubDO对象   子字典集合
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	List<DictSubDO> querySubDictListByDictMainCode(String dictMainCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：通过子字典编码查询子字典值
	 * @描述：dictSubCode	子字典编码
	 * @返回值： 装载DictSubDO对象	子字典对象
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	DictSubDO querySubDictListByDictSubCode(String dictSubCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：新增或修改子字典
	 * @描述：dictSub 子字典DO对象
	 *    	 userCode	 操作人编码
	 * @返回值：增加或修改主字典数据
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	Integer addOrModifyDictSub(DictSubDO dictSub, String userCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：批量删除子字典数据 通过子字典编码集合
	 * @描述：dictMainCodeList	子字典编码 数据拼接 
	 *       userCode 			操作人
	 * @返回值：Integer			删除数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	Integer delBatchDictSubByDictSubCodeList(String dictSubCodeList, String userCode);

}
