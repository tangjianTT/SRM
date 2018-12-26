package com.neusoft.srm.service.navigation.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.srm.mapper.navigation.NavigationMapper;
import com.neusoft.srm.model.navigation.AppSiteDO;
import com.neusoft.srm.model.navigation.WebSiteDO;
import com.neusoft.srm.service.navigation.NavigationService;
import com.neusoft.srm.util.AutoProduceCode;

/**
 * @部门：上海软件研发中心
 * @功能： AppSite,WebSite的新增/修改 
 * @描述： NavigationServiceImpl接口
 * @作成者：汤健 
 * @作成时间：2018-12-12
 * @author TJ
 */
@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class NavigationServiceImpl implements NavigationService {
 
	@Autowired
	private NavigationMapper navigationMapper;
	
	/**
	 * @部门：上海软件研发中心
	 * @功能： 实现AppSite,WebSite的新增/修改 
	 * @描述：   siteCode   site代码
     *       sitePicUrl site图片路径
     *       siteName   site名称
     *       siteUrl    site路径
     *       siteType   site类型
     *       createBy   创建人
	 * @作成者：汤健 
	 * @返回值：>0 新增/修改AppSite/WebSite信息, <=0表示未新增/修改AppSite/WebSite信息
	 * @作成时间：2018-12-12
	 */
	@Override
	public int save(String siteCode, String sitePicUrl, String siteName, String siteUrl, String siteType,
			String createBy) {
		// 判断siteCode是否未空值或不存在，若为真则表示做新增操作
		if ("".equals(siteCode) || "null".equals(siteCode) || siteCode==null) {
			// 判断传入类型，0代表是网站链接，1代表app链接,做网站链接的新增操作
			if ("0".equals(siteType)) {
				// 自动生成Code
				siteCode = new AutoProduceCode().produceCode();
				// 将信息封装进webSiteDO对象中
				WebSiteDO webSiteDO = webSiteSave(siteCode, sitePicUrl, siteName, siteUrl, createBy);
				webSiteDO.setCreateBy(createBy);
				return navigationMapper.insertWebSite(webSiteDO);
			}
			// 判断传入类型,0代表是网站链接，1代表app链接,做app链接的新增操作
			if ("1".equals(siteType)) {
				// 自动生成Code
				siteCode = new AutoProduceCode().produceCode();
				// 将信息封装进appSiteDO对象中
				AppSiteDO appSiteDO = appSiteSave(siteCode, sitePicUrl, siteName, createBy);
				return navigationMapper.insertAppSite(appSiteDO);
			}
		}
		// 若不为空值或不存在，则做修改操作,判断传入类型,0代表是网站链接，1代表app链接,做网站链接修改操作
		if ("0".equals(siteType)) {
			WebSiteDO webSiteDO = webSiteSave(siteCode, sitePicUrl, siteName, siteUrl, createBy);
			return navigationMapper.updateWebSite(webSiteDO);
		}
		// 若不为空值或不存在，则做修改操作,判断传入类型,0代表是网站链接，1代表app链接,做app链接修改操作
		if ("1".equals(siteType)) {
			AppSiteDO appSiteDO = appSiteSave(siteCode, sitePicUrl, siteName, createBy);
			return navigationMapper.updateAppSite(appSiteDO);
		}
		return 0;
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能： 实现AppSite的信息封装操作
	 * @描述：   siteCode   site代码
     *       sitePicUrl site图片路径
     *       siteName   site名称
     *       createBy   创建人
	 * @作成者：汤健 
	 * @返回值： 装载完信息的appSiteDO对象
	 * @作成时间：2018-12-12
	 */
	private AppSiteDO appSiteSave(String siteCode, String sitePicUrl, String siteName, String createBy) {
		AppSiteDO appSiteDO = new AppSiteDO();
		appSiteDO.setAppsiteCode(siteCode);
		appSiteDO.setAppsiteName(siteName);
		appSiteDO.setAppsitePicUrl(sitePicUrl);
		appSiteDO.setLastModifiedBy(createBy);
		appSiteDO.setCreateBy(createBy);
		return appSiteDO;
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能： 实现WebSite的信息封装操作
	 * @描述：   siteCode   site代码
     *       sitePicUrl site图片路径
     *       siteName   site名称
     *       siteUrl    site路径
     *       createBy   创建人
	 * @作成者：汤健 
	 * @返回值： 装载完信息的webSiteDO对象
	 * @作成时间：2018-12-12
	 */
	private WebSiteDO webSiteSave(String siteCode, String sitePicUrl, String siteName, String siteUrl,
			String createBy) {
		WebSiteDO webSiteDO = new WebSiteDO();
		webSiteDO.setWebsiteCode(siteCode);
		webSiteDO.setLastModifiedBy(createBy);
		webSiteDO.setWebsiteName(siteName);
		webSiteDO.setWebsitePicUrl(sitePicUrl);
		webSiteDO.setWebsiteUrl(siteUrl);
		return webSiteDO;
	}

}
