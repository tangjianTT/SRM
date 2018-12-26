package com.neusoft.srm.controller.user;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.dept.Dept;
import com.neusoft.srm.model.post.Post;
import com.neusoft.srm.model.user.PostModel;
import com.neusoft.srm.model.user.User;
import com.neusoft.srm.model.user.UserPost;
import com.neusoft.srm.model.user.UserType;
import com.neusoft.srm.service.user.GetPostService;
import com.neusoft.srm.service.user.UserDeptService;
import com.neusoft.srm.service.user.UserService;
import com.neusoft.srm.service.user.UserTypeService;
import com.neusoft.srm.util.ServerResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * @部门：上海软件研发中心
 * @功能：用户模块功能操作
 * @描述：用户模块接口需要的controller
 * @作成者：王高亮
 * @author WGL
 * @作成时间：2018/12/13
 */
@RestController
@RequestMapping("user")
public class UserController {
	private Logger log=LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private UserDeptService deptService;
	@Autowired
	private UserTypeService userTypeService;
	@Autowired
	private GetPostService getPostService;
	/**
	 * @部门：上海软件研发中心
	 * @功能：查询所有用户信息
	 * @描述：页数，页数类型1页/10条,user对象，查询创建时间开始段，查询创建时间结束段，
	 * @作成者：王高亮
	 * @author WGL
	 * @返回值：查询用户信息，返回json数据
	 * @作成时间：2018/12/13
	 */
	@LogOperat(detail="查询用户",logType=LogType.ACCESS,operationType=OperaLogType.SELECT)
	@RequestMapping(value="getUserList",method=RequestMethod.POST)
	public ServerResponse<Map<String, Object>> getUserController( int pageNum,int pageSize, 
		                                 @ModelAttribute("user") User user,String gmtCreateS,
		                                  String gmtCreateE) {
		PageInfo<User> pageInfo=null;
		//查询用户信息 参数(user对象，查询创建时间开始段，查询创建时间结束段，页数，页数类型1页/10条)
		//如果参数都为null，则查询所有用户信息
		pageInfo = userService.getListUsers(user,gmtCreateS,gmtCreateE,pageNum,pageSize);
		//查询的用户信息以json串的形式 以data名字返回
		Map<String , Object> userMap =new HashMap<>(0);
		userMap.put("data", pageInfo.getList());
		//获得数据总条数
		userMap.put("total", pageInfo.getTotal());
		//获得总页数
		userMap.put("pages", pageInfo.getPages());
		//返回服务器响应信息
		return ServerResponse.createBySuccess("查询信息成功", userMap);
	}
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作，获取用户类型
	 * @描述：查询用户类型，海尔1，客户3
	 * @返回值：返回用户类型 json数据
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	@RequestMapping(value="getUserTypeList",method=RequestMethod.POST)
	public ServerResponse<Map<String , Object>> getListUserTypeController(){
		//获得用户类型(海尔/客户)
		List<UserType> userTypeList = userTypeService.getUserTypeList();
		Map<String , Object> userTypeMap = new HashMap<>(0);
		userTypeMap.put("userType", userTypeList);
		return ServerResponse.createBySuccess("查询用户类型成功", userTypeMap);
	}
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：获取所有部门信息
	 * @返回值：返回部门信息json数据
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	@RequestMapping(value="getUserMasterList",method=RequestMethod.POST)
	public ServerResponse<Map<String,Object>> getListDeptTypeController(){
		//获取所有部门信息
		List<Dept> deptList = deptService.getDeptNameList();
		Map<String,Object> deptMap=new HashMap<>(0);
		deptMap.put("data", deptList);
		return ServerResponse.createBySuccess("加载部门信息成功",deptMap);
	}
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作,新增，修改用户
	 * @描述：参数是前台数据封装成user对象,request获取操作对象,返回的是新增，修改对象成功的数量
	 * @返回值：响应信息值
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	@LogOperat(detail="新增，修改角色",logType=LogType.ACCESS,operationType=OperaLogType.UPDATE)
	@RequestMapping(value="saveUser",method=RequestMethod.POST)
	public ServerResponse saveUserController(@ModelAttribute("user") User user,HttpServletRequest request) {
		//获得操作人信息
		String  loginUser = (String) request.getParameter("loginCode");
		//保存用户信息，保存成功返回行数
		int returnMsg = userService.saveUser(user,loginUser);
		if (returnMsg>0) {
			return ServerResponse.createBySuccessMessage("操作成功");
		}
		return ServerResponse.createByErrorMessage("操作失败");
	}
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：删除用户，参数是userCode,通过code删除用户,request获取操作对象
	 * @返回值：响应信息值
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	@LogOperat(detail="删除用户",logType=LogType.ACCESS,operationType=OperaLogType.DELETE)
	@RequestMapping(value="deleteUser",method=RequestMethod.POST)
	public ServerResponse deleteUserController(String userCode,HttpServletRequest request) {
		//获得操作人信息
		String loginUserCode = (String) request.getParameter("loginCode");
		if (StringUtils.isNotBlank(userCode)) {
			//根据userCode,删除用户，成功返回删除行数，把操作人信息加入表中创建人，修改人
			 int returnMsg = userService.removeUser(userCode,loginUserCode);
			 if (returnMsg>0) {
				 return ServerResponse.createBySuccessMessage("删除成功");
			}else {
				return ServerResponse.createByErrorMessage("删除失败");
			}
		}else {
			return ServerResponse.createByErrorMessage("用户代码不能为空");
		}	
	 }
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作
	 * @描述：修改密码，参数是用户Code,输入密码，再次输入,request获取操作对象
	 * @返回值：返回响应信息值
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	@LogOperat(detail="修改密码",logType=LogType.ACCESS,operationType=OperaLogType.UPDATE)
	@RequestMapping(value="modifyPasswd",method=RequestMethod.POST)
    public ServerResponse modifyPasswdController(String userCode,@RequestParam(value="userPwd",required=false) String passwd,
    		                           @RequestParam(value="inputAgain",required=false) String inputAgain,
    		                           HttpServletRequest request){
		//获得操作人信息
		String loginUserCode = (String) request.getParameter("loginCode");
		//修改用户密码成功，返回修改成功的行数
		int returnMsg = userService.modifyUserPasswd(userCode, passwd,inputAgain,loginUserCode);
		if (returnMsg>0) {
			return ServerResponse.createBySuccessMessage("修改密码成功");
		}
        return ServerResponse.createByErrorMessage("修改密码失败");
	}
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作，查询所有岗位信息以及用户关联的岗位信息
	 * @描述：获得所有岗位信息，通过参数(userCode)查询其岗位名称
	 * @返回值：返回岗位信息的json值
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	@LogOperat(detail="用户设置岗位查询所有岗位信息",logType=LogType.ACCESS,operationType=OperaLogType.SELECT)
	@RequestMapping(value="getPostList",method=RequestMethod.POST)
	public ServerResponse<Map<String , Object>> getListPostController(@RequestParam(required=false)String userCode){
		//查询所有岗位信息
		List<Post> postList = getPostService.getListPost();
		//查找用户对应的岗位信息
		List<Post> postByUserCode = getPostService.getListPostByUserCode(userCode);
		Map<String, Object> postMap=new HashMap<>(0);
		//把所有岗位信息，所选用户匹配的岗位信息加入map
		postMap.put("postList", postList);
		postMap.put("postByUserCode", postByUserCode);
		return ServerResponse.createBySuccess("查询岗位成功", postMap);
	}
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作,设置岗位保存
	 * @描述：获得session对象的userCode等于创建者(loginUser)，把岗位代码(postCode)，默认标志(defaultFlag)，
	 * 封装成postModel对象,获得当前时间date,把这些参数作为岗位信息写入当前用户信息
	 * @返回值：返回响应信息值
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	@LogOperat(detail="用户设置岗位",logType=LogType.ACCESS,operationType=OperaLogType.UPDATE)
	@RequestMapping(value="changeUserPost",method=RequestMethod.POST)
	public ServerResponse changeUserPostController(UserPost userPost) {
		//创建postModel对象
		//获取岗位信息
		 //获取用户Code
		String userCode = userPost.getUserCode();
		//获取操作人Code
		String loginCode = userPost.getLoginCode();
		//获取岗位代码，默认标志
        String postList = userPost.getPostList();
        //遍历json字符串去取值
        JSONArray json = JSONArray.parseArray(postList);
        List<PostModel> list = JSONObject.parseArray(json.toJSONString(), PostModel.class);
		//根据修改信息成功返回的行数判断
		int returnMsg = getPostService.changeListUserPost(userCode,list,loginCode);
		if (returnMsg>0) {
			return ServerResponse.createBySuccessMessage("设置岗位成功");
		}
        return ServerResponse.createByErrorMessage("设置岗位失败");
	}
	/**
	 * @部门：上海软件研发中心
	 * @功能：用户模块功能操作，冻结/解冻
	 * @描述：参数 冻结标志，用户Code,通过UserCode，freezeFlag,执行冻结或者解冻操作
	 *     request获取操作对象
	 * @返回值：返回响应信息值
	 * @作成者：王高亮
	 * @author WGL
	 * @作成时间：2018/12/13
	 */
	@LogOperat(detail="用户冻结/解冻",logType=LogType.ACCESS,operationType=OperaLogType.UPDATE)
	@RequestMapping(value="freezeOrUnfreeze",method=RequestMethod.POST)
	public ServerResponse freezeOrUnfreezeController(String freezeFlag,String userCode,
			                               HttpServletRequest request) {
		//获得操作人信息
		String  loginUser = (String) request.getParameter("loginCode");
		//修改用户冻结状态，返回修改成功信息行数
		int returnMsg = userService.modifyUserFreezeFlag(freezeFlag,userCode,loginUser);
		if (returnMsg>0) {
			return ServerResponse.createBySuccessMessage("操作成功");
		}
		return  ServerResponse.createByErrorMessage("操作失败");
	}
}
