package com.neusoft.srm.service.role;


import java.util.List;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.model.common.Tree;
import com.neusoft.srm.model.menu.Menu;
import com.neusoft.srm.model.menu.MenuButton;
import com.neusoft.srm.model.post.Post;
import com.neusoft.srm.model.role.Role;

public interface RoleService {
	/**
	 * 部门：上海软件研发中心
	 * 功能：查询所有角色信息
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
      PageInfo<Role> getListRole(String roleName,int pageNum,int pageSize);
      
      /**
  	 * 部门：上海软件研发中心
  	 * 功能：新增，修改角色信息
  	 * 描述：
  	 * 作成者：王高亮
  	 * 返回值：
  	 * 作成时间：2018/12/16
  	 */
      int saveRole(Role role,String loginCode);
      /**
  	 * 部门：上海软件研发中心
  	 * 功能：删除角色信息
  	 * 描述：
  	 * 作成者：王高亮
  	 * 返回值：
  	 * 作成时间：2018/12/16
  	 */
      int removeRole(String roleCode,String loginCode);
      /**
  	 * 部门：上海软件研发中心
  	 * 功能：查询所有岗位信息，进行分页处理
  	 * 描述：
  	 * 作成者：王高亮
  	 * 返回值：
  	 * 作成时间：2018/12/16
  	 */
      PageInfo<Post> getListPost(int pageNum,int pageSize);
      /**
  	 * 部门：上海软件研发中心
  	 * 功能：查询当前角色对应的岗位信息
  	 * 描述：
  	 * 作成者：王高亮
  	 * 返回值：
  	 * 作成时间：2018/12/16
  	 */
      List<Post> getPostByRoleCode(String roleCode);
      /**
    	 * 部门：上海软件研发中心
    	 * 功能：角色岗位授权
    	 * 描述：
    	 * 作成者：王高亮
    	 * 返回值：
    	 * 作成时间：2018/12/16
    	 */
      int changeRolePost(String loginCode,String roleCode,String postCode);
      
      Tree getAllMenu(String menuRoot,String roleCode);
      
      
}
