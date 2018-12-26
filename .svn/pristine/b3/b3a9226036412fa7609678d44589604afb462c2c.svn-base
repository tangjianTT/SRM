package com.neusoft.srm.service.index;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;

/**
 * @部门：软件开发事业部
 * @作者：Jian.Tang
 * @开发日期：2018/12/12.
 * @功能描述:实现首页功能接口
 * @author TJ
 */
public interface IndexService {

	/**
	 * @部门：上海软件研发中心
	 * @功能：   修改密码
	 * @描述：   userCode    用户代码
	 *        poldPwd      原密码
	 *        newPwd      新密码
	 *        affirmPwd   确认密码
	 * @返回值：>0修改成功 <=0修改失败
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	public int updatePwd(String userCode, String oldPwd, String newPwd, String affirmPwd);

	/**
	 * @部门：上海软件研发中心
	 * @功能：   修改个人信息
	 * @描述： userCode           用户代码
	 *       phone              电话
	 *       email              电子邮件
	 *       sendMsgFlag        接收短信标记(1接收 0不接收)
	 *       sendEmailFlag      接收邮件标记(1接收 0不接收)
	 * @返回值：>0修改成功 <=0修改失败
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	public int updateUserMsg(String userCode, String phone, String email, String sendMsgFlag, String sendEmailFlag);

	/**
	 * @部门：上海软件研发中心
	 * @功能：   查询首页文档模块信息
	 * @描述： bizTypeCode  业务类型（0是仓，1是配）
     *       pageNo       页数
     *       pageSize     页面大小
	 * @返回值：PageInfo<Map装载数据>
	 * @作成者：汤健 
	 * @作成时间：2018-12-19
	 */
	public PageInfo<Map<String, Object>> getIndexOperaFlowList(String bizTypeCode, int pageNo, int pageSize);

	/**
	 * @部门：上海软件研发中心
	 * @功能： 获取登录者员工部门的上级上上级部门
	 * @描述： deptCode     部门代码
	 * @返回值： List<String>返回上上上级部门的代码集合
	 * @作成者：汤健 
	 * @作成时间：2018-12-20
	 */
	public List<String> getDeptCodeList(String deptCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能： 获取登录者员工部门的上级上上级部门的所有员工代码
	 * @描述： deptCodeList     上上上级部门的代码集合
	 * @返回值：String[]返回部门里的员工代码
	 * @作成者：汤健 
	 * @作成时间：2018-12-20
	 */
	public String[] getUserCodeList(List<String> deptCodeList);
}
