package com.neusoft.srm.mapper.login;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.login.UserLoginDO;

/**
 * @部门：上海软件研发中心
 * @功能：修改个人密码,修改个人信息 
 * @描述：用户Mapper
 * @作成者：汤健 
 * @作成时间：2018-12-13
 * @author TJ
 */
@Mapper
public interface UserMapper {
   
	/**
	 * @部门：上海软件研发中心
	 * @功能：根据用户账号查询，是否存在该用户
	 * @描述：userAcnt     用户账号
	 * @返回值：null 代表该用户不存在  ！=null 代表该用户存在
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 * @
	 * @param userAcnt 用户账号
	 * @return null 代表该用户不存在  ！=null 代表该用户存在
	 */
	public UserLoginDO findUserByUserAcnt(@Param(value="userAcnt")String userAcnt);
	
	/**
	 * @部门：上海软件研发中心
	 * @功能：根据userCode查询具体个人信息，进行更新内容
	 * @描述：userLoginDO     用户对象
	 * @返回值：>0 代表影响行数,更新成功 <=0 代表更新失败
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	public int updateUser(@Param("userLoginDO") UserLoginDO userLoginDO);
	
	/**
	 * @部门：上海软件研发中心
	 * @功能：根据usrCode查询用户相关的信息
	 * @描述：userAcnt     用户账号
	 * @返回值：list集合，map存储用户信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-10
	 */
	public List<Map<String,Object>> findUserByUserCode(@Param(value="userCode")String userCode);
	
	/**
	 * @部门：上海软件研发中心
	 * @功能：根据usrCode查询用户岗位的信息
	 * @描述：userAcnt     用户账号
	 * @返回值：list集合，map存储用户信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-13
	 */
	public List<Map<String,Object>> findUserPost(@Param(value="userCode")String userCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能：根据usrCode查询用户相关部门和个人的信息
	 * @描述：userAcnt     用户账号
	 * @返回值：list集合，map存储用户信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-13
	 */
	public List<Map<String, Object>> findUserMsg(@Param(value="userCode")String userCode);

	/**
	 * @部门：上海软件研发中心 
	 * @功能：实现获取个人菜单信息
	 * @描述：postCode   岗位代码
	 *      authCode  菜单范围代码（用于like'1%'上下级查询）
	 * @返回值：List集合 Map装载信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-14
	 */
	public List<Map<String, Object>> findUserMenus(@Param(value="postCode")String postCode, @Param(value="authCode")String authCode);
	
	/**
	 * @部门：上海软件研发中心 
	 * @功能：实现获取个人菜单按钮信息
	 * @描述：postCode   岗位代码
	 *      authCode  菜单范围代码（用于like'1%'上下级查询）
	 * @返回值：List集合 Map装载信息
	 * @作成者：汤健 
	 * @作成时间：2018-12-14
	 */
	public List<Map<String, Object>> findUserButtons(@Param(value="menuCode")String menuCode);

	/**
	 * @部门：上海软件研发中心 
	 * @功能： 获取登录者员工部门的上级上上级部门的所有员工代码 
	 * @描述： deptCodeList   上上上级部门的代码集合 
	 * @返回值： List<String>返回部门里的员工
	 * @作成者：汤健 
	 * @作成时间：2018-12-20
	 */
	public List<String> findUserCodeList(@Param(value = "deptCode") List<String> deptCodeList);
}