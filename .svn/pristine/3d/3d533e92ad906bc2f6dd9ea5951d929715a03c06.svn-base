package com.neusoft.srm.mapper.role;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.menu.Menu;
import com.neusoft.srm.model.post.Post;
import com.neusoft.srm.model.role.Role;
/**
 * 
  * @部门：上海软件研发中心
  * @功能：
  * @描述：
  * @作成者：王高亮
  * @author:WGL
  * @作成时间：2018年12月18日
 */
@Mapper
public interface RoleMapper {
	/**
	 * 
	  * @部门：上海软件研发中心
	  * @功能：查询所有角色信息
	  * @描述：
	  * @作成者：王高亮
	  * @author:WGL
	  * @作成时间：2018年12月18日
	 */
   List<Role> findAllRole(@Param("roleName") String roleName);
   /**
    * 
     * @部门：上海软件研发中心
     * @功能：新增角色
     * @描述：
     * @作成者：王高亮
     * @author:WGL
     * @作成时间：2018年12月18日
    */
   int insertRole(@Param("role") Role role);
   /**
    * 
     * @部门：上海软件研发中心
     * @功能：修改角色
     * @描述：
     * @作成者：王高亮
     * @author:WGL
     * @作成时间：2018年12月18日
    */
   int updateRole(@Param("role") Role role,@Param("loginCode")String loginCode);
   /**
    * 
     * @部门：上海软件研发中心
     * @功能：逻辑删除角色
     * @描述：
     * @作成者：王高亮
     * @author:WGL
     * @作成时间：2018年12月18日
    */
   int deleteRole(@Param("roleCode") String[] roleCode,@Param("loginCode") String loginCode);
   /**
    * 
     * @部门：上海软件研发中心
     * @功能：查询所有岗位信息
     * @描述：
     * @作成者：王高亮
     * @author:WGL
     * @作成时间：2018年12月18日
    */
   List<Post> findPostList();
   /**
    * 
     * @部门：上海软件研发中心
     * @功能：查询当前角色对应的岗位信息
     * @描述：
     * @作成者：王高亮
     * @author:WGL
     * @作成时间：2018年12月18日
    */
   List<Post> findPostsByRoleCode(@Param("roleCode")String roleCode);
   
   /**
	 * @部门：上海软件研发中心
	 * @功能：查询所有岗位信息
	 * @描述：
	 * @作成者：王高亮
	 * @author:WGL
	 * @返回值：
	 * @作成时间：2018/12/16
	 */
   int changeRolePost(@Param("loginCode")String loginCode,@Param("roleCode")String roleCode,
		              @Param("postCode")String[] postCode);
   /**
	 * @部门：上海软件研发中心
	 * @功能：把当前岗位信息设置为无效
	 * @描述：
	 * @作成者：王高亮
	 * @author:WGL
	 * @返回值：
	 * @作成时间：2018/12/16
	 */
   void updateRolePost(String roleCode,String loginCode);
   
   /**
	 * @部门：上海软件研发中心
	 * @功能：查询所有菜单信息
	 * @描述：
	 * @作成者：王高亮
	 * @author:WGL
	 * @返回值：
	 * @作成时间：2018/12/21
	 */
	List<Map<String, String>> getRoleAllMenu();
	
	List<Menu> findMenuByRole(@Param("roleCode")String roleCode);
}
