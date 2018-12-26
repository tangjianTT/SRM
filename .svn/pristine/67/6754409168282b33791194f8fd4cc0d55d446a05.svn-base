package com.neusoft.srm.service.notice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.mapper.notice.NoticeMapper;
import com.neusoft.srm.model.notice.NoticeDO;
import com.neusoft.srm.model.notice.NoticeFileDO;
import com.neusoft.srm.service.notice.NoticeService;
import com.neusoft.srm.util.AutoProduceCode;

/**
 * @部门：上海软件研发中心
 * @功能    公告管理的分页查询（条件查询）、新增、修改、删除(假删)
 * @描述： NoticeServiceImpl实现类
 * @作成者：汤健 
 * @作成时间：2018-12-17
 * @author TJ
 */
@Service
@Transactional(rollbackFor={RuntimeException.class, Exception.class})
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	/**
	 * @部门：上海软件研发中心
	 * @功能：实现公告管理的分页查询（条件查询）
     * @描述：userCode            用户代码
	 *      noticeTitle        公告标题
	 *      noticeKeyword      关键字
	 *      gmtCreateStart     发布时间开始
	 *      gmtCreateEnd       发布时间中止
	 *      pageNo             页数
	 *      pageSize           大小
	 * @返回值：PageInfo<Map装载数据>
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	@Override
	public PageInfo<Map<String, Object>> getList(String[] userCode, String noticeTitle, String noticeKeyword,
			String bizTypeCode,String gmtCreateStart, String gmtCreateEnd, int pageNo, int pageSize) {
		// pageHelper设置页数，页面大小
		PageHelper.startPage(pageNo, pageSize);
		// 创建集合List<Map<String,Object>>用来获取Notice所有信息
		List<Map<String, Object>> noticeList = new ArrayList<>();
		noticeList = noticeMapper.findNoticeList(userCode, noticeTitle, noticeKeyword, bizTypeCode, gmtCreateStart, gmtCreateEnd);
		for (Map<String, Object> map : noticeList) {
				List<Map<String,Object>> noticeFileList = new ArrayList<>();
				String noticeCode=(String) map.get("NOTICE_CODE");
				noticeFileList = noticeMapper.findNoticeFileList(noticeCode);
			    map.put("noticeFileList", noticeFileList);
		}
		return new PageInfo<>(noticeList);
	}

	/**
	 * @部门：上海软件研发中心 
	 * @功能：删除(假删)
	 * @描述：    noticeCode           公告代码
	 * @返回值：>0成功假删一个或多个Notice信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	@Override
	public int delete(String userCode,String noticeCode) {
		// 判断传入noticeCode是否为空,不为空则做删除（假删）操作
		if (noticeCode != null || "".equals(noticeCode)) {
			// 批量删除获取noticeCode
			String[] noticeCodeAy = noticeCode.split(",");
			noticeMapper.removeNoticeFileByNoticeCode(userCode, noticeCodeAy);
			return noticeMapper.removeNoticeByNoticeCode(userCode, noticeCodeAy);
		}
		return 0;
	}

	/**
	 * @部门：上海软件研发中心 
	 * @功能：    实现Notice的新增/修改
	 * @描述：    noticeCode       公告代码
	 *        userCode        用户代码
	 *        notice          notice对象，存储数据
	 *        map	                     存储noticeFile文件
	 * @返回值：>0成功新增/修改一个或多个Notice信息 <=0未新增/修改
	 * @作成者：汤健 
	 * @作成时间：2018-12-17
	 */
	@Override
	public int save(NoticeDO noticeDO, List<NoticeFileDO> noticeFileList, String userCode ,String deiId) {
		// 判断noticeCode是否未空值或不存在，若为真则表示做新增操作
		if ("".equals(noticeDO.getNoticeCode()) || "null".equals(noticeDO.getNoticeCode())
				|| noticeDO.getNoticeCode() == null) {
			// 自动生成Code
			noticeDO.setNoticeCode(new AutoProduceCode().produceCode());
			noticeDO.setSortNo(0);
			insertNoticeFile(noticeDO, noticeFileList, userCode);
			return noticeMapper.insertNotice(noticeDO);
		}
		//若不为空，则做修改操作,先判断是否有附件的文件，若有则作新增附件操作
		insertNoticeFile(noticeDO, noticeFileList, userCode);
		// 判断是否有删除附件的id,若有则做删除id操作
		if(!deiId.isEmpty()){
			String[] delIdAy=deiId.split(",");
			noticeMapper.removeNoticeFileByNoticeFileCode(userCode, delIdAy);
		}
		return noticeMapper.updateNotice(noticeDO);
	}


	/**
	 * @部门：上海软件研发中心 
	 * @功能：    实现NoticeFile的新增
	 * @描述：    userCode        用户代码
	 *        noticeDO          notice对象，存储数据
	 *        noticeFileList	                     存储noticeFile文件
	 * @返回值：>0成功新增/修改一个或多个Notice信息 <=0未新增/修改
	 * @作成者：汤健 
	 * @作成时间：2018-12-20
	 */
	private void insertNoticeFile(NoticeDO noticeDO, List<NoticeFileDO> noticeFileList, String userCode) {
		if (!noticeFileList.isEmpty()) {
			for (NoticeFileDO noticeFileDO : noticeFileList) {
				noticeFileDO.setNoticeFileCode(new AutoProduceCode().produceCode());
				noticeFileDO.setNoticeCode(noticeDO.getNoticeCode());
				noticeFileDO.setCreateBy(userCode);
				noticeFileDO.setSortNo(0);
			}
			noticeMapper.insertNoticeFile(noticeFileList);
		}
	}
	/**
	 * @部门：上海软件研发中心 
	 * @功能：   实现 Notice的置顶（只能存在两条置顶）
	 * @描述：    noticeCode       公告代码
	 *        userCode        用户代码   
	 *        stickFlag       置顶标识
 	 * @返回值：>0 置顶/取消置顶成功 <0 未置顶/取消置顶
	 * @作成者：汤健 
	 * @作成时间：2018-12-18
	 */
	@Override
	public int updateNotice(String userCode, String noticeCode, String topFlag) {
		// 查询已置顶数目
		int stickCount = noticeMapper.countByTopFlag(userCode);
		// 若已有两条置顶且要做置顶操作,则返回标识-1,表示已有两条置顶,切勿再次置顶
		if (stickCount == 2 && "0".equals(topFlag)) {
			return -1;
		}
		if (stickCount > 2) {
			return -1;
		}
		return noticeMapper.updateNoticeTopFlag(userCode, noticeCode, topFlag);
	}

	
	



}
