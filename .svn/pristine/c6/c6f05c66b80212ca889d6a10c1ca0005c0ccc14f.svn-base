package com.neusoft.srm.service.user;
import com.github.pagehelper.PageInfo;
/**
 * 部门：上海软件研发中心
 * 功能：用户管理功能模块，查询，新增，修改，删除，修改密码，设置岗位，冻结/解冻
 * 描述：user的service接口
 * 作成者：王高亮
 * 作成时间：2018/12/13
 */
import com.neusoft.srm.model.user.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    /**
	 * 部门：上海软件研发中心
	 * 功能：查找所有用户信息，根据前台传过来的参数数据查询需要的用户信息
	 * 描述：user对象，查询创建时间开始段，查询创建时间结束段，页数，页数类型1页/10条
	 * 返回值：pageinfo,装载user对象
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
 public PageInfo<User> getListUsers(User user,String gmtCreateS,String gmtCreateE,int pageNum,int pageSize);
    /**
	 * 部门：上海软件研发中心
	 * 功能：新增，修改用户,同时也更新sys_user_dept里面的数据
	 * 描述：参数user对象
	 * 作成者：王高亮
	 * 返回值：新增，修改成功返回的行数
	 * 作成时间：2018/12/13
	 */
 public int saveUser(User user,String createBy);
   /**
	 * 部门：上海软件研发中心
	 * 功能：删除用户
	 * 描述：参数 userCode
	 * 返回值：删除用户成功返回的行数
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
 public int removeUser(String userCode,String loginUserCode);
   /**
	 * 部门：上海软件研发中心
	 * 功能：修改用户密码
	 * 描述：参数 userCode 用户代码 ，passwd 用户密码，passwdAgain 再次输入    
	 * 返回值：修改密码成功返回行数
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
 public int modifyUserPasswd(String userCode,String passwd,
		                     String passwdAgain,String loginUserCode);
   /**
	 * 部门：上海软件研发中心
	 * 功能：冻结或解冻用户
	 * 描述：参数 userCode 用户代码,freezeFlag 冻结标志
	 * 返回值：冻结/解冻成功返回行数
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
 public int modifyUserFreezeFlag(String freezeFlag,String userCode,
		 						 String loginUserCode);
}
