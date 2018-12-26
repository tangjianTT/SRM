package com.neusoft.srm.controller.dept;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.LoginOperationType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.common.Tree;
import com.neusoft.srm.model.dept.BizTypeDO;
import com.neusoft.srm.model.dept.DeptDO;
import com.neusoft.srm.service.dept.BizTypeService;
import com.neusoft.srm.service.dept.DeptService;
import com.neusoft.srm.util.ServerResponse;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月7日
 * @功能描述：部门管理控制
 */
@MapperScan("com.neusoft.srm.mapper.dept")
@RestController
@RequestMapping("dept")
public class DeptController {
	private static Logger log = LoggerFactory.getLogger(DeptController.class);
	@Autowired
	private DeptService deptService;
	@Autowired
	private BizTypeService bizTypeService;

	/**
	 * @部门：上海软件研发中心
	 * @功能：查询所有部门信息
	 * @描述：
	 * @返回值：返回部门信息的JDON串
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	@LogOperat(detail = "查询部门", logType = LogType.ACCESS,operationType = OperaLogType.SELECT)
	@RequestMapping(value = "queryAllDept", method = RequestMethod.GET)
	public ServerResponse<Map<String, List<DeptDO>>> listAllDept() {
		log.info("=========listAllDept============");
		// 查询部门信息
		List<DeptDO> deptList = deptService.queryAllDeptList();
		// 给Json串List集合 设置别名
		Map<String, List<DeptDO>> deptListMap = new HashMap<>(0);
		deptListMap.put("deptList", deptList);
		// 返回服务响应信息
		return ServerResponse.createBySuccess("部门信息查询成功", deptListMap);
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能：查询所有业务类型信息
	 * @描述：
	 * @返回值：部门业务类型的JSON串
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	@LogOperat(detail="查询业务类型",logType=LogType.ACCESS,operationType = OperaLogType.SELECT)
	@RequestMapping(value = "queryBizTypeList", method = RequestMethod.GET)
	public ServerResponse<Map<String, List<BizTypeDO>>> queryBizTypeList() {
		log.info("==========queryBizTypeList=============");
		// 查询部门业务类型信息
		List<BizTypeDO> bizTypeList = bizTypeService.queryBizTypeList();
		// 给Json串业务类型List集合 设置别名
		Map<String, List<BizTypeDO>> bizTypeListMap = new HashMap<>(0);
		bizTypeListMap.put("bizTypeList", bizTypeList);
		// 返回服务响应信息
		return ServerResponse.createBySuccess("业务类型信息查询成功", bizTypeListMap);
	}

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：增加或更新部门信息
	 * @描述：deptDO 部门信息
	 *    bizTypeCode 业务类型编码
	 * @返回值：增加或更新部门的反馈信息JSON串
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	@LogOperat(detail="更新部门",logType=LogType.ACCESS,operationType = OperaLogType.UPDATE)
	@RequestMapping(value = "addDept", method = RequestMethod.POST)
	public ServerResponse addDept(HttpServletRequest requset, @ModelAttribute("deptDo") DeptDO deptDO,
			@RequestParam("bizTypeCode") String bizTypeCode) {
		log.info("==========addDept=============" + deptDO.getParentDeptCode());
		// 获取更新人
		HttpSession session = requset.getSession();
		String lastModifiedBy = (String) session.getAttribute("userCode");
		// 增加部门信息
		int type = deptService.addDept(deptDO, bizTypeCode, lastModifiedBy);
		if (type < 0) {
			return ServerResponse.createByErrorMessage("添加失败");
		}
		return ServerResponse.createBySuccessMessage("添加成功");
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能：根据部门编码删除部门信息
	 * @描述：deptCode 部门编码
	 * @返回值：删除结果反馈 
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	@LogOperat(detail="删除部门",logType=LogType.ACCESS,operationType = OperaLogType.DELETE)
	@RequestMapping(value = "removeDept", method = RequestMethod.DELETE)
	public ServerResponse removeDept(HttpServletRequest requset,
			@RequestParam(name = "deptCode", required = true) String deptCode) {
		log.info("==========removeDept==========");
		log.info(deptCode);
		// 获取更新人
		/*
		 * HttpSession session = requset.getSession(); String lastModifiedBy = (String)
		 * session.getAttribute("userCode");
		 */
		String lastModifiedBy = "张三";
		// 删除部门信息
		int delType = deptService.removeDept(deptCode, lastModifiedBy);
		// 判断是否删除成功
		if (delType == -1) {
			return ServerResponse.createByErrorCodeMessage(-1, "该部门存在员工");
		}
		if (delType < 0) {
			return ServerResponse.createByErrorMessage("删除失败");
		}
		return ServerResponse.createBySuccessMessage("删除成功");
	}

	@RequestMapping("getAllDept1")
	public List<Tree> getAllDept() {
		try {
			Tree resultDto = deptService.getAllDept("0");

			return resultDto.getChildren();
		} catch (Exception e) {
			throw new RuntimeException(this.getClass() + "--> getAllDept() Exception:", e);
		}
	}

	/**
	 * @功能描述：
	 * @部门：上海软件研发中心
	 * @作者：武京阳
	 * @时间：2018/12/14
	 */
	@RequestMapping("getDeptTypeList")
	public ServerResponse getDeptTypeList() {
		return ServerResponse.createBySuccesss(deptService.getDeptTypeList());
	}

	/**
	 * @功能描述：删除机构
	 * @部门：上海软件研发中心
	 * @作者：武京阳
	 * @时间：2018/12/14
	 */
	@RequestMapping("removeDept")
	public ServerResponse removeDept(String deptCode) {
		try {
			if (StringUtils.isNotBlank(deptCode)) {
				deptService.removeDept(deptCode);
				return ServerResponse.createBySuccess();
			} else {
				return ServerResponse.createByErrorMessage("部门代码不能为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ServerResponse.createBySuccesss(deptService.getDeptTypeList());
	}
}
