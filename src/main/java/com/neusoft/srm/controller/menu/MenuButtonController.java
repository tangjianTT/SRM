package com.neusoft.srm.controller.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.menu.MenuButton;
import com.neusoft.srm.service.menu.MenuButtonService;
import com.neusoft.srm.util.ServerResponse;

/**
 * @部门：上海软件研发中心
 * @功能：菜单模块，按钮信息的增删改查
 * @描述：
 * @返回值：返回菜单按钮的json串值
 * @author WGL
 * @作成者：王高亮
 * @作成时间：2018/12/13
 */
@RestController
@RequestMapping("button")
public class MenuButtonController {
	@Autowired
    private MenuButtonService menuButtonService;
	/**
	 * @部门：上海软件研发中心
	 * @功能：菜单模块，获取全部按钮信息
	 * @描述：参数  menuCode 菜单代码,查找菜单代码对应的按钮信息
	 * @返回值：返回菜单按钮的json串值
	 * @author WGL
	 * @作成者：王高亮
	 * @作成时间：2018/12/13
	 */
	@LogOperat(detail="菜单模块获取全部按钮信息",logType=LogType.ACCESS,operationType=OperaLogType.SELECT)
	@RequestMapping(value="getAllMenuButton")
	private ServerResponse<Map<String, Object>> getAllMenuButtonController(String menuCode){
		if (null == menuCode) {
			return ServerResponse.createByErrorMessage("菜单代码不能为空");
		}else {
			List<MenuButton> buttonList = menuButtonService.getAllMenuButton(menuCode);
			Map<String , Object> map = new HashMap<>();
			map.put("data",buttonList );
			return ServerResponse.createBySuccess("查询信息成功", map);
		}
	}
	/**
	 * @部门：上海软件研发中心
	 * @功能：菜单模块，新增，修改按钮信息
	 * @描述：参数  menuCode 菜单代码
	 * @返回值：返回成功响应信息
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	@LogOperat(detail="新增，修改按钮",logType=LogType.ACCESS,operationType=OperaLogType.UPDATE)
	@RequestMapping(value="saveMenuButton")
	private ServerResponse saveMenuButtonController(HttpServletRequest request,@ModelAttribute("menuButton") MenuButton menuButton) {
		String  operatorCode = (String) request.getParameter("loginCode");
		menuButton.setCreateBy(operatorCode);
		menuButton.setLastModifiedBy(operatorCode);
		int returnMsg = menuButtonService.saveMenuButton(menuButton);
		if (returnMsg>0) {
			return ServerResponse.createBySuccessMessage("操作成功");
		}else {
			return ServerResponse.createByErrorMessage("操作失败");
		}
		
	}
	/**
	 * @部门：上海软件研发中心
	 * @功能：删除按钮信息
	 * @描述：参数  buttonCode 按钮代码
	 * @返回值：返回成功响应信息
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	@LogOperat(detail="删除按钮",logType=LogType.ACCESS,operationType=OperaLogType.DELETE)
	@RequestMapping(value="removeMenuButton")
	private ServerResponse removeMenuButtonController(HttpServletRequest request,String buttonCode) {
		//获取操作人信息
		String operatorCode  = (String) request.getParameter("loginCode");
		//判断按钮code不为空
		if (StringUtils.isNotBlank(buttonCode)) {
			//返回删除成功行数
			int returnMsg = menuButtonService.removeMenuButton(operatorCode, buttonCode);
		if (returnMsg>0) {
			return ServerResponse.createBySuccessMessage("删除成功");
		}else {
			return ServerResponse.createByErrorMessage("删除失败");
		}
		}else {
			return ServerResponse.createByErrorMessage("按钮代码不能为空");
		}
	}
}
