package com.neusoft.srm.mapper.user;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.neusoft.srm.model.post.Post;
import com.neusoft.srm.model.user.PostModel;

/**
 * @部门：上海软件研发中心
 * @功能：用户模块功能操作
 * @描述：用户模块涉及岗位信息用到的方法
 * @作成者：王高亮
 * @author WGL
 * @作成时间：2018/12/13
 */
@Mapper
public interface GetPostMapper {
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：查找所有岗位信息
	 * @返回值:List集合，装载岗位对象
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
    List<Post> findPostList();
    /**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：通过参数（用户代码）查找所有岗位信息
	 * @作成者：王高亮
	 * @author WGL
	 * @返回值:List集合，装载岗位对象，查询所有用户信息
	 * @作成时间：2018/12/13
	 */
    List<Post> findPostListByUserCode(@Param("userCode")String userCode);
    /**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：通过参数（用户代码）获取当前用户的岗位信息
	 * @返回值:List集合，装载岗位对象，查询当前用户的岗位信息
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
    List<Post> findPostCodeByUserCode(@Param("userCode")String userCode);
    /**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：通过参数（用户代码）修改用户岗位信息
	 * @返回值:修改用户岗位返回的行数
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
    int updateUserPost(@Param("userCode")String userCode);
    /**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：把用户代码，他对应的岗位代码，岗位默认标志，创建者插入数据库
	 * @返回值:插入数据成功返回的行数
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
    int insertUserPost(@Param("userCode")String userCode,@Param("postModelList")List<PostModel> postList,
    		           @Param("loginUserCode")String loginUser);
}
