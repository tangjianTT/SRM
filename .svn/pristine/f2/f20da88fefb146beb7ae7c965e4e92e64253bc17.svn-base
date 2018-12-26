package com.neusoft.srm.service.operaflow;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.model.operaflow.OperaDO;
import com.neusoft.srm.model.operaflow.OperaFileDO;


/**
 * @部门：上海软件研发中心
 * @功能    文档管理的分页查询（条件查询）、新增、修改、删除(假删)
 * @描述： OperFlowService接口
 * @作成者：汤健 
 * @作成时间：2018-12-18
 * @author TJ
 */
public interface OperFlowService {

	/**
	 * @部门：上海软件研发中心
	 * @功能：文档管理的分页查询（条件查询）
     * @描述：deptCode           部门代码
	 *       operaFlowTitle     文档名称
	 *      bizTypeCode         业务类型仓|配标识（0代表仓，1代表配，2表示全部）
	 *      gmtCreateStart      发布时间开始
	 *      gmtCreateEnd        发布时间中止
	 *      pageNo              页数
	 *      pageSize            大小
	 * @返回值：PageInfo<Map装载数据>
	 * @作成者：汤健 
	 * 作成时间：2018-12-12
	 */
	public PageInfo<Map<String,Object>> getList(String deptCode, String operaFlowTitle,
			String bizTypeCode, String gmtCreateStart, String gmtCreateEnd, int pageNo, int pageSize);

	/**
	 * @部门：上海软件研发中心 
	 * @功能：删除(假删)
	 * @描述：    noticeCode       公告代码
	 *         userCode        用户代码
 	 * @返回值：>0成功假删一个或多个文档信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	public int delete(String operaFlowCode, String userCode);

	/**
	 * @param delFileList 
	 * @部门：上海软件研发中心 
	 * @功能：    Opera的新增(发布/暂存)/(重新发布)
	 * @描述：    operaDO          封装的Opera对象信息
	 *         attachFileList  封装的OperaFile多个信息
	 *         userCode        用户代码
	 *         stagFlag        公开/暂存标记
	 *         delFileList     重新发布/删除文件标志
 	 * @返回值：>0成功新增(发布/暂存)/(重新发布)一个或多个文档信息 <=0未新增(发布/暂存)/(重新发布)
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	public int save(OperaDO operaDO, List<OperaFileDO> attachFileList, String userCode,String stagFlag, String delId);
}
