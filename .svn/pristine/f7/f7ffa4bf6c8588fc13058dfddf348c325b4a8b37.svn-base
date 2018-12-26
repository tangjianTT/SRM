package com.neusoft.srm.service.notice;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.model.notice.NoticeDO;
import com.neusoft.srm.model.notice.NoticeFileDO;

/**
 * @部门：上海软件研发中心
 * @功能    公告管理的分页查询（条件查询）、新增、修改、删除(假删)
 * @描述： NoticeService接口
 * @作成者：汤健 
 * @作成时间：2018-12-17
 * @author TJ
 */
public interface NoticeService {

	/**
	 * @部门：上海软件研发中心
	 * @功能：公告管理的分页查询（条件查询）
     * @描述：userCode            用户代码
	 *      noticeTitle        公告标题
	 *      noticeKeyword      关键字
	 *      bizTypeCode        业务类型
	 *      gmtCreateStart     发布时间开始
	 *      gmtCreateEnd       发布时间中止
	 *      pageNo             页数
	 *      pageSize           大小
	 * @返回值：PageInfo<Map装载数据>
	 * @作成者：汤健 
	 * 作成时间：2018-12-12
	 */
	public PageInfo<Map<String,Object>> getList(String[] userCode, String noticeTitle,
			String bizTypeCode,String noticeKeyword, String gmtCreateStart, String gmtCreateEnd, int pageNo, int pageSize);

	/**
	 * @部门：上海软件研发中心 
	 * @功能：删除(假删)
	 * @描述：    noticeCode           公告代码
	 *        userCode             用户代码
 	 * @返回值：>0成功假删一个或多个NoticeSite信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	public int delete(String userCode, String noticeFileCode);

	/**
	 * @param delId 
	 * @部门：上海软件研发中心 
	 * @功能：    Notice的新增/修改
	 * @描述：     userCode             用户代码
	 *         noticeDO             notice对象，存储数据
	 *         noticeFileList	         存储noticeFile文件
	 *         delId                删除的id
 	 * @返回值：>0成功新增/修改一个或多个Notice信息 <=0未新增/修改
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	public int save(NoticeDO noticeDO, List<NoticeFileDO> noticeFileList, String userCode, String delId);
	
	/**
	 * @部门：上海软件研发中心 
	 * @功能：    Notice的置顶（只能存在两条置顶）
	 * @描述：    noticeCode       公告代码
	 *        userCode        用户代码   
	 *        stickFlag       置顶标识
 	 * @返回值：>0 置顶/取消置顶成功 <0 未置顶/取消置顶
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	public int updateNotice(String userCode, String noticeCode, String topFlag);
}
