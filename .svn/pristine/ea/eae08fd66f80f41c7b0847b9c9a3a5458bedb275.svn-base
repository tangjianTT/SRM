package com.neusoft.srm.controller.upload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.srm.annotation.LogOperat;
import com.neusoft.srm.enumeration.LogType;
import com.neusoft.srm.enumeration.OperaLogType;
import com.neusoft.srm.util.ServerResponse;

/**
 * @部门：上海软件研发中心
 * @功能：文件的上传
 * @描述：文件上传下载控制器
 * @作成者：汤健 
 * @作成时间：2018-12-21
 * @author TJ
 */
@RestController
@RequestMapping("/srm")
public class UploadController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @部门：上海软件研发中心
	 * @功能：文件的上传 
	 * @描述： 文件的上传
	 * @返回值：文件上传的结果（JSON） 
	 * @作成者：汤健 
	 * @作成时间：2018-12-21
	 */
	@LogOperat(detail = "文件上传", logType = LogType.ACCESS, operationType = OperaLogType.UNKNOWN)
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/uploadFile")
	public ServerResponse uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		// 定义文件路径
		String filePath;
		// 定义文件名称
		String fileName;
			if (file != null) {
				// 文件保存路径
				filePath = "C:/upload/" + file.getOriginalFilename();
				fileName = file.getOriginalFilename();
				// 转存文件
				try {
					file.transferTo(new File(filePath));
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
					return ServerResponse.createByErrorMessage("文件上传失败");
				}
				Map<String, Object> map = new HashMap<>(0);
				map.put("url", filePath);
				map.put("fileName", fileName);

				return ServerResponse.createBySuccess("文件上传成功", map);
			} else {
				return ServerResponse.createByErrorMessage("空文件");
			}
	}

}
