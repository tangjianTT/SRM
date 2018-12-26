package com.neusoft.srm.service.role.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neusoft.srm.mapper.role.RoleMenuBtnMapper;
import com.neusoft.srm.model.common.Tree;
import com.neusoft.srm.model.common.TreeState;
import com.neusoft.srm.model.menu.MenuButton;
import com.neusoft.srm.model.role.RoleMenuAccredit;
import com.neusoft.srm.service.role.RoleMenuBtnService;

@Service
public class RoleMenuBtnServiceImpl implements RoleMenuBtnService{
      @Autowired
      private RoleMenuBtnMapper roleMenuBtnMapper;
	@Override
	public List<Tree> getAllMenuButton(String roleCode,String menuCode) {
		List<Map<String, String>> buttonList = roleMenuBtnMapper.getAllButton(menuCode);
		Iterator<Map<String, String>> buttonIterator =buttonList.iterator();
		List<Tree> list = new ArrayList<>();
		int count = 0;
		while(buttonIterator.hasNext()) {
			Map<String, String> tmp = buttonIterator.next();
			Tree rootTree = new Tree();
			menuToTree(tmp,rootTree,roleCode,menuCode);
			list.add(rootTree);
			count++;
			if (count == buttonList.size()) {
				break;
			}
		}
		return list;
	}


	private void menuToTree(Map<String, String> button, Tree tree,String roleCode,String menuCode) {
		tree.setId(button.get("BUTTON_CODE"));
		tree.setLabel(button.get("BUTTON_NAME"));
		tree.setAttributes(button);
		TreeState state = new TreeState();
		//获得当前角色Code所能操作的菜单权限
		List<MenuButton> roleButton = roleMenuBtnMapper.findMenuButByRoleCode(roleCode,menuCode);
		for(MenuButton m:roleButton) {
		if (null != button.get("BUTTON_CODE") && m.getButtonCode().equals(button.get("BUTTON_CODE"))) {
			state.setChecked(true);
		}
		if (null != button.get("SELECTED") && "Y".equals(button.get("SELECTED"))) {
			state.setSelected(true);
		}
		tree.setState(state);
		}
	}

	/**
     * 
      * @部门：上海软件研发中心
      * @功能：角色菜单授权保存菜单按钮信息
      * @描述：参数  roleCode    角色代码
      *           loginCode   操作人代码
      *           menuList    菜单代码集合
      *           list        所操作的菜单和按钮信息
      *           buttonMenu  操作按钮所属的菜单代码
      * @作成者：王高亮
      * @author:WGL
      * @作成时间：2018年12月23日
     */
	@Override
	public int saveRoleMenuBtn(String roleCode, String loginCode, 
			                   String menuList, List<RoleMenuAccredit> list,String buttonMenu) {
		//逻辑删除当前角色菜单
		roleMenuBtnMapper.updateRoleMenu(roleCode, loginCode);
		 //把字符串拆分成数组
		 String[] menus = menuList.split(",");
		 //新增角色菜单
		 roleMenuBtnMapper.insertRoleMenu(roleCode, loginCode, menus);
		 String[] menuButtons = buttonMenu.split(",");
		 //逻辑删除当前角色对应菜单下的按钮
		 roleMenuBtnMapper.updateRoleMenuButton(roleCode, loginCode, menuButtons);
		 //新增角色菜单按钮
		 roleMenuBtnMapper.insertRoleMenuButton(roleCode, loginCode, list);
		return 0;
	}
}
