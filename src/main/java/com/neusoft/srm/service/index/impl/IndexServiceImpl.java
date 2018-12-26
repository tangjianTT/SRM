package com.neusoft.srm.service.index.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.mapper.dept.DeptDOMapper;
import com.neusoft.srm.mapper.login.UserMapper;
import com.neusoft.srm.mapper.operaflow.OperFlowMapper;
import com.neusoft.srm.model.login.UserLoginDO;
import com.neusoft.srm.service.index.IndexService;
import com.neusoft.srm.util.SHA256;
/**
 * @部门：软件开发事业部
 * @作者：Jian.Tang
 * @开发日期：2018/12/12.
 * @功能描述:实现首页功能的实现类
 * @author TJ
 */
@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class IndexServiceImpl implements IndexService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private OperFlowMapper operFlowMapper;
	
	@Autowired
	private DeptDOMapper deptDOMapper;
	/**
	 * @部门：上海软件研发中心
	 * @功能：   实现修改密码
	 * @描述：   userCode    用户代码
	 *        poldPwd      原密码
	 *        newPwd      新密码
	 *        affirmPwd   确认密码
	 * @返回值：>0修改成功 <=0修改失败
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	@Override
	public int updatePwd(String userCode, String oldPwd, String newPwd, String affirmPwd) {
		//判断输入的原密码,新密码和确认密码是否为空或者不存在,如果有一个成立则返回标识-1，表示输入参数不能为空
		if("".equals(oldPwd) || oldPwd==null || "".equals(newPwd) || newPwd==null || "".equals(affirmPwd) || affirmPwd==null){
			return -1;			
		}
		List<Map<String,Object>> userList= userMapper.findUserByUserCode(userCode);
	    for (Map<String, Object> map : userList) {
	    	for (String key: map.keySet())  {
	          if("USER_PWD".equals(key)){
	        	  //判断原密码是否输入正确，若不正确则返回标识-2，表示原密码输入错误
	        	 if(!map.get(key).equals(new SHA256().pwdEncryption(oldPwd))){
	        		 return -2;	        		 
	        	 }
	          }
	        }
		}
	    //判断两次输入密码是否一致，若不一致，则返回标识-3，
	    if(!newPwd.equals(affirmPwd)){
	    	return -3;	    	
	    }
	    //修改密码,将属性存入UserLoginDO对象中
	    UserLoginDO userLoginDO=new UserLoginDO();
	    userLoginDO.setUserCode(userCode);
	    userLoginDO.setUserPwd(new SHA256().pwdEncryption(newPwd));
	    userLoginDO.setLastModifiedBy(userCode);
	    userLoginDO.setChangePwdDate(new Date());
	    userLoginDO.setGmtModified(new Date());
	    
	    return userMapper.updateUser(userLoginDO);
	}
	
	/**
	 * @部门：上海软件研发中心
	 * @功能： 实现修改个人信息
	 * @描述： userCode           用户代码
	 *       phone              电话
	 *       email              电子邮件
	 *       sendMsgFlag        接收短信标记(1接收 0不接收)
	 *       sendEmailFlag      接收邮件标记(1接收 0不接收)
	 * @返回值：>0修改成功 <=0修改失败
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	@Override
	public int updateUserMsg(String userCode, String phone, String email, String sendMsgFlag, String sendEmailFlag) {
		 UserLoginDO userLoginDO=new UserLoginDO();
		 userLoginDO.setUserCode(userCode);
		 userLoginDO.setPhone(phone);
		 userLoginDO.setEmail(email);
		 userLoginDO.setSendEmailFlag(Integer.parseInt(sendEmailFlag));
		 userLoginDO.setSendMsgFlag(Integer.parseInt(sendMsgFlag));
		 userLoginDO.setGmtModified(new Date());
		 userLoginDO.setLastModifiedBy(userCode);
		 return userMapper.updateUser(userLoginDO);
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能：   查询首页文档模块信息
	 * @描述：   bizTypeCode  业务类型（0是仓，1是配）
     *        pageNo       页数
     *        pageSize     页面大小
	 * @返回值：PageInfo<Map装载数据>
	 * @作成者：汤健 
	 * @作成时间：2018-12-19
	 */
	@Override
	public PageInfo<Map<String, Object>> getIndexOperaFlowList(String bizTypeCode, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		List<Map<String, Object>> operaFlowList=new ArrayList<>();
		operaFlowList=operFlowMapper.findIndexOperaFlowList(bizTypeCode);
		return new PageInfo<>(operaFlowList);
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能： 实现获取登录者员工部门的上级上上级部门
	 * @描述： deptCode     部门代码
	 * @返回值： List<String>返回上上上级部门的代码集合
	 * @作成者：汤健 
	 * @作成时间：2018-12-20
	 */
	@Override
	public List<String> getDeptCodeList(String deptCode) {
		// 定义装载deptCode集的容器
		List<String> deptCodeListResult=new ArrayList<>();
		// 定义并获取所有parentDeptCode集
		List<String> parentDeptCodeList=deptDOMapper.findListParentDeptCode();
		// 定义并获取所有deptCodeList集
		List<String> deptCodeList=deptDOMapper.findListDeptCode();
		// 调用递归方法，循环查询上级部门代码
		recursiveDeptCode(parentDeptCodeList,deptCodeList,deptCodeListResult,deptCode);
		// 返回结果集
		return deptCodeListResult;	
		} 
	/**
	 * @部门：上海软件研发中心
	 * @功能： 实现递归查询上级
	 * @描述： parentDeptCodeList     部门父类代码所有集
	 *       deptCodeList           部门代码所有集
	 *       deptCodeListResult     部门上级结果集
	 *       deptCode               部门代码
	 * @返回值： List<String>返回上上上级部门的代码集合
	 * @作成者：汤健 
	 * @作成时间：2018-12-20
	 */
   private  List<String> recursiveDeptCode(List<String>parentDeptCodeList,List<String>deptCodeList,List<String>deptCodeListResult,String deptCode){
	   // 获取当前登录人的部门代码元素位置
	   int deptCodeIndex=deptCodeList.indexOf(deptCode);
	   // 若有值则不为-1，则将部门代码添加到结果集
	   if(deptCodeIndex!=-1){
		   deptCodeListResult.add(deptCode);
	   }
	   // 若无该值则为-1，返回结果集
	   if(deptCodeIndex==-1){
		   return deptCodeListResult;
	   }
	   // 根据deptCode元素位置获取对应的parentDeptCode(父类部门代码)
	   String parentDeptCodeValue=parentDeptCodeList.get(deptCodeIndex);
	   // 递归循环
	   recursiveDeptCode(parentDeptCodeList,deptCodeList,deptCodeListResult,parentDeptCodeValue);
	   return deptCodeListResult;
   }

   /**
	 * @部门：上海软件研发中心
	 * @功能： 获取登录者员工部门的上级上上级部门的所有员工代码
	 * @描述： deptCodeList     上上上级部门的代码集合
	 * @返回值： List<String>返回部门里的员工
	 * @作成者：汤健 
	 * @作成时间：2018-12-20
	 */
	@Override
	public String[] getUserCodeList(List<String> deptCodeList) {
		List<String> userCodeList= userMapper.findUserCodeList(deptCodeList);
		return userCodeList.toArray(new String[userCodeList.size()]);
	}
}
