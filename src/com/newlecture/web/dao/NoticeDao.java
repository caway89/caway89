package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.vo.Notice;

public interface NoticeDao 
{
	public List<Notice> getNotices(int page, String field, String query);
	public List<Notice> getNotices(int page);
	public List<Notice> getNotices();
	public Notice getNotice(String code);

	// add가 잘되었는지 숫자로 반환해주어야 결과물에 상황 알 수 있음
	public int addNotice(Notice notice);
	public String getLastCode();
}
