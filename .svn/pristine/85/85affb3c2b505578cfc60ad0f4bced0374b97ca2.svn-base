package com.neusoft.srm.controller.notice;

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
import com.neusoft.srm.model.notice.NoticeDO;
import com.neusoft.srm.model.notice.NoticeFileDO;
import com.neusoft.srm.service.notice.NoticeService;
import com.neusoft.srm.util.ServerResponse;

/**
 * @部门：上海软件研发中心 
 * @功能：公告管理的分页查询（条件查询）、新增、修改、删除(假删)
 * @描述：登录控制器 
 * @作成者：汤健 
 * @作成时间：2018-12-10
 * @author TJ
 */
@RestController
@RequestMapping("/srm/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	/**
	 * @部门：上海软件研发中心 
	 * @功能：公告管理的分页查询（条件查询）
	 * @描述：userCode           用户代码
	 *      noticeTitle        公告标题
	 *      noticeKeyword      关键字
	 *      gmtCreateStart     发布时间开始
	 *      gmtCreateEnd       发布时间中止
	 *      pageNo             页数
	 *      pageSize           大小
	 * @返回值：公告管理查询结果（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	@LogOperat(detail="查询公告信息",logType=LogType.ACCESS ,operationType=OperaLogType.SELECT)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getNoticeList")
	public ServerResponse getNoticeList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(defaultValue = "1", required = false) int pageNo,
			@RequestParam(defaultValue = "10", required = false) int pageSize) {
		try {
			// 获取登录者代码
			String userCode = (String) request.getSession().getAttribute("userCode");
			// 转换成userCode数组
			String[] userCodeAy = userCode.split(",");
			// 获取公告标题
			String noticeTitle = request.getParameter("noticeTitle");
			// 获取关键字
			String noticeKeyword = request.getParameter("noticeKeyword");
			// 获取业务类型
			String bizTypeCode = request.getParameter("bizTypeCode");
			// 获取发布时间开始
			String gmtCreateStart = request.getParameter("gmtCreateStart");
			// 获取发布时间结束
			String gmtCreateEnd = request.getParameter("gmtCreateEnd");
			// 调用noticeService的getList方法,获取查询/条件查询的信息（分页）
			PageInfo<Map<String, Object>> page = noticeService.getList(userCodeAy, noticeTitle, noticeKeyword,
					bizTypeCode, gmtCreateStart, gmtCreateEnd, pageNo, pageSize);
			Map<String, Object> map = new HashMap<>(0);
			// 存储总数目
			map.put("totalCount", page.getTotal());
			// 存储总页数
			map.put("pageTotalCount", page.getPages());
			// 存储查询的数据
			map.put("noticeList", page.getList());
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
 	 * @返回值：公告管理删除结果（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	@LogOperat(detail="删除公告信息",logType=LogType.ACCESS ,operationType=OperaLogType.DELETE)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/delete")
	public ServerResponse delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取登录者代码
			String userCode = (String) request.getSession().getAttribute("userCode");
			// 获取公告代码
			String noticeCode = request.getParameter("noticeCode");
			if (noticeService.delete(userCode, noticeCode) > 0) {
				return ServerResponse.createBySuccessMessage("删除成功");
			}
			return ServerResponse.createBySuccesss("删除失败");
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作失败");
		}
	}
	
	/**
	 * @部门：上海软件研发中心 
	 * @功能：    Notice的新增/修改
	 * @描述：    noticeCode       公告代码
	 *        userCode        用户代码
	 *        notice          notice对象，存储数据
	 *        map	                     存储noticeFile文件
 	 * @返回值：公告管理新增/修改结果（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	@LogOperat(detail="修改公告信息",logType=LogType.ACCESS ,operationType=OperaLogType.UPDATE)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/saveNotice")
	public ServerResponse saveNotice(HttpServletRequest request, @ModelAttribute(name = "noticeDO") NoticeDO noticeDO,
			@RequestParam(name = "fileList") String fileList, @RequestParam(name = "delId") String delId) {
		try {
			// 获取前台的JSON格式字符串转换成数组
			JSONArray jsonAy = JSONArray.parseArray(fileList);
			// 将数组数据对应到实体类上,转换成List<对象>
			List<NoticeFileDO> noticeFileList = JSONObject.parseArray(jsonAy.toJSONString(), NoticeFileDO.class);
			// 获取userCode
			String userCode = (String) request.getSession().getAttribute("userCode");
			if (noticeService.save(noticeDO, noticeFileList, userCode, delId) > 0) {
				// 调用系统导航实现类save方法实现新增或者修改
				return ServerResponse.createBySuccessMessage("操作成功");
			}
			return ServerResponse.createByErrorMessage("未做任何处理");
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作失败");
		}
	}
	
	/**
	 * @部门：上海软件研发中心 
	 * @功能：    Notice的置顶（只能存在两条置顶）
	 * @描述：    noticeCode       公告代码
	 *        userCode          用户代码   
 	 * @返回值：公告管理Notice的置顶结果（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	@LogOperat(detail="置顶公告信息",logType=LogType.ACCESS ,operationType=OperaLogType.UPDATE)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/updateNotice")
	public ServerResponse updateNotice(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取userCode(用户代码)
			String userCode = (String) request.getSession().getAttribute("userCode");
			// 获取noticeCode(通告代码)
			String noticeCode = request.getParameter("noticeCode");
			// 获取topFlag(置顶标志)
			String topFlag = request.getParameter("topFlag");
			if (noticeService.updateNotice(userCode, noticeCode, topFlag) == 1) {
				return ServerResponse.createBySuccessMessage("操作成功");
			}
			if (noticeService.updateNotice(userCode, noticeCode, topFlag) == -1) {
				return ServerResponse.createByErrorCodeMessage(-1, "最多只能置顶两条数据");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作失败");
		}
		return null;
	}
}
