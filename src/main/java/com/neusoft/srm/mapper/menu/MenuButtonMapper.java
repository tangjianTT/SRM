package com.neusoft.srm.mapper.menu;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.neusoft.srm.model.menu.MenuButton;

@Mapper
public interface MenuButtonMapper {
	/**
	 * 部门：上海软件研发中心
	 * 功能：查询所有菜单对应的按钮信息
	 * 描述：
	 * 返回值：响应信息值
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
    List<MenuButton> findAllMenubutton(@Param("menuCode") String menuCode);
    /**
	 * 部门：上海软件研发中心
	 * 功能：添加菜单按钮
	 * 描述：
	 * 返回值：响应信息值
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
    int insertMenubutton(@Param("menuButton") MenuButton menuButton);
    /**
	 * 部门：上海软件研发中心
	 * 功能：修改菜单按钮
	 * 描述：
	 * 返回值：响应信息值
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
    int updateMenubutton(@Param("menuButton") MenuButton menuButton);
    /**
   	 * 部门：上海软件研发中心
   	 * 功能：逻辑删除菜单按钮
   	 * 描述：
   	 * 返回值：响应信息值
   	 * 作成者：王高亮
   	 * 作成时间：2018/12/13
   	 */
    int deleteMenubutton(@Param("operatorCode") String operatorCode,
    		             @Param("buttonCodes") String[] buttonCode);
    /**
   	 * 部门：上海软件研发中心
   	 * 功能：逻辑删除角色菜单按钮关联表
   	 * 描述：
   	 * 返回值：响应信息值
   	 * 作成者：王高亮
   	 * 作成时间：2018/12/13
   	 */
    int deleteRoleMenuButton(@Param("operatorCode") String operatorCode,
                             @Param("buttonCode") String buttonCode);
}