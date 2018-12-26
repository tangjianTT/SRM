package com.neusoft.srm.controller.menu;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.common.Tree;
import com.neusoft.srm.model.menu.Menu;
import com.neusoft.srm.service.menu.MenuService;
import com.neusoft.srm.util.ServerResponse;

/**
 * @部门：上海软件研发中心
 * @功能：菜单功能操作
 * @描述：菜单模块接口需要的controller
 * @作成者：王高亮
 * @author WGL
 * @作成时间：2018/12/13
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;
	/**
	 * @部门：上海软件研发中心
	 * @功能：查询所有菜单信息
	 * @描述：
	 * @作成者：王高亮
	 * @返回值：
	 * @author WGL
	 * @作成时间：2018/12/16
	 */
	@LogOperat(detail="获取菜单",logType=LogType.ACCESS,operationType=OperaLogType.SELECT)
	@RequestMapping("/getAllMenu")
	public List<Tree> getAllMenuController(){
		try {
			Tree resultMto = menuService.getAllMenu("0");
			return resultMto.getChildren();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(this.getClass() + "--> getAllMenu() Exception:", e);
		}
	}
	/**
	 * @部门：上海软件研发中心
	 * @功能：新增，修改菜单信息
	 * @描述：
	 * @作成者：王高亮
	 * @author WGL
	 * @返回值：
	 * @作成时间：2018/12/16
	 */
	@LogOperat(detail="新增，修改菜单",logType=LogType.ACCESS,operationType=OperaLogType.UPDATE)
  @RequestMapping("/saveMenu")
  public ServerResponse saveMenuController(@ModelAttribute("menu") Menu menu,HttpServletRequest request) {
	  //获取操作对象
	  String  loginUserCode = (String) request.getParameter("loginCode");
	  int returnMsg = menuService.saveMenu(menu,loginUserCode);
	  if (returnMsg>0) {
		return ServerResponse.createBySuccessMessage("操作成功");
	}
	return ServerResponse.createByErrorMessage("操作失败"); 
  }
  /**
	 * @部门：上海软件研发中心
	 * @功能：删除菜单
	 * @描述：
	 * @作成者：王高亮
	 * @author WGL
	 * @返回值：
	 * @作成时间：2018/12/16
	 */
   @LogOperat(detail="删除菜单",logType=LogType.ACCESS,operationType=OperaLogType.DELETE)
   @RequestMapping("/removeMenu")
   private ServerResponse removeMenuController(String menuCode,HttpServletRequest request) {
	 //获取操作人信息
	 String operatorCode  = (String) request.getSession().getAttribute("loginCode");
	 //判断menuCode不为空，执行操作
	  if (StringUtils.isNotBlank(menuCode)) {
		int returnMsg = menuService.removeMenu(menuCode,operatorCode);
		if (returnMsg>0) {
			return ServerResponse.createBySuccessMessage("删除成功");
		}else {
			return ServerResponse.createByErrorMessage("删除失败");
		}
	}else {
		return ServerResponse.createByErrorMessage("菜单代码不能为空");
	}  
  }
}
