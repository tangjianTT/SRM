package com.neusoft.srm.service.notice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.neusoft.srm.model.notice.NoticeDO;
import com.neusoft.srm.model.notice.NoticeFileDO;
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeServiceTest {
	@Autowired public NoticeService noticeService;
	@Test
	public void testGetList() {
		String [] userCode={"2018062812582159160"};
		 PageInfo<Map<String,Object>> li= noticeService.getList(userCode, "", "", "", "", "", 1, 10);
	        for (Map<String, Object> map : li.getList()) {
	        	System.out.println(map.values());
			}
	}
	
	@Test
	public void testDelete() {
	/*	System.out.println(noticeService.de);*/
		/*SELECT * FROM T_INTERACT_NOTICE_FILE WHERE NOTICE_FILE_CODE="2018072713363006389"
				
				UPDATE T_INTERACT_NOTICE_FILE SET DEL_FLAG=0 WHERE NOTICE_FILE_CODE="2018072713363006389"
				   
			UPDATE T_INTERACT_NOTICE SET del_flag=0 WHERE USER_CODE="2018061213563095559"*/
	}

	@Test
	public void testSave() {
		NoticeDO noticeDO=new NoticeDO();
		noticeDO.setBizTypeCode("1");
		noticeDO.setCreateBy("111");
		noticeDO.setDeptCode("222");
		noticeDO.setNoticeContent("wwww");
		noticeDO.setUserCode("123456");
		noticeDO.setNoticeTitle("嘻嘻");
		noticeDO.setNoticeKeyword("jaha");
		noticeDO.setPostCode("555");
		noticeDO.setAuthCode("666");
		noticeDO.setSortNo(111);
		
	/*	NoticeFileDO no=new NoticeFileDO();
		no.setNoticeFileName("tttjjj");
		no.setNoticeFileUrl("wwww.baidu,com");
		no.setSortNo(1111);
		
		NoticeFileDO no1=new NoticeFileDO();
		no1.setNoticeFileName("cccffff");
		no1.setNoticeFileUrl("w22du,com");
		no1.setSortNo(1111);
		
		NoticeFileDO no2=new NoticeFileDO();
		no2.setNoticeFileName("aaawewe");
		no2.setNoticeFileUrl("www213213idu,com");
		no2.setSortNo(1111);
		noticeFileList.add(no);
		noticeFileList.add(no1);
		noticeFileList.add(no2);*/
		List<NoticeFileDO> noticeFileList=new ArrayList<>();
		/*noticeService.save(noticeDO, noticeFileList, "999");*/
	}

}
