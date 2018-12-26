package com.neusoft.srm.mapper.role;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.neusoft.srm.model.menu.MenuButton;
import com.neusoft.srm.model.role.RoleMenuAccredit;

   public interface RoleMenuBtnMapper {
	    /**
	      * 
	      * @部门：上海软件研发中心
	      * @功能：获取所有按钮信息
	      * @描述：参数 菜单代码  menuCode
	      * @作成者：王高亮
	      * @author:WGL
	      * @作成时间：2018年12月22日
	      */
      List<Map<String,String >> getAllButton(@Param("menuCode")String menuCode);
        /**
	      * 
	      * @部门：上海软件研发中心
	      * @功能：查找当前角色的菜单按钮
	      * @描述：参数  角色代码 roleCode  菜单代码 menuCode
	      * @作成者：王高亮
	      * @author:WGL
	      * @作成时间：2018年12月22日
	      */
      List<MenuButton> findMenuButByRoleCode(@Param("roleCode")String roleCode,@Param("menuCode")String menuCode);
        /**
	      * 
	      * @部门：上海软件研发中心
	      * @功能：逻辑删除角色对应的菜单信息
	      * @描述：参数  角色代码 roleCode  操作人代码 loginCode
	      * @作成者：王高亮
	      * @author:WGL
	      * @作成时间：2018年12月22日
	      */
      int updateRoleMenu(@Param("roleCode")String roleCode,@Param("loginCode")String loginCode);
        /**
	      * 
	      * @部门：上海软件研发中心
	      * @功能：新增角色对应的菜单信息
	      * @描述：参数  角色代码 roleCode  操作人代码 loginCode  菜单代码数组  menuList
	      * @作成者：王高亮
	      * @author:WGL
	      * @作成时间：2018年12月22日
	      */
      int insertRoleMenu(@Param("roleCode")String roleCode,@Param("loginCode")String loginCode,
    		                     @Param("menuList")String[] menuList);
        /**
	      * 
	      * @部门：上海软件研发中心
	      * @功能：逻辑删除角色对应的菜单下的按钮
	      * @描述：参数  角色代码 roleCode  操作人代码 loginCode  菜单代码数组  menuCode
	      * @作成者：王高亮
	      * @author:WGL
	      * @作成时间：2018年12月22日
	      */
      int updateRoleMenuButton(@Param("roleCode")String roleCode,@Param("loginCode")String loginCode,
    		                    @Param("menuCode")String [] menuCode);
        /**
	      * 
	      * @部门：上海软件研发中心
	      * @功能：逻辑删除角色对应的菜单下的按钮
	      * @描述：参数  角色代码 roleCode  操作人代码 loginCode  菜单按钮数组  menuButton
	      * @作成者：王高亮
	      * @author:WGL
	      * @作成时间：2018年12月22日
	      */
      int insertRoleMenuButton(@Param("roleCode")String roleCode,@Param("loginCode")String loginCode,
    		                   @Param("menuButton")List<RoleMenuAccredit> menuButton);
}
