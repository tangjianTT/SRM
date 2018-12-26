package com.neusoft.srm.service.menu.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neusoft.srm.mapper.menu.GetBtnByPostMapper;
import com.neusoft.srm.model.menu.MenuButton;
import com.neusoft.srm.service.menu.GetBtnByPostService;

@Service
public class GetBtnByPostServiceImpl implements GetBtnByPostService{
	@Autowired
	private GetBtnByPostMapper getBtnByPostMapper;
	/**
	 * 部门：上海软件研发中心
	 * 功能：查询所有角色信息，同时查询角色名称对应的角色信息
	 * 描述：参数 roleName 角色名称
	 * 作成者：王高亮
	 * 返回值：
	 * 作成时间：2018/12/16
	 */
	@Override
	public List<MenuButton> getMenuBtnByPost(String postCode, String menuCode) {
		List<MenuButton> findMenuBtnByPost = getBtnByPostMapper.findMenuBtnByPost(postCode, menuCode);
		return findMenuBtnByPost;
	}
}
