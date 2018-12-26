package com.neusoft.srm.mapper.operaflow;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.operaflow.OperaDO;
import com.neusoft.srm.model.operaflow.OperaFileDO;



/**
 * @部门：上海软件研发中心
 * @功能：  文档管理的分页查询（条件查询）、新增、修改、删除(假删)
 * @描述：OperFlowMapper
 * @作成者：汤健 
 * @作成时间：2018-12-18
 * @author TJ
 */
public interface OperFlowMapper {

	/**
	 * @部门：上海软件研发中心
	 * @功能：  文档管理的分页查询（条件查询）
     * @描述： deptCode            部门代码
	 *       operaFlowTitle      文档名称
	 *       bizTypeCode         业务类型仓|配标识（0代表仓，1代表配，2表示全部）
	 *       gmtCreateStart      发布时间开始
	 *       gmtCreateEnd        发布时间中止
	 *       pageNo              页数
	 *       pageSize            大小
	 * @返回值：List集合 Map装载数据
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	public List<Map<String, Object>> findOperaList(@Param(value = "deptCode") String deptCode,
			@Param(value = "operaFlowTitle") String operaFlowTitle, @Param(value = "bizTypeCode") String bizTypeCode,
			@Param(value = "gmtCreateStart") String gmtCreateStart, @Param(value = "gmtCreateEnd") String gmtCreateEnd);

	/**
	 * @部门：上海软件研发中心
	 * @功能：  operaFile附件查询
     * @描述： operaFlowCode           operaFile附件代码
	 * @返回值：List集合 Map装载数据
	 * @作成者：汤健 
	 * @作成时间：2018-12-20
	 */
	public List<Map<String, Object>> findOperaFileList(@Param(value = "operaFlowCode") String operaFlowCode);
	
	/**
	 * @部门：上海软件研发中心
	 * @功能： 根据operaFlowCode进行 OperFlow信息的假删
     * @描述：  operaFlowCode    文档代码
     *       userCode          用户代码
	 * @返回值：>0成功假删一个或多个OperFlow信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	public int removeOperFlowByOperaFlowCode(@Param(value = "userCode")String userCode, @Param(value = "operaFlowCode")String[] operaFlowCodeAy);
	
	/**
	 * @部门：上海软件研发中心
	 * @功能： 根据operaFlowCode进行 OperFlowFile信息的假删
     * @描述：  operaFlowCode    文档代码
     *       userCode          用户代码
	 * @返回值：>0成功假删一个或多个OperFlow信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	public int removeOperFlowFileByOperaFlowCode(@Param(value = "userCode")String userCode, @Param(value = "operaFlowCode")String[] operaFlowCodeAy);

	/**
	 * @return 
	 * @部门：上海软件研发中心 
	 * @功能：    根据Id删除operaFile
	 * @描述：    idAy         数组存放删除的id值
	 * @返回值：>0成功删除一个operFile信息 <=0未更新
	 * @作成者：汤健 
	 * @作成时间：2018-12-19
	 */
	public int removeOperFlowFileById(@Param(value = "id") String[] idAy,@Param(value = "userCode")String userCode);
	
	/**
	 * @部门：上海软件研发中心 
	 * @功能：    Opera的新增
	 * @描述：    operaDO          封装的Opera对象信息
 	 * @返回值：>0成功新增一个文档信息 <=0未新增
	 * @作成者：汤健 
	 * @作成时间：2018-12-19
	 */
	public int insertOperaFlow(@Param(value = "operaDO") OperaDO operaDO , @Param(value = "userCode")String userCode,@Param(value = "stagFlag") String stagFlag);

	/**
	 * @return 
	 * @部门：上海软件研发中心 
	 * @功能：    OperaFile的新增
	 * @描述：    operaFileList          List集合封装的OperaFile对象信息
 	 * @返回值：>0成功新增一个或多个operFile信息 <=0未新增
	 * @作成者：汤健 
	 * @作成时间：2018-12-19
	 */
	public int insertOperaFlowFile(@Param(value = "attachFileList")List<OperaFileDO> attachFileList,@Param(value = "userCode") String userCode,@Param(value = "stageFlag")String stageFlag);

	/**
	 * @return 
	 * @部门：上海软件研发中心 
	 * @功能：    OperaFile的重新发布
	 * @描述：    operaFileList          List集合封装的OperaFile对象信息
 	 * @返回值：>0成功更新一个operFile信息 <=0未更新
	 * @作成者：汤健 
	 * @作成时间：2018-12-19
	 */
	public int updateOperaFlow(@Param(value = "operaDO")OperaDO operaDO, @Param(value = "userCode")String userCode);


	/**
	 * @部门：上海软件研发中心
	 * @功能：   查询首页Opera文档模块信息
	 * @描述：   bizTypeCode  业务类型（0是仓，1是配）
	 * @返回值：PageInfo<Map装载数据>
	 * @作成者：汤健 
	 * @作成时间：2018-12-19
	 */
	public List<Map<String, Object>> findIndexOperaFlowList(@Param(value = "bizTypeCode")String bizTypeCode);

}
