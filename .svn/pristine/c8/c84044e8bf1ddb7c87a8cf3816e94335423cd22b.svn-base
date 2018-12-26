package com.neusoft.srm.service.dict.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LoginOperationType;
import com.neusoft.srm.mapper.dict.DictMainDOMapper;
import com.neusoft.srm.mapper.dict.DictSubDOMapper;
import com.neusoft.srm.model.dict.DictMainDO;
import com.neusoft.srm.service.dict.DictMainService;
import com.neusoft.srm.util.AutoProduceCode;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月17日
 * @功能描述：字典主表服务实现类
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class DictMainServiceImpl implements DictMainService {
	@Autowired
	DictMainDOMapper dictMainDOMapper;
	@Autowired
	DictSubDOMapper dictSubDOMapper;

	@Override
	public PageInfo<DictMainDO> queryMainDictByCond(String lableKey, String lableName, String pageNo, String pageSize) {
		// 页码和分页跨度 转换成 整数
		Integer newPageNo = Integer.parseInt(pageNo);
		Integer newpageSize = Integer.parseInt(pageSize);
		// 分页操作
		PageHelper.startPage(newPageNo, newpageSize);
		List<DictMainDO> dictMainList = dictMainDOMapper.findAllMainDictByCond(lableKey, lableName);
		PageInfo<DictMainDO> pageInfo = new PageInfo<>(dictMainList);
		return pageInfo;
	}

	@Override
	public DictMainDO queryOneMainDictByDictMainCode(String dictMainCode) {
		// 查询一条数据
		DictMainDO dictMainDO = dictMainDOMapper.findOneMainDiceByDictMainCode(dictMainCode);
		return dictMainDO;
	}

	@Override
	public Integer addOrModifyDictMain(DictMainDO dictMainDO, String userCode) {
		// 判断更新或新增代码 没有主字典编码
		if (null == dictMainDO.getDictMainCode()||"".equals(dictMainDO.getDictMainCode())) {
			// 新增主字典信息
			AutoProduceCode autoProduceCode = new AutoProduceCode();
			String dictMainCode = autoProduceCode.produceCode();
			dictMainDO.setDictMainCode(dictMainCode);
			// 字典信息插入数据库
			int insertNum = dictMainDOMapper.insertDictMain(dictMainDO, userCode);
			return insertNum;
		}
		// 修改信息
		int updateNum = dictMainDOMapper.updateDictMain(dictMainDO, userCode);
		return updateNum;
	}

	@Override
	public Integer delBatchDictMainByDictMainCodeList(String dictMainCodeList, String userCode) {
		if (dictMainCodeList == null) {
			return 0;
		}
		// 分割字符串
		String[] dictSubCodeAy = dictMainCodeList.split(",");
		// 批量删除主字典信息
		int dictMainNum = dictMainDOMapper.delBatchDictMainByDictMainCodeAy(dictSubCodeAy, userCode);
		// 批量删除子字典信息
		int dictSubNum = dictSubDOMapper.delBatchDictSubByDictMainCodeAy(dictSubCodeAy, userCode);
		return dictMainNum;
	}

}
