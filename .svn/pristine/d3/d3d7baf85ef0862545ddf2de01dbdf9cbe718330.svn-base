package com.neusoft.srm.mapper.dict;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.dict.DictMainDO;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期：2018年12月17日
 * @功能描述：字典主表Mapper
 */
@Mapper
public interface DictMainDOMapper {
	/**
	 * @部门：上海软件研发中心
	 * @功能：按照条件查询所有主字典数据
	 * @描述： lableKey	下拉框编码
	 *    	  lableName	下拉框名称
	 * @返回值：List集合 装载DictMainDO对象，  主字典信息集合
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	List<DictMainDO> findAllMainDictByCond(@Param("lableKey") String lableKey, @Param("lableName") String lableName);

	/**
	 * @部门：上海软件研发中心
	 * @功能：通过主编码查询一条主字典数据
	 * @描述：dictMainCode	主字典编码值
	 * @返回值：装载DictMainDO对象 主字典数据
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	DictMainDO findOneMainDiceByDictMainCode(@Param("dictMainCode") String dictMainCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：插入主字典数据
	 * @描述：dictMainDO		主字典对象
	 * 	  	 userCode		操作人
	 * @返回值：Integer		插入数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	Integer insertDictMain(@Param("dictMainDO") DictMainDO dictMainDO, @Param("userCode") String userCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：更新主字典数据
	 * @描述：dictMainDO		主字典对象
	 * 	 	 userCode		操作人
	 * @返回值：Integer  		插入数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	Integer updateDictMain(@Param("dictMainDO") DictMainDO dictMainDO, @Param("userCode") String userCode);

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：通过主字典编码数组 批量删除主字典
	 * @描述：dictMainCodeAy	主字典编码数组
	 *       userCode		操作人
	 * @返回值：Integer		批量删除数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	Integer delBatchDictMainByDictMainCodeAy(@Param("dictMainCodeAy") String[] dictMainCodeAy,
			@Param("userCode") String userCode);
}