package com.neusoft.srm.controller.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.menu.MenuButton;
import com.neusoft.srm.service.menu.GetBtnByPostService;
import com.neusoft.srm.util.ServerResponse;

/**
 * 
  * @部门：上海软件研发中心
  * @功能：获得每个模块的按钮信息
  * @描述：
  * @作成者：王高亮
  * @author:WGL
  * @作成时间：2018年12月18日
 */
@RestController
@RequestMapping("getBtnByPost")
public class GetBtnByPostController {
	  @Autowired
	  private GetBtnByPostService getBtnByPostService;
	/**
     * 
      * @部门：上海软件研发中心
      * @功能：查找当前岗位所能操作的按钮信息
      * @描述：
      * @作成者：王高亮
      * @author:WGL
      * @作成时间：2018年12月18日
     */
	  @LogOperat(detail="获取模块按钮信息",logType=LogType.ACCESS,operationType=OperaLogType.SELECT)
    @RequestMapping(value="getMenuBtnByPost")
   private ServerResponse getUserMenuBtnByPost(String postCode,String menuCode){
	   List<MenuButton> list = getBtnByPostService.getMenuBtnByPost(postCode, menuCode);
	   Map<String, Object> map = new HashMap<>(0);
	   map.put("buttonStyle",list );
	return ServerResponse.createBySuccess("查询按钮成功", map);
   }
	
}
