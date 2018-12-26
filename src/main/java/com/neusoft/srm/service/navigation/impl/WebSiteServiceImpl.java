package com.neusoft.srm.service.navigation.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.mapper.navigation.WebSiteMapper;
import com.neusoft.srm.model.navigation.WebSiteDO;
import com.neusoft.srm.service.navigation.WebSiteService;

/**
 * @部门：上海软件研发中心 
 * @功能: WebSite的查询分页/条件查询分页,一个或多个AppSite的删除（假删）,查询/条件查询数据的总条数（除开删除标记为1） 
 * @描述：WebSiteServiceImpl实现类 
 * @作成者：汤健 
 * @作成时间：2018-12-12
 * @author TJ
 */
@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class WebSiteServiceImpl implements WebSiteService {

	@Autowired
	private WebSiteMapper webSiteMapper;

	/**
	 * @部门：上海软件研发中心 
	 * @功能： 实现WebSite的查询分页/条件查询分页 
	 * @描述： webSiteName  webSite名称
	 *      webSite      名称 
	 *      pageNo       页数
	 *      pageSize     页面大小 
	 * @返回值：PageInfo<Map装载数据>
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	@Override
	public PageInfo<WebSiteDO> getList(String webSiteName, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNo, pageSize);
		List<WebSiteDO> webSiteList=new ArrayList<>();
		webSiteList=webSiteMapper.findList(webSiteName);
		return new PageInfo<>(webSiteList);
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能：实现一个或多个WebSite的删除（假删）
	 * @描述：   userCode       用户代码
	 *       delDate       删除日期
	 *       webSiteCode    webSite代码  
	 * @返回值：>0成功假删一个或多个AppSite信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	@Override
	public int delete(String userCode , String webSiteCode) {
		String[] webSiteCodeAy = webSiteCode.split(",");
		return webSiteMapper.remove(userCode, webSiteCodeAy);
	}

}
