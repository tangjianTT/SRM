package com.neusoft.srm.service.menu;

import com.neusoft.srm.model.common.Tree;
import com.neusoft.srm.model.menu.Menu;

public interface MenuService {
	/**
	 * 部门：上海软件研发中心
	 * 功能：获取树结构
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/13
	 */
	Tree getAllMenu(String menuRoot);
	/**
	 * 部门：上海软件研发中心
	 * 功能：新增，修改菜单
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/13
	 */
	int saveMenu(Menu menu,String loginUserCode);
	/**
	 * 部门：上海软件研发中心
	 * 功能：删除菜单
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/13
	 */
	int removeMenu(String menuCode,String operatorCode);
}
