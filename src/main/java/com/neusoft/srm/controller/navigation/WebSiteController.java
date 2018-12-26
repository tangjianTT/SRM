package com.neusoft.srm.controller.navigation;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.navigation.WebSiteDO;
import com.neusoft.srm.service.navigation.WebSiteService;
import com.neusoft.srm.util.ServerResponse;

/**
 * @部门：上海软件研发中心 
 * @功能： WebSite的查询（条件查询）,删除（假删） 
 * @描述： WebSite控制器 
 * @作成者：汤健
 * @作成时间：2018-12-10
 * @author TJ
 */
@RestController
@RequestMapping("/srm/webSite")
public class WebSiteController {

	/**
	 *  WebSite实现接口类
	 */
	@Autowired
	private WebSiteService webSiteService;

	/**
	 * @部门：上海软件研发中心
	 * @功能： WebSite的分页查询（条件查询） 
	 * @描述： webSiteName    web名称
	 *      pageNo         页数
	 *      pageSize       页面大小
	 * @返回值：WebSite查询结果（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	@LogOperat(detail="查询WebSite信息",logType=LogType.ACCESS ,operationType=OperaLogType.SELECT)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getCodeList")
	public ServerResponse getCodeList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "10", required = false) int pageSize) {
		try {
			// 获取web名称
			String webSiteName = request.getParameter("webSiteName");
			// 调用webSite实现类getList方法获取查询/条件查询后得分页参数，List集合装载
			PageInfo<WebSiteDO> page = webSiteService.getList(webSiteName, pageNo, pageSize);
			// 调用webSite实现类countWebSite方法统计查询/条件查询后得总数

			Map<String, Object> map = new HashMap<>(0);
			map.put("totalCount", page.getTotal());
			map.put("pageTotalCount", page.getPages());
			map.put("siteList", page.getList());
			return ServerResponse.createBySuccesss(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("查询失败");
		}
	}
	
	/**
	 * @部门：上海软件研发中心
	 * @功能： WebSite的删除（假删） 
	 * @描述： userCode       用户代码
	 *      websiteCode    websiteCode代码  
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	@LogOperat(detail="删除WebSite",logType=LogType.ACCESS ,operationType=OperaLogType.DELETE)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/deleteSite")
	public ServerResponse deleteSite(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String userCode = (String) session.getAttribute("userCode");
		String websiteCode = request.getParameter("websiteCode");
		System.out.println(websiteCode);
		if (webSiteService.delete(userCode, websiteCode) > 0) {
			return ServerResponse.createBySuccessMessage("删除成功");
		}
		return ServerResponse.createByErrorCodeMessage(1, "删除失败");
	}
}
