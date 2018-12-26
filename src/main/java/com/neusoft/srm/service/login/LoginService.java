package com.neusoft.srm.service.login;

import java.util.List;
import java.util.Map;

import com.neusoft.srm.model.login.UserLoginDO;

/**
 * @部门：上海软件研发中心
 * @功能    登录验证,账号查询,查询登录用户岗位信息及其个人详细信息
 * @描述： LoginService接口
 * @作成者：汤健 
 * @作成时间：2018-12-10
 * @author TJ
 */
public interface LoginService {

	/**
	 * @部门：上海软件研发中心
	 * @功能：   登录验证
	 * @描述： userAcnt  用户账号
     *      userPwd   用户密码
     *      autoMsg   验证码信息
     *      inputMsg  用户输入验证码信息
	 * @返回值：=1 登录成功 , =-1用户账号不存在  ,=-2用户账号被冻结  ,=-3用户密码输入错误  ,=-4验证码输入错误
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	public int checkLogin(String userAcnt,String userPwd, String autoMsg, String inputMsg);

	/**
	 * @部门：上海软件研发中心
	 * @功能 ：账号查询
	 * @描述： userAcnt  用户账号
	 * @返回值：UserLoginDo对象 用户信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
    public UserLoginDO getUserLogin(String userAcnt);
    
	/**
	 * @部门：上海软件研发中心
	 * @功能： 查询登录用户岗位信息
	 * @描述：  userCode  用户代码
	 * @返回值：List集合 Map装载信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-13
	 */
    public List<Map<String,Object>> getUserPost(String userCode);

    /**
	 * @部门：上海软件研发中心
	 * @功能： 查询个人详细信息
	 * @描述：  userCode  用户代码
	 * @返回值：List集合 Map装载信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-13
	 */
	public List<Map<String, Object>> getUserMsg(String userCode);

	/**
	 * @部门：上海软件研发中心 
	 * @功能：获取个人菜单信息
	 * @描述：postCode   岗位代码
	 *      authCode  菜单范围代码（用于like'1%'上下级查询）
	 * @返回值：List集合 Map装载信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-14
	 */
	public List<Map<String, Object>> getUserMenus(String postCode, String authCode);

	/**
	 * @部门：上海软件研发中心 
	 * @功能：获取个人菜单按钮信息
	 * @描述：menuCode   菜单代码
	 * @返回值：List集合 Map装载信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-14
	 */
	public List<Map<String, Object>> getUserButtons(String menuCode);
}
