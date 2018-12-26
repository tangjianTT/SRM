package com.neusoft.srm.controller.dict;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @部门： 软件开发事业部
 * @作者： HaoXin.Liu
 * @开发日期： 2018年12月17日
 * @功能描述：字典管理控制层
 */

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.model.dict.DictMainDO;
import com.neusoft.srm.model.dict.DictSubDO;
import com.neusoft.srm.service.dict.DictMainService;
import com.neusoft.srm.service.dict.DictSubService;
import com.neusoft.srm.util.ServerResponse;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月18日
 * @功能描述：字典管理操作
 */
@MapperScan("com.neusoft.srm.mapper.dict")
@RestController
@RequestMapping("dict")
public class DictController {
	@Autowired
	private DictMainService dictMainService;
	@Autowired
	private DictSubService dictSubService;

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：查询主字典所有值
	 * @描述：	lableKey		下拉框编码
	 *		lableName		下拉框名称
	 *		pageNo			页码
	 *		PageSize		默认 10条/页
	 * @返回值：响应参数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	@LogOperat(detail="查询主字典",logType=LogType.ACCESS,operationType = OperaLogType.SELECT)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "queryByFuzzyDict", method = RequestMethod.GET)
	public ServerResponse queryByFuzzyDict(@RequestParam(name = "lableKey", required = false) String lableKey,
			@RequestParam(name = "lableName", required = false) String lableName,
			@RequestParam(name = "pageNo", defaultValue = "1") String pageNo,
			@RequestParam(name = "pageSize", defaultValue = "10") String pageSize) {
		System.out.println("====queryByFuzzyDict=========");
		// 查询所有数据通过条件
		PageInfo<DictMainDO> dictMainPage = dictMainService.queryMainDictByCond(lableKey, lableName, pageNo, pageSize);
		// 数据存入Map
		Map<String, Object> dictMainMap = new HashMap<String, Object>(0);
		dictMainMap.put("dictList", dictMainPage.getList());
		// 获取总数和总页数
		dictMainMap.put("pageCount", dictMainPage.getPageNum());
		dictMainMap.put("pageNum", dictMainPage.getTotal());
		// 数据存入ServerResponse中，并反馈响应信息
		return ServerResponse.createBySuccess("查询成功", dictMainMap);
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能：通过主字典编码查询主字典值
	 * @描述：dictMainCode 主字典编码
	 * @返回值：服务响应参数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	@LogOperat(detail="查询一条主字典",logType=LogType.ACCESS,operationType = OperaLogType.SELECT)
	@RequestMapping(value = "queryOneByDictMainCode", method = RequestMethod.GET)
	public ServerResponse<DictMainDO> queryOneByDictMainCode(
			@RequestParam(name = "dictMainCode", required = true) String dictMainCode) {
		// 查询一条数据
		DictMainDO dictMainDO = dictMainService.queryOneMainDictByDictMainCode(dictMainCode);
		return ServerResponse.createBySuccess("数据查询成功", dictMainDO);
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能：新增或修改主字典
	 * @描述：dictMainCode	字典值编码	
	 * 	  lableKey		下拉框编码
	 * 	  lableName		下拉框名称
	 * 	  remark		备注
	 * @返回值：服务响应参数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	@LogOperat(detail="修改主字典",logType=LogType.ACCESS,operationType = OperaLogType.UPDATE)
	@RequestMapping(value = "modifyDict", method = RequestMethod.POST)
	public ServerResponse modifyDict(HttpServletRequest request,
			@ModelAttribute(name = "dictMainDO") DictMainDO dictMainDO) {
		// 获取创建人或更新人
		/*
		 * HttpSession session = request.getSession(); String userCode = (String)
		 * session.getAttribute("userCode");
		 */
		String userCode = "1234";
		// 插入或更新信息
		int type = dictMainService.addOrModifyDictMain(dictMainDO, userCode);
		if (type < 0) {
			return ServerResponse.createByErrorMessage("失败");
		}
		return ServerResponse.createBySuccessMessage("成功");
	}

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：根据主字典编码集合  批量删除主字典编码
	 * @描述：dictMainCodeList 用,分割的dictMainCode集合
	 * @返回值：服务响应参数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	@LogOperat(detail="删除主自字典",logType=LogType.ACCESS,operationType = OperaLogType.DELETE)
	@RequestMapping(value = "removeDict", method = RequestMethod.POST)
	public ServerResponse removeDict(@RequestParam("dictMainCodeList") String dictMainCodeList) {
		// 获取创建人或更新人
		/*
		 * HttpSession session = request.getSession(); String userCode = (String)
		 * session.getAttribute("userCode");
		 */
		String userCode = "1234";
		// 批量删除主字典数据
		int delNum = dictMainService.delBatchDictMainByDictMainCodeList(dictMainCodeList, userCode);
		if (delNum < 0) {
			return ServerResponse.createByErrorMessage("失败");
		}
		return ServerResponse.createBySuccessMessage("成功");
	}

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：查询父字典对应的子字典所有值
	 * @描述：dictMainCode	父字典编码
	 * @返回值：服务响应参数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	@LogOperat(detail="查询子字典",logType=LogType.ACCESS,operationType = OperaLogType.SELECT)
	@RequestMapping(value = "querySubDictByDictMainCode", method = RequestMethod.POST)
	public ServerResponse querySubDictByDictMainCode(@RequestParam("dictMainCode") String dictMainCode) {
		// 通过主字典编码 查询 子 字典 集合
		List<DictSubDO> dictSubList = dictSubService.querySubDictListByDictMainCode(dictMainCode);
		// 反馈查询结果
		return ServerResponse.createBySuccess("查询成功", dictSubList);
	}

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：根据子字典编码获取子字典数据
	 * @描述：dictSubCode	子字典编码
	 * @返回值：服务响应参数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月18日
	 */
	@LogOperat(detail="查询一个子字典",logType=LogType.ACCESS,operationType = OperaLogType.SELECT)
	@RequestMapping(value = "querySubDictByDictSubCode", method = RequestMethod.POST)
	public ServerResponse querySubDictByDictSubCode(@RequestParam("dictSubCode") String dictSubCode) {
		// 通过子字典编码 查询 子 字典 集合
		DictSubDO dictSub = dictSubService.querySubDictListByDictSubCode(dictSubCode);
		// 反馈查询结果
		return ServerResponse.createBySuccess("查询成功", dictSub);
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能：新增或修改子字典
	 * @描述：dictSub	子字典信息封装
	 * @返回值：服务响应参数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	@LogOperat(detail="修改日志",logType=LogType.ACCESS,operationType = OperaLogType.UPDATE)
	@RequestMapping(value = "addSubDict", method = RequestMethod.POST)
	public ServerResponse addSubDict(@ModelAttribute("dictSubDO") DictSubDO dictSub) {
		// 获取创建人或更新人
		/*
		 * HttpSession session = request.getSession(); String userCode = (String)
		 * session.getAttribute("userCode");
		 */
		System.out.println(dictSub);
		String userCode = "1234";
		// 插入或更新信息
		int type = dictSubService.addOrModifyDictSub(dictSub, userCode);
		if (type < 0) {
			return ServerResponse.createByErrorMessage("失败");
		}
		return ServerResponse.createBySuccessMessage("成功");
	}

	/**
	 * @部门：上海软件研发中心
	 * @功能：删除子字典
	 * @描述：dictSubCodeList  子字典编码 用,分割的串
	 * @返回值：服务响应参数
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月19日
	 */
	@LogOperat(detail="删除子字典",logType=LogType.ACCESS,operationType = OperaLogType.DELETE)
	@RequestMapping(value = "removeBatchSubDictByDictSubCodeList", method = RequestMethod.POST)
	public ServerResponse removeBatchSubDictByDictSubCodeList(
			@ModelAttribute("dictSubCodeList") String dictSubCodeList) {
		// 获取创建人或更新人
		/*
		 * HttpSession session = request.getSession(); String userCode = (String)
		 * session.getAttribute("userCode");
		 */
		String userCode = "1234";
		// 批量删除子字典数据
		int delNum = dictSubService.delBatchDictSubByDictSubCodeList(dictSubCodeList, userCode);
		if (delNum < 0) {
			return ServerResponse.createByErrorMessage("失败");
		}
		return ServerResponse.createBySuccessMessage("成功");
	}

}
