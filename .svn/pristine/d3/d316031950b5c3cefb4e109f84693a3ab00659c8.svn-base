package com.neusoft.srm.service.login.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.srm.mapper.login.UserMapper;
import com.neusoft.srm.model.login.UserLoginDO;
import com.neusoft.srm.service.login.LoginService;
import com.neusoft.srm.util.SHA256;

/**
 * @部门：上海软件研发中心 
 * @功能 登录验证,账号查询,查询登录用户岗位信息及其个人详细信息 
 * @描述： LoginServiceImpl实体类 
 * @作成者：汤健
 * @作成时间：2018-12-10
 * @author TJ
 */
@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * @部门：上海软件研发中心 
	 * @功能：实现登录验证 
	 * @描述： userAcnt  用户账号 
	 *      userPwd   用户密码 
	 *      autoMsg   验证码信息 
	 *      inputMsg  用户输入验证码信息
	 * @返回值：=1 登录成功 , =-1用户账号不存在 ,=-2用户账号被冻结 ,=-3用户密码输入错误 ,=-4验证码输入错误
	 * @作成者：汤健 作成时间：2018-12-10
	 */
	@Override
	public int checkLogin(String userAcnt, String userPwd, String autoMsg, String inputMsg) {
		// 根据登录账户查询是否存在该账户
		UserLoginDO userLoginDO = userMapper.findUserByUserAcnt(userAcnt);
		// 若该账户不存在则返回-1标识，标识该账户不存在
		System.out.println(userLoginDO);
		if (userLoginDO == null){
			return -1;
		}
		if (1 == userLoginDO.getFreezeFlag()){
			return -2;			
		}
		// 进行对密码SHA256加密
		String userPwdSHA256 = new SHA256().pwdEncryption(userPwd);
		// 判断输入密码是否正确，若不正确则返回-3标识
		if (!userLoginDO.getUserPwd().equals(userPwdSHA256)) {
			// 验证输入错误次数是否达到5次，若为真，则返回-2标识，表示该用户账号被冻结
			if (-2 == judgeLoginErroNo(userLoginDO)) {
				return -2;
			}
			// 若不足5次，则返回-3标识用户密码输入错误
			return -3;
		}
		if (!autoMsg.equals(inputMsg)) {
			// 验证输入错误次数是否达到5次，若为真，则返回-2标识，表示该用户账号被冻结
			if (-2 == judgeLoginErroNo(userLoginDO)) {
				return -2;
			}
			// 若不足5次，则返回-4标识,表示用户输入验证码错误
			return -4;
		}
		userLoginDO.setLoginErrNo(0);
		userMapper.updateUser(userLoginDO);
		return 1;
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能：实现判断输入次数功能
	 * @描述： userLoginDO   userLogin对象
	 * @返回值：=-2 用户输入次数等于5,账号被冻结,=0 标识小于5,错误次数+1
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	private int judgeLoginErroNo(UserLoginDO userLoginDO) {
		System.out.println("judgeLoginErroNo:" + userLoginDO.getLoginErrNo());
		// 判断输入错误次数是否为5，若为5，则返回标识-2标识该用户已被冻结
		if (5 == userLoginDO.getLoginErrNo()) { 
			// 更新属性，将错误次数属性设置为5，冻结状态为1
			userLoginDO.setLoginErrNo(5);
			userLoginDO.setFreezeFlag(1);
			System.out.println(userLoginDO + "userLoginDO:");
			userMapper.updateUser(userLoginDO);
			return -2;
		}
		// 若输入次数不为5,则输入错误次数+1
		userLoginDO.setLoginErrNo(userLoginDO.getLoginErrNo() + 1);
		System.out.println("judgeLoginErroNo2:" + userLoginDO.getLoginErrNo());
		userMapper.updateUser(userLoginDO);
		return 0;
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能 ：实现账号查询
	 * @描述： userAcnt  用户账号
	 * @返回值：UserLoginDo对象 用户信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	@Override
	public UserLoginDO getUserLogin(String userAcnt) {
		return userMapper.findUserByUserAcnt(userAcnt);
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能： 查询登录用户岗位信息
	 * @描述：  userCode  用户代码
	 * @返回值：List集合 Map装载信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-13
	 */
	@Override
	public List<Map<String, Object>> getUserPost(String userCode) {
		return userMapper.findUserPost(userCode);
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能： 查询个人详细信息
	 * @描述：  userCode  用户代码
	 * @返回值：List集合 Map装载信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-13
	 */
	@Override
	public List<Map<String, Object>> getUserMsg(String userCode) {
		// TODO Auto-generated method stub
		return userMapper.findUserMsg(userCode);
	}

	/**
	 * @部门：上海软件研发中心 
	 * @功能：实现获取个人菜单按钮信息
	 * @描述：menuCode   菜单代码
	 * @返回值：List集合 Map装载信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-14
	 */
	@Override
	public List<Map<String, Object>> getUserMenus(String postCode, String authCode) {
		// TODO Auto-generated method stub
		return userMapper.findUserMenus(postCode,authCode);
	}

	/**
	 * @部门：上海软件研发中心 
	 * @功能：实现获取个人菜单按钮信息
	 * @描述：menuCode   菜单代码
	 * @返回值：List集合 Map装载信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-14
	 */
	@Override
	public List<Map<String, Object>> getUserButtons(String menuCode) {
		return userMapper.findUserButtons(menuCode);
	}

}
