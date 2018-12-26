package com.neusoft.srm.mapper.navigation;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.neusoft.srm.model.navigation.WebSiteDO;

/**
 * @部门：上海软件研发中心
 * @功能：  WebSite的查询（条件查询）,删除（假删）,统计数目（查询全部/条件查询）
 * @描述： WebSiteMapper
 * @作成者：汤健 
 * @作成时间：2018-12-12
 * @author TJ
 */
@Mapper
public interface WebSiteMapper {

	/**
	 * @部门：上海软件研发中心
	 * @功能：   WebSite的分页查询（条件查询）
	 * @描述： webSiteName    web名称
	 *      pageNo         页数
	 *      pageSize       页面大小
	 * @返回值：List集合 装载WebSite对象,进行条件查询及其分页操作
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	public List<WebSiteDO> findList(@Param(value = "webSiteName") String webSiteName);

	/**
	 * @部门：上海软件研发中心
	 * @功能：根据传入的webSiteCode进行删除（假删，更改状态值）
	 * @描述： userCode       操作人代码
	 *      delDate        删除日期
	 *      webSiteCode    webSite代码数组
	 * @返回值：>0 表示已更新的行数 <=0 未更新
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	public int remove(@Param(value="userCode")String userCode,@Param(value="webSiteCode")String... webSiteCode);

}
