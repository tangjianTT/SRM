package com.neusoft.srm.service.dict.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LoginOperationType;
import com.neusoft.srm.mapper.dict.DictSubDOMapper;
import com.neusoft.srm.model.dict.DictSubDO;
import com.neusoft.srm.service.dict.DictSubService;
import com.neusoft.srm.util.AutoProduceCode;

/**
 * 
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月18日
 * @功能描述：子字典服务接口实现
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class DictSubServiceImpl implements DictSubService {
	@Autowired
	private DictSubDOMapper dictSubDOMapper;

	@Override
	public List<DictSubDO> querySubDictListByDictMainCode(String dictMainCode) {
		// 通过主字典编码查询子字典集合
		List<DictSubDO> dictSubList = dictSubDOMapper.selectSubDictListByDictMainCode(dictMainCode);
		return dictSubList;
	}

	@Override
	public DictSubDO querySubDictListByDictSubCode(String dictSubCode) {
		// 通过子字典编码查询一条子字典数据
		DictSubDO dictSubDO = dictSubDOMapper.selectSubDictByDictSubCode(dictSubCode);
		return dictSubDO;
	}

	@Override
	public Integer addOrModifyDictSub(DictSubDO dictSub, String userCode) {
		// 判断更新或新增代码 没有子字典编码
		if (null == dictSub.getDictSubCode() || "".equals(dictSub.getDictSubCode())) {
			// 新增子字典信息
			AutoProduceCode autoProduceCode = new AutoProduceCode();
			String dictSubCode = autoProduceCode.produceCode();
			dictSub.setDictSubCode(dictSubCode);
			// 字典信息插入数据库
			int insertNum = dictSubDOMapper.insertDictSub(dictSub, userCode);
			return insertNum;
		}
		// 修改信息
		int updateNum = dictSubDOMapper.updateDictSub(dictSub, userCode);
		return updateNum;
	}

	@Override
	public Integer delBatchDictSubByDictSubCodeList(String dictSubCodeList, String userCode) {
		if (dictSubCodeList == null) {
			return 0;
		}
		// 分割字符串
		String[] dictMainCodeAy = dictSubCodeList.split(",");
		// 批量删除子字典信息
		int dictSubNum = dictSubDOMapper.delBatchDictSubByDictSubCodeAy(dictMainCodeAy, userCode);
		return dictSubNum;
	}

}
