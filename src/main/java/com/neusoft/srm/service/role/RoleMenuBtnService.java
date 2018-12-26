package com.neusoft.srm.service.role;

import java.util.List;

import com.neusoft.srm.model.common.Tree;
import com.neusoft.srm.model.role.RoleMenuAccredit;

public interface RoleMenuBtnService  {
	
      public List<Tree> getAllMenuButton(String roleCode,String menuCode);
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
      public int saveRoleMenuBtn(String roleCode,String loginCode,
    		                     String menuList,List<RoleMenuAccredit> list,String buttonMenu);
}
