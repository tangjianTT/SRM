package com.neusoft.srm.service.user;

import java.util.Date;
import java.util.List;
import com.neusoft.srm.model.post.Post;
import com.neusoft.srm.model.user.PostModel;

/**
 * 部门：上海软件研发中心
 * 功能：用户管理模块，获取岗位信息，设置岗位
 * 描述：用户与岗位信息关联的service接口
 * 作成者：王高亮
 * 作成时间：2018/12/13
 */

public interface GetPostService {
	/**
	 * 部门：上海软件研发中心
	 * 功能：获取岗位信息
	 * 描述：参数用户代码
	 * 返回值：List集合装载post对象，返回所有岗位信息
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */	
     List<Post> getListPost();
     /**
 	 * 部门：上海软件研发中心
 	 * 功能：根据用户Code查找所对应的岗位
 	 * 描述：参数用户代码
 	 * 返回值：List装载post对象，所查询用户Code对应的所有岗位信息
 	 * 作成者：王高亮
 	 * 作成时间：2018/12/13
 	 */
     List<Post> getListPostByUserCode(String userCode);
     /**
 	 * 部门：上海软件研发中心
 	 * 功能：设置岗位，更改用户对应的岗位
 	 * 描述：参数创建者loginUser(当前session对象的userCode)，把岗位代码(postCode)，默认标志(defaultFlag)
 	 * 封装成postModel对象作为list集合参数,获得当前时间date,把这些参数作为岗位信息写入当前用户信息
 	 * 返回值：成功，返回修改岗位行数
 	 * 作成者：王高亮
 	 * 作成时间：2018/12/13
 	 */
     int changeListUserPost(String postCode,List<PostModel> postList,String loginUser);
}
