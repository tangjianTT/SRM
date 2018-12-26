package com.neusoft.srm.service.post.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.mapper.post.PostMapper;
import com.neusoft.srm.model.post.Post;
import com.neusoft.srm.service.post.PostService;
import com.neusoft.srm.util.AutoProduceCode;
@Service
public class PostServiceImpl implements PostService{
     @Autowired
     private PostMapper postMapper;
     
	@Override
	public PageInfo<Post> getListPost(String postName,int pageNum,int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Post> list = postMapper.findAllPost(postName);
		//获得分页数据
		PageInfo<Post> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public int savePost(Post post,String loginCode) {
		post.setCreateBy(loginCode);
		//判断postCode,为空新增，非空则修改操作
		if (null == post.getPostCode()) {
			//产生新的岗位Code
			AutoProduceCode produceCode = new AutoProduceCode();
			String code = produceCode.produceCode();
			post.setPostCode(code);
			int count = postMapper.insertPost(post);
			return count;
		}else {
			int count = postMapper.updatePost(post);
			return count;
		}
	}
}
