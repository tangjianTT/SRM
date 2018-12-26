package com.neusoft.srm.mapper.navigation;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.navigation.AppSiteDO;
import com.neusoft.srm.model.navigation.WebSiteDO;

/**
 * @部门：上海软件研发中心
 * @功能：  AppSite/WebSite的新增/修改操作
 * @描述：NavigationMapper
 * @作成者：汤健 
 * @作成时间：2018-12-12
 * @author TJ
 */
@Mapper
public interface NavigationMapper {

	/**
	 * @部门：上海软件研发中心
	 * @功能：   AppSite的修改
	 * @描述：appSiteDO   appSite对象
	 * @返回值：>0 表示修改成功 <0 表示未修改
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	public int updateAppSite(@Param(value = "appSiteDO") AppSiteDO appSiteDO);

	/**
	 * @部门：上海软件研发中心
	 * @功能：   WebSite的修改
	 * @描述：webSiteDO   webSite对象
	 * @返回值：>0 表示修改成功 <0 表示未修改
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	public int updateWebSite(@Param(value = "webSiteDO")WebSiteDO webSiteDO);

	/**
	 * @部门：上海软件研发中心
	 * @功能：   AppSite的新增
	 * @描述：appSiteDO   appSite对象
	 * @返回值：>0 表示新增成功 <0 表示未新增
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	public int insertAppSite(@Param(value = "appSiteDO")AppSiteDO appSiteDO);
	
	/**
	 * @部门：上海软件研发中心
	 * @功能：  WebSite的新增
	 * @描述：webSiteDO   webSite对象
	 * @返回值：>0 表示新增成功 <0 表示未新增
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	public int insertWebSite(@Param(value = "webSiteDO") WebSiteDO webSiteDO);
	
}
