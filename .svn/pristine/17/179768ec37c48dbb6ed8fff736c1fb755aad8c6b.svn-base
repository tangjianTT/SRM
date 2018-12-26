package com.neusoft.srm.controller.index;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.service.index.IndexService;
import com.neusoft.srm.service.notice.NoticeService;
import com.neusoft.srm.util.ServerResponse;

/**
 * @部门：上海软件研发中心
 * @功能：修改个人密码,修改个人信息 
 * @描述：首页控制器 
 * @作成者：汤健 
 * @作成时间：2018-12-12
 * @author TJ
 */
@RestController
@RequestMapping("/srm/index")
public class IndexController {

	@Autowired
	private IndexService indexService;
	

	@Autowired
	private NoticeService noticeService;
	/**
	 * 部门：上海软件研发中心 
	 * 功能：修改个人密码 
	 * 描述：userCode    用户代码 
	 *      oldPwd      原始密码 
	 *      newPwd      新密码 
	 *      affirmPwd   确认密码 
	 * 返回值：修改个人密码结果（JSON）
	 * 作成者：汤健
	 * 作成时间：2018-12-12
	 */
	@LogOperat(detail="修改密码",logType=LogType.ACCESS,operationType=OperaLogType.UPDATE)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/modifyPwd")
	public ServerResponse modifyPwd(HttpServletRequest request, HttpServletResponse respsonse) {
		try {
			// 获取userCode(用户代码)
			String userCode = (String) request.getSession().getAttribute("userCode");
			// 获取原密码
			String oldPwd = request.getParameter("oldPwd");
			// 获取新密码
			String newPwd = request.getParameter("newPwd");
			// 获取确认密码值
			String affirmPwd = request.getParameter("affirmPwd");
			// 调用indexService的updatePwd方法更新密码
			int modfiyPwdFlag = indexService.updatePwd(userCode, oldPwd, newPwd, affirmPwd);
			if (modfiyPwdFlag == 1) {
				return ServerResponse.createBySuccessMessage("修改密码成功");
			}
			if (modfiyPwdFlag == -1) {
				return ServerResponse.createByErrorCodeMessage(-1, "输入参数不能为空");
			}
			if (modfiyPwdFlag == -2) {
				return ServerResponse.createByErrorCodeMessage(-2, "用户原密码输入错误");
			}
			if (modfiyPwdFlag == -3) {
				return ServerResponse.createByErrorCodeMessage(-3, "两次密码输入不匹配");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("修改密码错误");
		}
		return null;
	}
	
	/**
	 * 部门：上海软件研发中心 
	 * 功能：修改个人信息
	 * 描述：userCode          用户代码 
	 *      phone            手机
	 *      email            电子邮件
	 *      sendMsgFlag      接收短信标记(1接收 0不接收)
	 *      sendEmailFlag    接收邮件标记(1接收 0不接收)
	 * 返回值：修改个人信息结果（JSON）
	 * 作成者：汤健
	 * 作成时间：2018-12-12
	 */
	@LogOperat(detail="修改个人信息",logType=LogType.ACCESS ,operationType=OperaLogType.UPDATE)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/modifyUserMsg")
	public ServerResponse modifyUserMsg(HttpServletRequest request, HttpServletResponse respsonse) {
		try {
			// 获取用户代码
			String userCode = (String) request.getSession().getAttribute("userCode");
			// 获取手机号
			String phone = request.getParameter("phone");
			// 获取电子邮件
			String email = request.getParameter("email");
			// 获取发送信息标志
			String sendMsgFlag = request.getParameter("sendMsgFlag");
			// 获取发送邮件标志
			String sendEmailFlag = request.getParameter("sendEmailFlag");
			// 调用indexService的updateUserMsg方法更新个人信息
			int modifyUserMsgFlag = indexService.updateUserMsg(userCode, phone, email, sendMsgFlag, sendEmailFlag);
			if (modifyUserMsgFlag == 1) {
				return ServerResponse.createBySuccessMessage("修改个人信息成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("修改个人信息错误");
		}
		return null;
	}
	
	/**
	 * 部门：上海软件研发中心 
	 * 功能：首页-文档管理内容显示
	 * 描述：          用户代码 
	 * 返回值：修改个人信息结果（JSON）
	 * 作成者：汤健
	 * 作成时间：2018-12-19
	 */
	@LogOperat(detail="查询主页文档信息",logType=LogType.ACCESS ,operationType=OperaLogType.SELECT)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getIndexOperaFlowList")
	public ServerResponse getIndexOperaFlowList(HttpServletRequest request, HttpServletResponse respsonse,
			@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "4") int pageSize) {
		try {
			// 获取业务类型
			String bizTypeCode = request.getParameter("bizTypeCode");
			// 查询首页opera信息
			PageInfo<Map<String, Object>> page = indexService.getIndexOperaFlowList(bizTypeCode, pageNo, pageSize);
			Map<String, Object> map = new HashMap<>(0);
			// 存储总数目
			map.put("totalCount", page.getTotal());
			// 存储页数
			map.put("pageTotalCount", page.getPages());
			// 存储查询的数据
			map.put("operaFlowList", page.getList());
			return ServerResponse.createBySuccess("显示文档信息成功", map);
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作错误");
		}
	}
	
	/**
	 * 部门：上海软件研发中心 
	 * 功能：首页-文档管理内容显示
	 * 描述：          用户代码 
	 * 返回值：修改个人信息结果（JSON）
	 * 作成者：汤健
	 * 作成时间：2018-12-19
	 */
	@LogOperat(detail="查询主页公告信息",logType=LogType.ACCESS ,operationType=OperaLogType.SELECT)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getIndexNoticeList")
	public ServerResponse getIndeNoticeList(HttpServletRequest request, HttpServletResponse respsonse,
			@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "4") int pageSize) {
		try {
			// 获取deptCode(部门代码)
			String deptCode = request.getParameter("deptCode");
			// 查询出上上上级部门所有部门代码
			List<String> deptCodeList = indexService.getDeptCodeList(deptCode);
			// 查询出所有上级部门员工代码
			String[] userCodeAy = indexService.getUserCodeList(deptCodeList);
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
			// 调用noticeService的getList方法查询（条件查询）分页数据
			PageInfo<Map<String, Object>> page = noticeService.getList(userCodeAy, noticeTitle, noticeKeyword,
					bizTypeCode, gmtCreateStart, gmtCreateEnd, pageNo, pageSize);
			Map<String, Object> map = new HashMap<>(0);
			// 存储总数目
			map.put("totalCount", page.getTotal());
			// 存储页数
			map.put("pageTotalCount", page.getPages());
			// 存储查询的数据
			map.put("noticeList", page.getList());
			return ServerResponse.createBySuccess("显示文档信息成功", map);
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作错误");
		}
	}
}
