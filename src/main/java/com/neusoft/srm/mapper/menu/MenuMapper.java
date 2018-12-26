package com.neusoft.srm.mapper.menu;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.neusoft.srm.model.menu.Menu;

@Mapper
public interface MenuMapper {
	/**
	 * 部门：上海软件研发中心
	 * 功能：查询所有菜单信息
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	List<Map<String, String>> getAllMenu();
	/**
	 * 部门：上海软件研发中心
	 * 功能：
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	int insertMenu(@Param("menu") Menu menu);
	/**
	 * 部门：上海软件研发中心
	 * 功能：
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	int updateMenu(@Param("menu") Menu menu);
	/**
	 * 部门：上海软件研发中心
	 * 功能：
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	int deleteMenu(@Param("menuCode")String menuCode,@Param("operatorCode")String operatorCode);
	/**
	 * 部门：上海软件研发中心
	 * 功能：当type=1时，查找父菜单下的子菜单的最大的AuthCode,当新增菜单时，authCode+1
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	String findMaxAuthCodeByparentMenuCode(@Param("parentMenuCode")String parentMenuCode);
	/**
	 * 部门：上海软件研发中心
	 * 功能：当type=1时，查找父菜单下的子菜单的最大的SortNo,当新增菜单时，SortNo+1
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	int findMaxSortNoByparentMenuCode(@Param("parentMenuCode")String parentMenuCode);
	/**
	 * 部门：上海软件研发中心
	 * 功能：当type=2时，查找目录最大的SortNo,当新增目录时，SortNo+1
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	int findMaxParentSortNo(int type);
}
