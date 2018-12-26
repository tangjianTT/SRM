package com.neusoft.srm.controller.navigation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.service.navigation.NavigationService;
import com.neusoft.srm.util.ServerResponse;

/**
 * @部门：上海软件研发中心 
 * @功能： AppSite,WebSite的新增/修改 
 * @描述： Navigation控制器 
 * @作成者：汤健
 * @作成时间：2018-12-10
 * @author TJ
 */
@RestController
@RequestMapping("/srm/navigation")
public class NavigationController {

	/**
	 *  系统导航实现接口类
	 */
	@Autowired
	private NavigationService navigationService;

	/**
	 * @部门：上海软件研发中心
	 * @功能： AppSite,WebSite得新增/修改  
	 * @描述： siteCode         site代码
	 *      siteName         site名称
	 *      sitePicUrl       site图片路径
	 *      siteUrl          site路径
	 *      siteType         site类型
	 * @返回值： AppSite,WebSite得新增/修改结果（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	@LogOperat(detail="修改信息",logType=LogType.ACCESS ,operationType=OperaLogType.UPDATE)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/saveSite")
	public ServerResponse saveSite(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取userCode
			String createBy = (String) request.getSession().getAttribute("userCode");
			// 获取siteCode
			String siteCode = request.getParameter("siteCode");
			// 获取siteName
			String siteName = request.getParameter("siteName");
			// 获取sitePicUrl
			String sitePicUrl = request.getParameter("sitePicUrl");
			// 获取siteUrl
			String siteUrl = request.getParameter("siteUrl");
			// 获取siteType
			String siteType = request.getParameter("siteType");
			// 调用系统导航实现类save方法实现新增或者修改
			navigationService.save(siteCode, sitePicUrl, siteName, siteUrl, siteType, createBy);
			return ServerResponse.createBySuccessMessage("操作成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作失败");
		}
	}
}
