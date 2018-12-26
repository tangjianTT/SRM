package com.neusoft.srm.service.user.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.srm.mapper.user.GetPostMapper;
import com.neusoft.srm.model.post.Post;
import com.neusoft.srm.model.user.PostModel;
import com.neusoft.srm.service.user.GetPostService;

/**
 * 部门：上海软件研发中心
 * 功能：用户管理模块，获取岗位信息，设置岗位
 * 描述：用户与岗位信息关联的service接口的实现
 * 作成者：王高亮
 * 作成时间：2018/12/13
 */
@Transactional(rollbackFor= {Exception.class,RuntimeException.class})
@Service
public class GetPostServiceImpl implements GetPostService{
	
	@Autowired
	private GetPostMapper getPostMapper;
	/**
	 * 部门：上海软件研发中心
	 * 功能：获取岗位信息
	 * 描述：
	 * 返回值：List集合装载post对象，返回所有岗位信息
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
	@Override
	public List<Post> getListPost() {
		//获取所有岗位信息
		List<Post> postList = getPostMapper.findPostList();
		return postList;
	}
	/**
	 * 部门：上海软件研发中心
	 * 功能：根据用户Code查找所对应的岗位
	 * 描述：参数用户代码
	 * 返回值：List装载post对象，所查询用户Code对应的所有岗位信息
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
	

	@Override
	public List<Post> getListPostByUserCode(String userCode) {
		//查找该用户所对应的岗位信息
		List<Post> postListByUserCode = getPostMapper.findPostListByUserCode(userCode);
		return postListByUserCode;
	}
	/**
	 * 部门：上海软件研发中心
	 * 功能：设置岗位，更改用户对应的岗位
	 * 描述：参数创建者loginUser(当前session对象的userCode)，把岗位代码(postCode)，默认标志(defaultFlag)
	 * 封装成postModel对象作为list集合参数,获得当前时间date,把这些参数作为岗位信息写入当前用户信息
	 * 返回值：成功，返回修改岗位行数
	 * 作成者：王高亮
	 * 作成时间：2018/12/13
	 */
	@Override
	public int changeListUserPost(String userCode,List<PostModel> postList,
			                      String loginUser) {
		//把当前用户对象的岗位DEL_FLAG全设置为1，无效
		int userPost = getPostMapper.updateUserPost(userCode);
		 //把新增加的用户的岗位插入数据库
			 int count = getPostMapper.insertUserPost(userCode, postList,loginUser);
		 return count;
	}
}
