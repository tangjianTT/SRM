package com.neusoft.srm.controller.post;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.post.Post;
import com.neusoft.srm.service.post.PostService;
import com.neusoft.srm.util.ServerResponse;

@RestController
@RequestMapping("post")
public class PostController{
      @Autowired
      private PostService postService;
      /**
  	 * @部门：上海软件研发中心
  	 * @功能：用户模块功能操作
  	 * @描述：查询所有岗位信息
  	 * @返回值：返回响应信息值
  	 * @作成者：王高亮
  	 * @author WGL
  	 * @作成时间：2018/12/20
  	 */
      @LogOperat(detail="查询岗位信息",logType=LogType.ACCESS,operationType=OperaLogType.SELECT)
      @RequestMapping(value="getListPost")
	  private ServerResponse getListPostController(String postName,@RequestParam(defaultValue="1")int pageNum,@RequestParam(defaultValue="10")int pageSize) {
		  PageInfo<Post> pageInfo;
		 pageInfo = postService.getListPost(postName,pageNum,pageSize);
		 Map<String, Object> map = new HashMap<>(0);
		 map.put("postList", pageInfo.getList());
		 map.put("total", pageInfo.getTotal());
		 map.put("pages", pageInfo.getPages());
		return ServerResponse.createBySuccess("查询成功", map);
	  }
      /**
  	 * @部门：上海软件研发中心
  	 * @功能：用户模块功能操作
  	 * @描述：新增，修改岗位
  	 * @返回值：返回响应信息值
  	 * @作成者：王高亮
  	 * @author WGL
  	 * @作成时间：2018/12/13
  	 */
      @LogOperat(detail="新增，修改岗位",logType=LogType.ACCESS,operationType=OperaLogType.UPDATE)
      @RequestMapping(value="savePost")
      private ServerResponse savePost(@ModelAttribute(value="post") Post post,String loginCode) {
    	  int count = postService.savePost(post, loginCode);
    	  if (count > 0) {
			return ServerResponse.createBySuccessMessage("操作成功");
		}else {
			return ServerResponse.createByErrorMessage("操作失败");
		}  
      }
}
