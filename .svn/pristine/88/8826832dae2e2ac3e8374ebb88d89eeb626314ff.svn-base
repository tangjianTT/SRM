package com.neusoft.srm.service.navigation;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.model.navigation.WebSiteDO;

/**
 * @部门：上海软件研发中心
 * @功能： WebSite的查询分页/条件查询分页,一个或多个WebSite的删除（假删）,统计查询/条件查询数据的总条数（除开删除标记为1）
 * @描述： WebSiteService接口
 * @作成者：汤健 
 * @作成时间：2018-12-12
 * @author TJ
 */
public interface WebSiteService {

	/**
	 * @部门：上海软件研发中心
	 * @功能： WebSite的查询分页/条件查询分页
	 * @描述： webSiteName    webSite名称
	 *      pageNo         页数
	 *      pageSize       页面大小
	 * @返回值：PageInfo<Map装载数据>
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	public PageInfo<WebSiteDO> getList(String webSiteName,int pageNo,int pageSize);

	/**
	 * @部门：上海软件研发中心
	 * @功能：一个或多个AppSite的删除（假删）
	 * @描述：   userCode       用户代码
	 *       delDate       删除日期
	 *       webSiteCode    webSite代码  
	 * @返回值：>0成功假删一个或多个AppSite信息 <=0未假删
	 * @作成者：汤健 
	 * @作成时间：2018-12-12
	 */
	public int delete(String userCode,String webSiteCode);
	
}
