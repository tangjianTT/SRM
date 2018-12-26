package com.neusoft.srm.service.role.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.mapper.menu.MenuMapper;
import com.neusoft.srm.mapper.role.RoleMapper;
import com.neusoft.srm.model.common.Tree;
import com.neusoft.srm.model.common.TreeState;
import com.neusoft.srm.model.menu.Menu;
import com.neusoft.srm.model.post.Post;
import com.neusoft.srm.model.role.Role;
import com.neusoft.srm.service.role.RoleService;
import com.neusoft.srm.util.AutoProduceCode;

@Service
@Transactional(rollbackFor= {Exception.class,RuntimeException.class})
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private MenuMapper menuMapper;
	/**
	 * 部门：上海软件研发中心
	 * 功能：查询所有角色信息，同时查询角色名称对应的角色信息
	 * 描述：参数 roleName 角色名称
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	@Override
	public PageInfo<Role> getListRole(String roleName, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Role> roleList = roleMapper.findAllRole(roleName);
		//获得分页结果对象
		PageInfo<Role> pageInfo = new PageInfo<>(roleList);
		return pageInfo;
	}
	/**
	 * 部门：上海软件研发中心
	 * 功能：新增，修改角色信息
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	@Override
	public int saveRole(Role role,String loginCode) {
		role.setCreateBy(loginCode);
		//判断role的roleCode是否为空，空则新增操作，非空则修改操作
		if (null == role.getRoleCode()) {
			//获取新的角色Code
			AutoProduceCode produceCode = new AutoProduceCode();
			String roleCode = produceCode.produceCode();
			role.setRoleCode(roleCode);
			int returnMsg = roleMapper.insertRole(role);
			return returnMsg;
		}else {
			int returnMsg = roleMapper.updateRole(role,loginCode);
			return returnMsg;
		}
	}
	/**
	 * 部门：上海软件研发中心
	 * 功能：删除角色信息
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	@Override
	public int removeRole(String roleCode,String loginCode) {
		String[] roleCodeList = roleCode.split(",");
		//删除返回的行数
		int Count = roleMapper.deleteRole(roleCodeList, loginCode);
		return Count;
	}
	/**
	 * 部门：上海软件研发中心
	 * 功能：查询所有岗位信息
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	@Override
	public PageInfo<Post> getListPost(int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Post> postList = roleMapper.findPostList();
		//获得分页岗位信息
		PageInfo<Post> pageInfo = new PageInfo<>(postList);
		return pageInfo;
	}
	/**
	 * 部门：上海软件研发中心
	 * 功能：查询角色对应的岗位信息
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	@Override
	public List<Post> getPostByRoleCode(String roleCode) {
		List<Post> list = roleMapper.findPostsByRoleCode(roleCode);
		return list;
	}
	/**
	 * 部门：上海软件研发中心
	 * 功能：角色岗位授权
	 * 描述：
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	@Override
	public int changeRolePost(String loginCode, String roleCode, String postCode) {
		//把postCode拆分成String数组
		String[] postCodeArray = postCode.split(",");
		//先把当前角色岗位设为无效
		roleMapper.updateRolePost(roleCode, loginCode);
		//给当前角色岗位授权
			int count = roleMapper.changeRolePost(loginCode,roleCode, postCodeArray);
		       return count;
	}
	
	@Override
	public Tree getAllMenu(String menuRoot,String roleCode) {
		List<Map<String, String>> menuList = menuMapper.getAllMenu();
		Tree rootTree = new Tree();
		initTree(rootTree, menuList, menuRoot, roleCode);
		return rootTree;
	}

	private void initTree(Tree rootTree, List<Map<String, String>> allMenus, String selfCode,String roleCode) {
		Iterator<Map<String, String>> menuIterator = allMenus.iterator();
		while (menuIterator.hasNext()) {
			Map<String, String> tmp = menuIterator.next();
			// 初始化自身节点
			if (tmp.get("MENU_CODE").equals(selfCode)) {
				menuToTree(tmp, rootTree,roleCode);
			} else if (tmp.get("PARENT_MENU_CODE").equals(selfCode)) {
				// 初始化子节点
				Tree children = new Tree();
				menuToTree(tmp, children,roleCode);
				if (null != children.getId()) {
					if (null == rootTree.getChildren()) {
						rootTree.setChildren(new ArrayList<Tree>());
					}
					rootTree.getChildren().add(children);
				}
				// 递归
				initTree(children, allMenus, tmp.get("MENU_CODE"),roleCode);
			}
		}
	}

	private void menuToTree(Map<String, String> menu, Tree tree,String roleCode) {
		tree.setId(menu.get("MENU_CODE"));
		tree.setLabel(menu.get("MENU_NAME"));
		tree.setAttributes(menu);
		TreeState state = new TreeState();
		//获得当前角色Code所能操作的菜单权限
		List<Menu> roleMenu = roleMapper.findMenuByRole(roleCode);
		for(Menu m:roleMenu) {
		if (null != menu.get("MENU_CODE") && m.getMenuCode().equals(menu.get("MENU_CODE"))) {
			state.setChecked(true);
		}
		if (null != menu.get("SELECTED") && "Y".equals(menu.get("SELECTED"))) {
			state.setSelected(true);
		}
		tree.setState(state);
		}
	}
	

}
