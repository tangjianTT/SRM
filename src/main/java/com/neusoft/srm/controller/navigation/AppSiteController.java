package com.neusoft.srm.controller.navigation;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.navigation.AppSiteDO;
import com.neusoft.srm.service.navigation.AppSiteService;
import com.neusoft.srm.util.ServerResponse;

/**
 * @部门：上海软件研发中心
 * @功能： AppSite的查询（条件查询）,删除（假删） 
 * @描述： AppSite控制器 
 * @作成者：汤健 
 * @作成时间：2018-12-10
 * @author TJ
 */
@RestController
@RequestMapping("/srm/appSite")
public class AppSiteController {
	/**
	 *  AppSite实现接口类
	 */
	@Autowired
	private AppSiteService appSiteService;

	/**
	 * @部门：上海软件研发中心
	 * @功能： AppSite的查询（条件查询） 
	 * @描述：appSiteName    app名称
	 *      pageNo         页数
	 *      pageSize       页面大小
	 * @返回值：AppSite查询结果（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	@LogOperat(detail="查询AppSite信息",logType=LogType.ACCESS ,operationType=OperaLogType.SELECT)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getCodeList")
	public ServerResponse getCodeList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "10", required = false) int pageSize) {
		// 获取app名称
		String appSiteName = request.getParameter("appSiteName");
		// 调用appSite实现类获取查询结果/条件查询分页得结果，List集合装载
		PageInfo<AppSiteDO> page = appSiteService.getList(appSiteName, pageNo, pageSize);
		// 调用appSite实现类统计总数（条件查询包括在内）
		Map<String, Object> map = new HashMap<>(0);
		map.put("totalCount", page.getTotal());
		map.put("pageTotalCount", page.getPages());
		map.put("siteList", page.getList());
		return ServerResponse.createBySuccesss(map);
	}
	

	/**
	 * @部门：上海软件研发中心
	 * @功能： AppSite的删除（假删） 
	 * @描述： userCode       用户代码
	 *      appsiteCode    appsite代码  
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	@LogOperat(detail="删除AppSite信息",logType=LogType.ACCESS ,operationType=OperaLogType.DELETE)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/deleteSite", method = RequestMethod.POST)
	public ServerResponse deleteSite(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取userCode，操作人信息
			HttpSession session = request.getSession();
			String userCode = (String) session.getAttribute("userCode");
			// 获取appsiteCode得信息，用于删除
			String appsiteCode = request.getParameter("appsiteCode");
			if (appSiteService.delete(userCode, appsiteCode) > 0) {
				return ServerResponse.createBySuccessMessage("删除成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("删除失败");
		}
		return null;
	}
}
