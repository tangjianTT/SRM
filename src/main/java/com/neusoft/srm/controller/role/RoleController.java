package com.neusoft.srm.controller.role;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.common.Tree;
import com.neusoft.srm.model.post.Post;
import com.neusoft.srm.model.role.Role;
import com.neusoft.srm.model.role.RoleMenuAccredit;
import com.neusoft.srm.service.role.RoleMenuBtnService;
import com.neusoft.srm.service.role.RoleService;
import com.neusoft.srm.util.ServerResponse;

/**
 * 
  * @部门：上海软件研发中心
  * @功能：角色管理模块功能
  * @描述：新增，修改，查询，删除，菜单授权，岗位授权
  * @作成者：王高亮
  * @author:WGL
  * @作成时间：2018年12月18日
 */
@RestController
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private RoleMenuBtnService roleMenuBtnService;
	/**
	  * 
	  * @部门：上海软件研发中心
	  * @功能：查找所有角色信息
	  * @描述  参数 角色名字 roleName  页码数  pageNum   页数类型  pageSize            
	  * @作成者：王高亮
	  * @author:WGL
	  * @作成时间：2018年12月18日
	  */
	@LogOperat(detail="查询角色",logType=LogType.ACCESS,operationType=OperaLogType.SELECT)
    @RequestMapping(value="getListRole")
	public ServerResponse getListRole(String roleName,int pageNum,int pageSize) {
    	  PageInfo<Role> pageInfo=null;
          pageInfo = roleService.getListRole(roleName,pageNum,pageSize);
          Map<String, Object> roleMap = new HashMap<>(0);
          roleMap.put("data", pageInfo.getList());
          roleMap.put("total", pageInfo.getTotal());
          roleMap.put("pages", pageInfo.getPages());
		return ServerResponse.createBySuccess("查询成功", roleMap);
	}
    
    /**
     * 
      * @部门：上海软件研发中心
      * @功能：新增，修改角色
      * @描述：参数  角色对象 role  操作人代码 loginCode
      * @作成者：王高亮
      * @author:WGL
      * @作成时间：2018年12月18日
     */
	@LogOperat(detail="新增，修改角色",logType=LogType.ACCESS,operationType=OperaLogType.UPDATE)
    @RequestMapping(value="saveRole")
	public ServerResponse saveRole(@ModelAttribute("role") Role role,String loginCode) {
    	int returnMsg = roleService.saveRole(role,loginCode);
    	if (returnMsg>0) {
			ServerResponse.createBySuccessMessage("操作成功");
		}
		return ServerResponse.createByErrorMessage("操作失败");
    }
    /**
     * 
      * @部门：上海软件研发中心
      * @功能：删除角色
      * @描述：参数 角色代码 roleCode 操作人代码 loginCode
      * @作成者：王高亮
      * @author:WGL
      * @作成时间：2018年12月18日
     */
	@LogOperat(detail="删除角色",logType=LogType.ACCESS,operationType=OperaLogType.DELETE)
    @RequestMapping(value="deleteRole")
	public ServerResponse removeRole(String roleCode,String loginCode) {
		if (null == roleCode) {
			return ServerResponse.createByErrorMessage("角色代码不能为空");
		}
		int count = roleService.removeRole(roleCode,loginCode);
        if(count>0) {
        	return ServerResponse.createBySuccessMessage("删除成功");
        }
		return ServerResponse.createByErrorMessage("删除失败");
    }
    /**
     * 
      * @部门：上海软件研发中心
      * @功能：岗位授权，查询所有岗位
      * @描述：参数  角色代码 roleCode  页码数  pageNum   页数类型  pageSize
      * @作成者：王高亮
      * @author:WGL
      * @作成时间：2018年12月18日
     */
	@LogOperat(detail="岗位授权,查询岗位",logType=LogType.ACCESS,operationType=OperaLogType.SELECT)
    @RequestMapping(value="getRolePost")
	public ServerResponse getListPost(String roleCode,@RequestParam(defaultValue="1")int pageNum,
    		                           @RequestParam(defaultValue="10")int pageSize) {
    	PageInfo<Post> pageInfo = null;
    	//获得所有岗位信息
    	pageInfo = roleService.getListPost(pageNum,pageSize);
    	//获得当前角色的岗位信息
    	List<Post> postByRoleCode = roleService.getPostByRoleCode(roleCode);
    	Map<String, Object> map = new HashMap<>(0);
    	map.put("postList", pageInfo.getList());
    	map.put("rolePost", postByRoleCode);
    	map.put("total", pageInfo.getTotal());
    	map.put("pages", pageInfo.getPages());
		return ServerResponse.createBySuccess("查询成功", map);
    }
    /**
     * 
      * @部门：上海软件研发中心
      * @功能：岗位授权，保存角色岗位授权信息
      * @描述：参数  操作人代码loginCode  角色代码  roleCode  岗位代码postCode
      * @作成者：王高亮
      * @author:WGL
      * @作成时间：2018年12月18日
     */
	@LogOperat(detail="角色岗位授权成功",logType=LogType.ACCESS,operationType=OperaLogType.UPDATE)
    @RequestMapping(value="changeRolePost")
	public ServerResponse changeRolePostController(String loginCode,String roleCode,String postCode) {
    	//返回授权成功的行数
    	int count = roleService.changeRolePost(loginCode,roleCode, postCode);
    	if (count>0) {
			return ServerResponse.createBySuccessMessage("操作成功");
		}
		return ServerResponse.createByErrorMessage("操作失败");
    }
    /**
     * 
      * @部门：上海软件研发中心
      * @功能：角色菜单授权
      * @描述：参数  角色代码  roleCode
      * @作成者：王高亮
      * @author:WGL
      * @作成时间：2018年12月20日
     */
	@LogOperat(detail="角色菜单授权",logType=LogType.ACCESS,operationType=OperaLogType.SELECT)
    @RequestMapping(value="getAllRoleMenu")
	public List<Tree> roleMenuAccreditController(String roleCode) {
    	      try {
				Tree tree = roleService.getAllMenu("0",roleCode);
               return tree.getChildren();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(this.getClass() + "--> getAllMenu() Exception:", e);
			}
    }
    /**
     * 
      * @部门：上海软件研发中心
      * @功能：角色菜单授权,获取角色菜单按钮
      * @描述：参数  角色代码  roleCode，菜单代码  menuCode
      * @作成者：王高亮
      * @author:WGL
      * @作成时间：2018年12月21日
     */
	@LogOperat(detail="菜单授权按钮查询",logType=LogType.ACCESS,operationType=OperaLogType.SELECT)
    @RequestMapping(value="getRoleButton")
	public List<Tree> getRoleMenuButtonController(String roleCode,String menuCode){
    	try {
			List<Tree> list = roleMenuBtnService.getAllMenuButton(roleCode, menuCode);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(this.getClass() + "--> getRoleMenuButton() Exception:", e);
		}
    }
    /**
     * 
      * @部门：上海软件研发中心
      * @功能：角色菜单授权,保存菜单信息
      * @描述：
      * @作成者：王高亮
      * @author:WGL
      * @作成时间：2018年12月20日
     */
	@LogOperat(detail="菜单授权成功",logType=LogType.ACCESS,operationType=OperaLogType.UPDATE)
    @RequestMapping(value="saveMenuAccredit",method=RequestMethod.POST)
	public ServerResponse saveMenuAccreditController(RoleMenuAccredit roleMenuAccredit) {
    	//获取角色代码
    	String roleCode = roleMenuAccredit.getRoleCode();
    	//获取操作人代码
    	String loginCode = roleMenuAccredit.getLoginCode();
    	//获取所有菜单信息
    	String menuList = roleMenuAccredit.getMenuList();
    	//获取菜单和按钮信息
    	String RoleMenuBtn = roleMenuAccredit.getRoleMenuBtu();
    	//获取修改的按钮对应的菜单代码
    	String buttonMenu = roleMenuAccredit.getButtons();
    	 //遍历json字符串去取值
        JSONArray json = JSONArray.parseArray(RoleMenuBtn);
        List<RoleMenuAccredit> list = JSONObject.parseArray(json.toJSONString(), RoleMenuAccredit.class);
		int count = roleMenuBtnService.saveRoleMenuBtn(roleCode,loginCode,menuList,list,buttonMenu);
        if (count>0) {
			return ServerResponse.createBySuccessMessage("操作成功");
		}else {
			return ServerResponse.createByErrorMessage("操作失败");
		}
    }
}
