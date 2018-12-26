package com.neusoft.srm.service.dept.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.mapper.dept.BizTypeDOMapper;
import com.neusoft.srm.model.dept.BizTypeDO;
import com.neusoft.srm.service.dept.BizTypeService;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期： 2018年12月18日
 * @功能描述：部门业务类型功能实现
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class BizTypeServiceImpl implements BizTypeService {
	/**
	 *  业务类型DAO
	 */
	@Autowired
	private BizTypeDOMapper bizTypeDOMapper;

	@Override
	public List<BizTypeDO> queryBizTypeList() {
		// 查询所有业务类型
		return bizTypeDOMapper.findListBizType();
	}

}
