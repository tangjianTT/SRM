package com.neusoft.srm.mapper.post;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.post.Post;

public interface PostMapper {
     List<Post> findAllPost(@Param("postName")String postName);
     
     int insertPost(@Param("posts")Post post);
     
     int updatePost(@Param("posts")Post post);
}
