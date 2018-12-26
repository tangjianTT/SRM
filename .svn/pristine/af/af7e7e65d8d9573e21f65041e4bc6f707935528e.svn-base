package com.neusoft.srm.controller.login;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.LoginOperationType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.login.UserLoginDO;
import com.neusoft.srm.service.login.LoginService;
import com.neusoft.srm.util.ServerResponse;

/**
 * @部门：上海软件研发中心 
 * @功能：验证码生成,登录验证,获取个人登录信息 
 * @描述：登录控制器 
 * @作成者：汤健 
 * @作成时间：2018-12-10
 * @author TJ
 */
@RestController
@RequestMapping("/srm")
public class LoginController {

	/**
	 *  图片验证码生成类
	 */
	@Autowired
	private DefaultKaptcha captchaProducer;
	/**
	 * 登录实现类
	 */
	@Autowired
	private LoginService loginService;
	
   
	/**
	 * @部门：上海软件研发中心 
	 * @功能：获取验证码得请求路径 
	 * @描述：createText 验证码信息 
	 * @返回值：无
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	@RequestMapping("/defaultKaptcha")
	public void defaultKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
			throws Exception {
		byte[] captchaChallengeAsJpeg = null;
		ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		try {
			// 生产验证码字符串并保存到session中
			String createText = captchaProducer.createText();
			HttpSession session = httpServletRequest.getSession();
			session.setAttribute("autoMsg", createText);
			// 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
			BufferedImage challenge = captchaProducer.createImage(createText);
			ImageIO.write(challenge, "jpg", jpegOutputStream);
		} catch (IllegalArgumentException e) {
			httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		// 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
		captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		httpServletResponse.setHeader("Cache-Control", "no-store");
		httpServletResponse.setHeader("Pragma", "no-cache");
		httpServletResponse.setDateHeader("Expires", 0);
		httpServletResponse.setContentType("image/jpeg");
		ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
		responseOutputStream.write(captchaChallengeAsJpeg);
		responseOutputStream.flush();
		responseOutputStream.close();
	}

	/**
	 * @部门：上海软件研发中心 
	 * @功能：登录验证
	 * @描述：tryCode   用户输入得验证码信息 
	 *       userAcnt  用户账号
	 *       userPwd   用户密码
	 * @返回值：登录验证结果（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	@LogOperat(detail="登录",logType=LogType.LOGIN,loginOperationType=LoginOperationType.LOGIN,sourceType="web")
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/login")
	public ServerResponse login(HttpServletRequest request, HttpServletResponse reponse) {

		try {
			// 获取自动生成的验证码信息
			String autoMsg = (String) request.getSession().getAttribute("autoMsg");
			// 获取用户输入得验证码信息
			String tryCode = request.getParameter("tryCode");
			// 获取用户输入得用户账号信息
			String userAcnt = request.getParameter("userAcnt");
			// 获取用户输入得用户密码信息
			String userPwd = request.getParameter("userPwd");
			// 调用登录实现类得验证登录方法，返回int类型
			int loginFlag = loginService.checkLogin(userAcnt, userPwd, autoMsg, tryCode);
			// 进行对登录标识进行匹配，输出不同得结果JSON串
			if (loginFlag == 1) {
				// 通过登录账号查询到个人基本信息
				UserLoginDO userLoginDO = loginService.getUserLogin(userAcnt);
				// 提取个人用户代码
				String userCode = userLoginDO.getUserCode();
				// 存放到session中
				HttpSession session = request.getSession();
				session.setAttribute("userCode", userCode);
				Map<String, Object> map = new HashMap<>(0);
				map.put("userCode", userCode);
				return ServerResponse.createBySuccess("登录成功", map);
			}
			if (loginFlag == -1) {
				return ServerResponse.createByErrorCodeMessage(-1, "账户不存在");
			}
			if (loginFlag == -2) {
				return ServerResponse.createByErrorCodeMessage(-2, "账户被冻结");
			}
			if (loginFlag == -3) {
				return ServerResponse.createByErrorCodeMessage(-3, "账户密码错误");
			}
			if (loginFlag == -4) {
				return ServerResponse.createByErrorCodeMessage(-4, "验证码输入错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("传入错误参数");
		}
		return null;

	}

	/**
	 * @部门：上海软件研发中心 
	 * @功能：获取个人信息
	 * @描述：userCode   用户代码
	 *      postList  登录者岗位信息
	 *      userMsg   登录者详细信息
	 * @返回值：获取个人信息结果（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	@LogOperat(detail="查询个人信息",logType=LogType.ACCESS ,operationType=OperaLogType.SELECT)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/user/getUser")
	public ServerResponse getUser(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取userCode
			String userCode = (String) request.getSession().getAttribute("userCode");
			// 获取个人岗位信息
			List<Map<String, Object>> postList = loginService.getUserPost(userCode);
			// 获取个人详细信息
			List<Map<String, Object>> userMsg = loginService.getUserMsg(userCode);
			Map<String, Object> map = new HashMap<>(0);
			map.put("postList", postList);
			map.put("userMsg", userMsg);
			return ServerResponse.createBySuccesss(map);
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作失败");
		}

	}
	
	/**
	 * @部门：上海软件研发中心 
	 * @功能：获取个人菜单信息
	 * @描述：postCode   岗位代码
	 *      authCode  菜单范围代码（用于like'1%'上下级查询）
	 * @返回值：获取个人菜单信息（JSON）
	 * @作成者：汤健 
	 * @作成时间：2018-12-14
	 */
	@LogOperat(detail="查询菜单信息",logType=LogType.ACCESS ,operationType=OperaLogType.SELECT)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/menu/getUserMenus")
	public ServerResponse getUserMenus(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取岗位代码
			String postCode = request.getParameter("postCode");
			// 获取菜单范围代码
			String authCode = request.getParameter("authCode");
			// 获取该用户的菜单信息
			List<Map<String, Object>> menuList = loginService.getUserMenus(postCode, authCode);
			Map<String, Object> map = new HashMap<>(0);
			map.put("menuList", menuList);
			if (!menuList.isEmpty()) {
				return ServerResponse.createBySuccess("查询成功", map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作失败");
		}
		return null;
	}

	/**
	 * 部门：上海软件研发中心 
	 * 功能：获取个人菜单按钮信息 
	 * 描述：menuCode 菜单代码 
	 * 返回值：获取个人菜单按钮信息（JSON） 
	 * 作成者：汤健
	 * 作成时间：2018-12-14
	 */
	@LogOperat(detail="查询菜单按钮信息",logType=LogType.ACCESS ,operationType=OperaLogType.SELECT)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/menu/getUserButtons")
	public ServerResponse getUserButtons(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取菜单menuCode
			String menuCode = request.getParameter("menuCode");
			// 获取该菜单下的按钮信息
			List<Map<String, Object>> buttonList = loginService.getUserButtons(menuCode);
			Map<String, Object> map = new HashMap<>(0);
			map.put("buttonList", buttonList);
			if (!buttonList.isEmpty()) {
				return ServerResponse.createBySuccess("查询成功", map);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ServerResponse.createByErrorMessage("操作失败");
		}
		return null;
	}
}
