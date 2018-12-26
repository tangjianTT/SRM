package com.neusoft.srm.service.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.neusoft.srm.mapper.user.UserDeptMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.mapper.user.UserDOMapper;
import com.neusoft.srm.model.user.User;
import com.neusoft.srm.service.user.UserService;
import com.neusoft.srm.util.AutoProduceCode;
import com.neusoft.srm.util.SHA256;
import java.util.ArrayList;
import java.util.List;

/**
 * 部门：上海软件研发中心
 * 功能：用户管理功能模块，查询，新增，修改，删除，修改密码，设置岗位，冻结/解冻
 * 描述：user的service接口
 * 作成者：王高亮
 * 作成时间：2018/12/13
 */
@Service
@Transactional(rollbackFor= {Exception.class,RuntimeException.class})
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDOMapper userDOMapper;
	@Autowired
	private UserDeptMapper userDeptMapper;
	/**
	 * 部门：上海软件研发中心
	 * 功能：查找所有用户信息，根据前台传过来的参数数据查询需要的用户信息
	 * 描述：user对象，查询创建时间开始段，查询创建时间结束段，页数，页数类型1页/10条
	 * 返回值：List集合，装载user对象
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
	@Override
	public PageInfo<User> getListUsers(User user,String getCreateS,
			                       String getCreateE,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		//获取所有用户信息
		List<User> users = userDOMapper.findListUsers(user,getCreateS,
				            getCreateE);
		//得到分页的结果对象
		PageInfo<User> pageInfo = new PageInfo<>(users);
		return  pageInfo;
	}
	/**
	 * 部门：上海软件研发中心
	 * 功能：新增，修改用户,同时也更新sys_user_dept里面的数据
	 * 描述：参数user对象
	 * 作成者：王高亮
	 * 返回值：新增，修改成功返回的行数
	 * 作成时间：2018/12/13
	 */
	@Override
	public int saveUser(User user,String loginUserCode) {
		//获得用户选择的部门编号
		String deptCode = user.getDeptCode();
		//把操作对象给user设置创建人，修改人
		user.setCreateBy(loginUserCode);
		user.setLastModifiedBy(loginUserCode);
		//通过判断userCode是否为Null,来判断是新增还是修改
		if (null == user.getUserCode()) {
			//获取用户编号
			AutoProduceCode autoProduceCode = new AutoProduceCode();
			String produceCode = autoProduceCode.produceCode();
			user.setUserCode(produceCode);
			//新增用户
			int returnMsg = userDOMapper.insertUser(user);
			//新增用户更新用户与部门关系表
			userDeptMapper.insertUserDept(produceCode,deptCode,loginUserCode);
			return returnMsg;
		}
		//修改用户信息
		int returnMsg = userDOMapper.updateUser(user);
		String userCode = user.getUserCode();
		//修改用户与部门关联表信息
		userDeptMapper.updateUserDept(userCode, deptCode,loginUserCode);
		return returnMsg;
	}
	/**
	 * 部门：上海软件研发中心
	 * 功能：删除用户
	 * 描述：参数 userCode
	 * 返回值：删除用户成功返回的行数
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
	@Override
	public int removeUser(String userCode,String loginUserCode) {
		//把字符串分割成string数组
		String[] userCode1 = userCode.split(",");
		int returnMsg = userDOMapper.deleteUserByCode(userCode1,loginUserCode);
		return returnMsg;
	}
	/**
	 * 部门：上海软件研发中心
	 * 功能：修改用户密码
	 * 描述：参数 userCode 用户代码 ，passwd 用户密码，passwdAgain 再次输入    
	 * 返回值：修改密码成功返回行数
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
	@Override
	public int modifyUserPasswd(String userCode, String passwd, 
			                    String passwdAgain,String loginUserCode) {
		//构建密码加密类
		SHA256 sha256 = new SHA256();
		//判断密码输入是否为空
		if (passwd!=null && passwd.length()!= 0) {
			if (passwdAgain!= null && passwdAgain.length()!= 0) {
				//判断密码输入，再次密码输入是否相同，相同修改数据，返回修改行数
				if (passwd.equals(passwdAgain)) {
					String userPwd = sha256.pwdEncryption(passwd);
					return userDOMapper.updateUserPasswd(userCode, userPwd,loginUserCode);
				}
			}
		}
		return 0;
	}
	/**
	 * 部门：上海软件研发中心
	 * 功能：冻结或解冻用户
	 * 描述：参数 userCode 用户代码,freezeFlag 冻结标志
	 * 返回值：冻结/解冻成功返回行数
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
	@Override
	public int modifyUserFreezeFlag(String freezeFlag,String userCode,String loginUserCode) {
		//修改用户冻结标志，返回成功信息
		int returnMsg = userDOMapper.updateUserFreezeFlag(freezeFlag, userCode,loginUserCode);
		return returnMsg;
	}	
}
