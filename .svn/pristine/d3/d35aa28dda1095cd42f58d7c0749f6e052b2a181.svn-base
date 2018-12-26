package com.neusoft.srm.service.menu;

import java.util.List;

import com.neusoft.srm.model.menu.MenuButton;

public interface MenuButtonService {
	/**
	 * 部门：上海软件研发中心
	 * 功能：菜单模块，获取全部按钮信息
	 * 描述：参数  menuCode 菜单代码
	 *      查找菜单代码对应的按钮信息
	 * 返回值：返回菜单按钮的json串值
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
    List<MenuButton> getAllMenuButton(String menuCode);
    /**
	 * 部门：上海软件研发中心
	 * 功能：菜单模块，新增，修改按钮信息
	 * 描述：参数  menuCode 菜单代码
	 * 返回值：返回成功响应信息
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
    int saveMenuButton(MenuButton menuButton);
    
    int removeMenuButton(String operatorCode,String buttonCode);
}
