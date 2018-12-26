package com.neusoft.srm.service.dept.impl;

import java.util.*;

import com.neusoft.srm.mapper.dept.DeptDOMapper;
import com.neusoft.srm.model.common.Tree;
import com.neusoft.srm.model.common.TreeState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.mapper.dept.DeptBizTypeMapper;
import com.neusoft.srm.model.dept.DeptBizTypeDO;
import com.neusoft.srm.model.dept.DeptDO;
import com.neusoft.srm.service.dept.DeptService;
import com.neusoft.srm.util.AutoProduceCode;
import com.neusoft.srm.util.ResponseCode;

/**
 * @部门： 软件开发事业部
 * @作成者： 刘昊鑫
 * @author:HaoXin.Liu
 * @开发日期：2018年12月7日
 * @功能描述：部门功能实现类
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class DeptServiceImpl implements DeptService {
	private static final Logger log = LoggerFactory.getLogger(DeptServiceImpl.class);
	/**
	 * 部门Mapper接口
	 */
	@Autowired
	private DeptDOMapper deptMapper;
	/**
	 * 部门业务接口
	 */
	@Autowired
	private DeptBizTypeMapper deptBizTypeMapper;

	@Override
	public List<DeptDO> queryAllDeptList() {
		// 获取部门所有信息
		List<DeptDO> deptDOList = deptMapper.findListDept();
		return deptDOList;
	}

	@Override
	public int addDept(DeptDO deptDO, String bizType, String lastModifiedBy) {
		// 批量逻辑删除部门业务类型
		int delBizAndDept = deptBizTypeMapper.deleteBizTypeAndDeptByDeptCode(deptDO.getDeptCode(), lastModifiedBy);
		// 获取业务类型字段
		String[] bizTypeAy = bizType.split(",");
		// 设置AuthCode
		this.setDeptAuthCodeByDeptDO(deptDO);
		log.info(deptDO.getAuthCode());
		// 判断更新或新增代码 没有部门编码
		if (null == deptDO.getDeptCode() || "".equals(deptDO.getDeptCode())) {
			// 获取部门编号
			AutoProduceCode autoProduceCode = new AutoProduceCode();
			String code = autoProduceCode.produceCode();
			log.info(code);
			deptDO.setDeptCode(code);
			// 新增部门
			int deptType = deptMapper.insertDept(deptDO);
			// 新增部门和业务关系表
			int insertBizType = deptBizTypeMapper.insertBatchBizTypeAndDept(new DeptBizTypeDO(deptDO), bizTypeAy);
			return deptType;
		}
		// 更新部门
		int deptType = deptMapper.updateDept(deptDO);
		// 更新部门和业务关系表
		int insertBizType = deptBizTypeMapper.insertBatchBizTypeAndDept(new DeptBizTypeDO(deptDO), bizTypeAy);
		return deptType;
	}

	@Override
	public int removeDept(String deptCode, String lastModifiedBy) {
		int countDeptUser = deptMapper.countDeptUserByDeptCodAndAuthCode(deptCode);
		log.info(countDeptUser + "");
		// 判断部门和子部门 是否有员工
		if (countDeptUser > 0) {
			return -1;
		}
		// 根据编号 逻辑删部门 和子部门
		int delDeptType = deptMapper.deleteDeptByDeptCode(deptCode, lastModifiedBy);
		// 根据部门编号 删除部门和 业务类型关系表
		int deptBizType = deptBizTypeMapper.deleteBizTypeAndDeptByDeptCode(deptCode, lastModifiedBy);
		return delDeptType;
	}

	@Override
	public Tree getAllDept(String deptRoot) {
		List<Map<String, String>> list = deptMapper.getAllDept();
		Tree rootTree = new Tree();
		initTree(rootTree, list, deptRoot);
		return rootTree;
	}

	/**
	 * @功能描述：
	 * @部门：上海软件研发中心
	 * @作者：武京阳
	 * @时间：2018/12/14
	 */
	@Override
	public List<Map<String, String>> getDeptTypeList() {
		return deptMapper.getDeptTypeList();
	}

	/**
	 * @功能描述：
	 * @部门：上海软件研发中心
	 * @作者：武京阳
	 * @时间：2018/12/14
	 */
	@Override
	public int removeDept(String deptCode) {
		deptMapper.countUserUnderDept(deptCode);
		// TODO 暂未完成
		return 0;
	}

	/**
	 * @功能描述：
	 * @部门：上海软件研发中心
	 * @作者：武京阳
	 * @时间：2018/12/14
	 */
	private void initTree(Tree rootTree, List<Map<String, String>> allMenus, String selfCode) {
		Iterator<Map<String, String>> menuIterator = allMenus.iterator();
		while (menuIterator.hasNext()) {
			Map<String, String> tmp = menuIterator.next();
			// 初始化自身节点
			if (tmp.get("DEPT_CODE").equals(selfCode)) {
				deptToTree(tmp, rootTree);
			} else if (tmp.get("PARENT_DEPT_CODE").equals(selfCode)) {
				// 初始化子节点
				Tree children = new Tree();
				deptToTree(tmp, children);
				if (null != children.getId()) {
					if (null == rootTree.getChildren()) {
						rootTree.setChildren(new ArrayList<Tree>());
					}
					rootTree.getChildren().add(children);
				}
				// 递归
				initTree(children, allMenus, tmp.get("DEPT_CODE"));
			}
		}
	}

	/**
	 * @功能描述：
	 * @部门：上海软件研发中心
	 * @作者：武京阳
	 * @时间：2018/12/14
	 */
	private void deptToTree(Map<String, String> menu, Tree tree) {
		tree.setId(menu.get("DEPT_CODE"));
		tree.setLabel(menu.get("DEPT_NAME"));
		tree.setAttributes(menu);
		TreeState state = new TreeState();
		if (null != menu.get("CHECKED") && "Y".equals(menu.get("CHECKED"))) {
			state.setChecked(true);
		}
		if (null != menu.get("SELECTED") && "Y".equals(menu.get("SELECTED"))) {
			state.setSelected(true);
		}
		tree.setState(state);
	}

	/**
	 * 
	 * @部门：上海软件研发中心
	 * @功能：设置部门AuthCode编码
	 * @描述：deptDO 部门封装类
	 * @返回值：
	 * @作成者：刘昊鑫
	 * @作成时间： 2018年12月17日
	 */
	private void setDeptAuthCodeByDeptDO(DeptDO deptDO) {
		// 判断部门类型
		if (ResponseCode.DEPT_PARENT_CODE_ROOT_TYPE.equals(deptDO.getParentDeptCode())) {
			deptDO.setAuthCode(deptDO.getDeptCode());
			return;
		}
		// 获取通过父节点查询父类部门信息
		DeptDO parentDept = deptMapper.queryParentDeptByParentDeptCode(deptDO.getParentDeptCode());
		// 判断父类部门状态
		if (ResponseCode.DEPT_PARENT_CODE_ROOT_TYPE.equals(parentDept.getParentDeptCode())) {
			// 第一级别
			deptDO.setAuthCode(deptDO.getDeptCode() + "000");
			return;
		}
		// 找到父节点下面子节点的最大值
		String maxDeptAuthCode = deptMapper.queryMaxAuthCodeByParentDeptCode(deptDO.getParentDeptCode());
		// 其他级别 设置
		deptDO.setAuthCode(String.valueOf((Integer.parseInt(maxDeptAuthCode) + 1)));
		return;
	}

}
