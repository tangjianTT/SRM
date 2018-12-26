package com.neusoft.srm.mapper.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.notice.NoticeDO;
import com.neusoft.srm.model.notice.NoticeFileDO;

/**
 * @部门：上海软件研发中心
 * @功能：  公告管理的分页查询（条件查询）、新增、修改、删除(假删)
 * @描述：NoticeMapper
 * @作成者：汤健 
 * @作成时间：2018-12-17
 * @author TJ
 */
public interface NoticeMapper {

	/**
	 * @部门：上海软件研发中心
	 * @功能：  Notice的分页查询（条件查询）
     * @描述： userCode            用户代码
	 *      noticeTitle        公告标题
	 *      noticeKeyword      关键字
	 *      gmtCreateStart     发布时间开始
	 *      gmtCreateEnd       发布时间中止
	 *      pageNo             页数
	 *      pageSize           大小
	 * @返回值：List集合 Map装载数据
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	public List<Map<String, Object>> findNoticeList(@Param(value = "userCode") String[] userCode,
			@Param(value = "noticeTitle") String noticeTitle, @Param(value = "noticeKeyword") String noticeKeyword,
			@Param(value = "bizTypeCode") String bizTypeCode,@Param(value = "gmtCreateStart") String gmtCreateStart, @Param(value = "gmtCreateEnd") String gmtCreateEnd);

	/**
	 * @部门：上海软件研发中心
	 * @功能：  根据noticeCode查询附件信息
     * @描述： noticeCode            Notice代码
	 * @返回值：List集合 Map装载数据
	 * @作成者：汤健 
	 * @作成时间：2018-12-20
	 */
	public List<Map<String,Object>> findNoticeFileList(@Param(value = "noticeCode") String noticeCode);
	
	/**
	 * @部门：上海软件研发中心
	 * @功能： 根据noticeCode进行 Notice信息的假删
     * @描述：  noticeCode         公告代码
     *       userCode          用户代码
	 * @返回值：>0成功假删一个或多个Notice信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	public int removeNoticeByNoticeCode(@Param(value = "userCode") String userCode, @Param(value = "noticeCode") String[] noticeCodeAy);

	/**
	 * @部门：上海软件研发中心
	 * @功能：  根据noticeCode进行NoticeFile信息的假删
     * @描述：  noticeCode         公告代码
     *       userCode           用户代码
	 * @返回值：>0成功假删一个或多个Notice信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	public int removeNoticeFileByNoticeCode(@Param(value = "userCode") String userCode, @Param(value = "noticeCode") String[] noticeCodeAy);

	/**
	 * @部门：上海软件研发中心
	 * @功能：  根据noticeFileCode进行NoticeFile信息的假删
     * @描述：  noticeFileCode     公告文件代码
     *       userCode           用户代码
	 * @返回值：>0成功假删一个或多个NoticeFile信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	public int removeNoticeFileByNoticeFileCode(@Param(value = "userCode")String userCode, @Param(value = "noticeFileCode")String[] noticeFileCode);
	
	/**
	 * @部门：上海软件研发中心
	 * @功能：  Notice信息的新增
     * @描述：  noticeDO         noticeDO对象，封装了信息
	 * @返回值：>0成功新增Notice信息 <=0未新增
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	public int insertNotice(@Param(value = "noticeDO") NoticeDO noticeDO);

	/**
	 * @部门：上海软件研发中心
	 * @功能：  NoticeFile信息的假删
     * @描述：  noticeDO         noticeDO对象，封装了信息
	 * @返回值：>0成功新增Notice信息 <=0未新增
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	public int insertNoticeFile(@Param(value = "noticeFileList")List<NoticeFileDO> noticeFileList);

	/**
	 * @部门：上海软件研发中心
	 * @功能：  NoticeFile信息的修改
     * @描述：  noticeDO         noticeDO对象，封装了信息
	 * @返回值：>0成功新增Notice信息 <=0未新增
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	public int updateNotice(@Param(value = "noticeDO") NoticeDO noticeDO);


	/**
	 * @部门：上海软件研发中心
	 * @功能： 查询Notice已置顶数目
     * @描述：  userCode        用户代码
	 * @返回值：>0 已置顶数目 <=0未置顶
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	public int countByTopFlag(@Param(value = "userCode") String userCode);

	/**
	 * @部门：上海软件研发中心
	 * @功能： 置顶/取消置顶
     * @描述：  userCode        用户代码
     *       noticeCode	     notice代码
     *       stickFlag       置顶标识
	 * @返回值：>0 已置顶数目 <=0未置顶
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	public int updateNoticeTopFlag(@Param(value = "userCode") String userCode, @Param(value = "noticeCode") String noticeCode,@Param(value = "topFlag") String topFlag);
	
}
