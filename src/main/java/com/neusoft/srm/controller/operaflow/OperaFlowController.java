package com.neusoft.srm.controller.operaflow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.operaflow.OperaDO;
import com.neusoft.srm.model.operaflow.OperaFileDO;
import com.neusoft.srm.service.operaflow.OperFlowService;
import com.neusoft.srm.util.ServerResponse;

/**
 * @部门：上海软件研发中心 
 * @功能：文档管理的分页查询（条件查询）、新增、修改、删除(假删)
 * @描述：文档管理控制器 
 * @作成者：汤健 
 * @作成时间：2018-12-18
 * @author TJ
 */
@RestController
@RequestMapping("/srm/operaFlow")
public class OperaFlowController {
	
	@Autowired
	private OperFlowService operFlowService;
	/**
	 * @部门：上海软件研发中心 
	 * @功能：文档管理的分页查询（条件查询）
	 * @描述：userCode           用户代码
	 *      pageNo             页数
	 *      pageSize           大小
	 * @返回值：公告管理查询结果（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	@LogOperat(detail="查询文档信息",logType=LogType.ACCESS ,operationType=OperaLogType.SELECT)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getOperaFlowList")
	public ServerResponse getOperaFlowList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "4", required = false) int pageSize) {
		try {
			// 获取部门代码
			String deptCode = request.getParameter("deptCode");
			// 获取opera标题
			String operaFlowTitle = request.getParameter("operaFlowTitle");
			// 获取业务类型
			String bizTypeCode = request.getParameter("bizTypeCode");
			// 获取发布时间开始
			String gmtCreateStart = request.getParameter("gmtCreateStart");
			// 获取发布时间结束
			String gmtCreateEnd = request.getParameter("gmtCreateEnd");
			// 调用operFlowService下的getList方法进行查询/条件查询信息（分页）
			PageInfo<Map<String, Object>> page = operFlowService.getList(deptCode, operaFlowTitle, bizTypeCode,
					gmtCreateStart, gmtCreateEnd, pageNo, pageSize);
			Map<String, Object> map = new HashMap<>(0);
			// 存储总数目
			map.put("totalCount", page.getTotal());
			// 存储总页数
			map.put("pageTotalCount", page.getPages());
			// 存储查询的数据
			map.put("operaList", page.getList());
			return ServerResponse.createBySuccesss(map);
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作失败");
		}
	}

	/**
	 * @部门：上海软件研发中心 
	 * @功能：删除(假删)
	 * @描述：    noticeCode       公告代码
	 *        userCode        用户代码
 	 * @返回值：文档管理删除结果（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	@LogOperat(detail="删除文档信息",logType=LogType.ACCESS ,operationType=OperaLogType.DELETE)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/deleteOperaFlow")
	public ServerResponse deleteOperaFlow(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取登录者代码
			String userCode = (String) request.getSession().getAttribute("userCode");
			// 获取文档代码
			String operaFlowCode = request.getParameter("operaFlowCode");
			if (operFlowService.delete(operaFlowCode, userCode) > 0) {
				return ServerResponse.createBySuccessMessage("删除成功");
			}
			return ServerResponse.createBySuccesss("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作失败");
		}
	}
	
	/**
	 * @部门：上海软件研发中心 
	 * @功能：    文档管理的新增(发布/暂存)/(重新发布)
	 * @描述：    noticeCode       公告代码
	 *        userCode        用户代码
	 *        notice          notice对象，存储数据
	 *        map	                     存储noticeFile文件
 	 * @返回值：文档管理的新增(发布/暂存)/(重新发布)结果(JSON)
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	@LogOperat(detail="修改文档信息",logType=LogType.ACCESS ,operationType=OperaLogType.UPDATE)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/saveOperaFlow")
	public ServerResponse saveOperaFlow(HttpServletRequest request, @ModelAttribute(name = "operaDO") OperaDO operaDO,
			@RequestParam(name = "attachFileList") String attachFileList, @RequestParam(name = "delId") String delId) {
		try {
			// 获取前台的JSON格式字符串转换成数组
			JSONArray jsonAy = JSONArray.parseArray(attachFileList);
			// 将数组数据对应到实体类上,转换成List<对象>
			List<OperaFileDO> operaFileList = JSONObject.parseArray(jsonAy.toJSONString(), OperaFileDO.class);
			// 获取userCode
			String userCode = (String) request.getSession().getAttribute("userCode");
			String stagFlag = request.getParameter("saveFlag");
			operFlowService.save(operaDO, operaFileList, userCode, stagFlag, delId);
			// 调用系统导航实现类save方法实现新增或者修改
			return ServerResponse.createBySuccessMessage("操作成功");
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作失败");
		}
	}
}
