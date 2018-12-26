package com.neusoft.srm.service.operaflow.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.mapper.operaflow.OperFlowMapper;
import com.neusoft.srm.model.operaflow.OperaDO;
import com.neusoft.srm.model.operaflow.OperaFileDO;
import com.neusoft.srm.service.operaflow.OperFlowService;
import com.neusoft.srm.util.AutoProduceCode;

/**
 * @部门：上海软件研发中心
 * @功能    文档管理的分页查询（条件查询）、新增、修改、删除(假删)
 * @描述： OperFlowServiceImpl实现类
 * @作成者：汤健 
 * @作成时间：2018-12-18
 * @author TJ
 */
@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class OperFlowServiceImpl implements OperFlowService{

	@Autowired
	private OperFlowMapper operFlowMapper;
	/**
	 * @部门：上海软件研发中心
	 * @功能：实现文档管理的分页查询（条件查询）
     * @描述：deptCode           部门代码
	 *       operaFlowTitle     文档名称
	 *      bizTypeCode         业务类型仓|配标识（0代表仓，1代表配，2表示全部）
	 *      gmtCreateStart      发布时间开始
	 *      gmtCreateEnd        发布时间中止
	 *      pageNo              页数
	 *      pageSize            大小
	 * @返回值：PageInfo<Map装载数据>
	 * @作成者：汤健 
	 * 作成时间：2018-12-18
	 */
	@Override
	public PageInfo<Map<String, Object>> getList(String deptCode, String operaFlowTitle, String bizTypeCode,
			String gmtCreateStart, String gmtCreateEnd, int pageNo, int pageSize) {
		// pageHelper设置页数，页面大小
		PageHelper.startPage(pageNo, pageSize);
		// 创建集合List<Map<String,Object>>用来获取文档管理所有信息
		List<Map<String, Object>> operFlowList = new ArrayList<>();
		operFlowList = operFlowMapper.findOperaList(deptCode, operaFlowTitle, bizTypeCode, gmtCreateStart, gmtCreateEnd);
		for (Map<String, Object> map : operFlowList) {
			List<Map<String,Object>> operaFileList = new ArrayList<>();
			String operaFlowCode=(String) map.get("OPERA_FLOW_CODE");
			operaFileList = operFlowMapper.findOperaFileList(operaFlowCode);
		    map.put("noticeFileList", operaFileList);
	}
		return new PageInfo<>(operFlowList);
	}
	
	/**
	 * @部门：上海软件研发中心 
	 * @功能：实现删除(假删)
	 * @描述：    noticeCode       公告代码
	 *         userCode        用户代码
 	 * @返回值：>0成功假删一个或多个文档信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	@Override
	public int delete(String operaFlowCode, String userCode) {
		// 判断传入operaFlowCode是否为空,不为空则做删除（假删）操作
		if (operaFlowCode != null || "".equals(operaFlowCode)) {
			// 批量删除获取operaFlowCode
			String[] operaFlowCodeAy = operaFlowCode.split(",");
			operFlowMapper.removeOperFlowFileByOperaFlowCode(userCode, operaFlowCodeAy);
			return operFlowMapper.removeOperFlowByOperaFlowCode(userCode, operaFlowCodeAy);
		}
		return 0;
	}

	/**
	 * @部门：上海软件研发中心 
	 * @功能：    Opera的新增(发布/暂存)/(重新发布)
	 * @描述：    operaDO          封装的Opera对象信息
	 *         attachFileList  封装的OperaFile多个信息
	 *         userCode        用户代码
	 *         stagFlag	               公开/暂存标记
 	 * @返回值：>0成功新增(发布/暂存)/(重新发布)一个或多个文档信息 <=0未新增(发布/暂存)/(重新发布)
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	@Override
	public int save(OperaDO operaDO, List<OperaFileDO> attachFileList, String userCode,String stagFlag ,String delId) {
		// 判断operaFlowCode是否为空，若为空，则做新增操作
		if ("".equals(operaDO.getOperaFlowCode()) || "null".equals(operaDO.getOperaFlowCode())
				|| operaDO.getOperaFlowCode() == null) {
			// 自动生成Code
			operaDO.setOperaFlowCode(new AutoProduceCode().produceCode());
			// 获取noticeCode
			String operaFlowCode = operaDO.getOperaFlowCode();
		    for (OperaFileDO operaFileDO : attachFileList) {
				operaFileDO.setOperaFlowCode(operaFlowCode);
				operaFileDO.setSortNo(0);
			}
		    // 判断是否是公开/暂存，0表示公开
            if("0".equals(stagFlag)){
            	operFlowMapper.insertOperaFlowFile(attachFileList,userCode,"0");
            	return	operFlowMapper.insertOperaFlow(operaDO,userCode,"0");
            }
            operFlowMapper.insertOperaFlow(operaDO,userCode,"1");
            return operFlowMapper.insertOperaFlowFile(attachFileList,userCode,"1");
		}
		if(!attachFileList.isEmpty()){
			String operaFlowCode = operaDO.getOperaFlowCode();
		    for (OperaFileDO operaFileDO : attachFileList) {
				operaFileDO.setOperaFlowCode(operaFlowCode);
				operaFileDO.setSortNo(0);
			}
		    operFlowMapper.insertOperaFlowFile(attachFileList,userCode,"0");
		}
		if(!delId.isEmpty()){
			String[] idAy=delId.split(",");
			operFlowMapper.removeOperFlowFileById(idAy,userCode);
		}
		return operFlowMapper.updateOperaFlow(operaDO,userCode);
	}

}
