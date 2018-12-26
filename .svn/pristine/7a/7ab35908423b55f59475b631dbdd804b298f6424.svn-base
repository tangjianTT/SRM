package com.neusoft.srm.service.navigation.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.mapper.navigation.AppSiteMapper;
import com.neusoft.srm.model.navigation.AppSiteDO;
import com.neusoft.srm.service.navigation.AppSiteService;

/**
 * @部门：上海软件研发中心
 * @功能    AppSite的查询分页/条件查询分页,一个或多个AppSite的删除（假删）,查询/条件查询数据的总条数（除开删除标记为1）
 * @描述： AppSiteServiceImpl实现类
 * @作成者：汤健 
 * @作成时间：2018-12-12
 * @author TJ
 */
@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class AppSiteServiceImpl implements AppSiteService {

	@Autowired
	private AppSiteMapper appSiteMapper;
	
	/**
	 * @部门：上海软件研发中心
	 * @功能： 实现AppSite的查询分页/条件查询分页
	 * @描述： appSiteName    appSite名称
	 *      pageNo         页数
	 *      pageSize       页面大小
	 * @返回值：PageInfo<Map装载数据>
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	@Override
	public PageInfo<AppSiteDO> getList(String appSiteName, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNo, pageSize);
		List<AppSiteDO> appSiteList=new ArrayList<>();
		appSiteList=appSiteMapper.findList(appSiteName);
		return new PageInfo<>(appSiteList);
	}
	
	/**
	 * @部门：上海软件研发中心
	 * @功能：实现一个或多个AppSite的删除（假删）
	 * @描述：   userCode       用户代码
	 *       delDate       删除日期
	 *       appSiteCode    appSite代码  
	 * @返回值：>0成功假删一个或多个AppSite信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	@Override
	public int delete(String userCode,String appSiteCode) {
		String[] appSiteCodeAy=appSiteCode.split(",");
		return appSiteMapper.remove(userCode,appSiteCodeAy);
	}

}
