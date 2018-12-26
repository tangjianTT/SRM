package com.neusoft.srm.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.neusoft.srm.model.user.User;

/**
 * @部门：上海软件研发中心
 * @功能：用户模块功能操作
 * @描述：查询，新增，修改，删除，修改密码，设置岗位，冻结/解冻
 * @作成者：王高亮
 * @author WGL
 * @作成时间：2018/12/13
 */
@Mapper
public interface UserDOMapper {
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：查询所有用户信息,通过参数user对象（页面查询用户属性封装回来），选择创建时间段
	 * ，开始时间段gmtCreateE,结束时间段gmtCreateE,查询所需要的用户信息
	 * @返回值:List集合 装载user对象，返回所有用户信息
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	List<User> findListUsers(@Param("user")User user,
							 @Param("gmtCreateS")String gmtCreateS,
							 @Param("gmtCreateE")String gmtCreateE);
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：新增用户，返回新增的用户信息行数，参数是用户对象
	 * @返回值:新增用户成功的行数
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	public int insertUser(@Param("user")User user);
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述： 通过user对象返回的属性值，修改当前用户信息
	 * @返回值:修改用户信息成功的行数
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
    public int updateUser(@Param("user")User user);
    /**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：通过参数前台传过来的多个用户代码，批量删除用户
	 * @返回值:删除用户成功的行数
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	public int deleteUserByCode(@Param("userCode")String[] userCodeList,
			                    @Param("loginUserCode")String loginUserCode);
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：根据前台传过来的userCode 修改用户密码
	 * @返回值:List集合 装载user对象，返回所有用户信息
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	public int updateUserPasswd(@Param("userCode")String userCode,
			                    @Param("userPwd")String passwd,
			                    @Param("loginUserCode")String loginUserCode);
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：根据前台传过来的参数，用户代码，冻结标志， 对用户进行冻结或者解冻
	 * @返回值:用户冻结/解冻成功的行数
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	public int updateUserFreezeFlag(@Param("freezeFlag")String freezeFlag,
			                        @Param("userCode")String userCode,
			                        @Param("loginUserCode")String loginUserCode);
}