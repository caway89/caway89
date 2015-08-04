package com.newlecture.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.vo.Notice;

public class NoticeConsole 
{
	private NoticeDao noticeDao;
	
	@Autowired // Spring 타입으로 검색
/*	@Resource(name="noticeDao1")*/
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}// 이건 좋은데 또 메인쪽에서 꽂아 줘야 하니까 귀찮아짐
	
	public void print()
	{
		// 강한 결합 이러면 코드 수정해야함...
		// NoticeDao noticeDao = new MybatisNoticeDao(); 
		
		List<Notice> list = noticeDao.getNotices();
		
		for(Notice n :list)
		{
			System.out.printf("title : %s%n", n.getTitle());
		}
	}
}
