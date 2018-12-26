package com.neusoft.srm.service.dict;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.model.dict.DictMainDO;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月17日
 * @功能描述：字典主表服务层
 */
public interface DictMainService {
	/**
	 * @部门：上海软件研发中心
	 * @功能：通过条件查询所有字典值
	 * @描述：lableKey	下拉框编码
	 * 	  	 lableName	下拉框名称
	 * 	  	 pageNo		页码		默认1页
	 *   	 PageSize	分页跨度 	默认 10条/页
	 * @返回值：
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	PageInfo<DictMainDO> queryMainDictByCond(String lableKey, String lableName, String pageNo, String pageSize);

	/**
	 * @部门：上海软件研发中心
	 * @功能：通过主字典编码查询主字典值
	 * @描述：dictMainCode	主字典编码值
	 * @返回值：装载DictMainDO对象 主字典数据
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	DictMainDO queryOneMainDictByDictMainCode(String dictMainCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：增加或修改主字典信息
	 * @描述：dictMainDO 主字典DO对象
	 *    	 userCode	 操作人编码
	 * @返回值：增加或修改 主字典数据
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	Integer addOrModifyDictMain(DictMainDO dictMainDO, String userCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：批量删除主字典数据 通过主字典编码集合
	 * @描述：dictMainCodeList	主字典编码 数据拼接 
	 *       userCode 			操作人
	 * @返回值：Integer			删除数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	Integer delBatchDictMainByDictMainCodeList(String dictMainCodeList, String userCode);

}
