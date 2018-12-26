package com.neusoft.srm.mapper.dict;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.dict.DictSubDO;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期：  2018年12月17日
 * @功能描述： 子字典字表Mapper
 */
@Mapper
public interface DictSubDOMapper {

	/**
	 * @部门：上海软件研发中心
	 * @功能：通过主字典编码数组 批量删除子字典
	 * @描述：dictMainCodeAy	主字典编码数组
	 *       userCode		操作人
	 * @返回值：Integer		批量删除数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	Integer delBatchDictSubByDictMainCodeAy(@Param("dictMainCodeAy") String[] dictMainCodeAy,
			@Param("userCode") String userCode);

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：通过主字典编码查询子字典集合
	 * @描述：dictMainCode  主字典编码
	 * @返回值：List集合 装载DictSubDO对象   子字典集合
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	List<DictSubDO> selectSubDictListByDictMainCode(@Param("dictMainCode") String dictMainCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：通过子字典编码查询子字典集合
	 * @描述：dictSubCode 	子字典编码
	 * @返回值：DictSubDO对象   子字典数据
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	DictSubDO selectSubDictByDictSubCode(@Param("dictSubCode") String dictSubCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：插入子字典数据
	 * @描述：dictSubDO		子字典对象
	 * 	  	 userCode		操作人
	 * @返回值：Integer		插入数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	Integer insertDictSub(@Param("dictSub") DictSubDO dictSub, @Param("userCode") String userCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：更新子字典数据
	 * @描述：dictSub		子字典对象
	 * 	 	 userCode		操作人
	 * @返回值：Integer  		插入数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	Integer updateDictSub(@Param("dictSub") DictSubDO dictSub, @Param("userCode") String userCode);

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：通过子字典编码数组 批量删除子字典
	 * @描述：dictMainCodeAy	子字典编码数组
	 *       userCode		操作人
	 * @返回值：Integer		批量删除数量
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	Integer delBatchDictSubByDictSubCodeAy(@Param("dictSubCodeAy") String[] dictSubCodeAy,
			@Param("userCode") String userCode);
}