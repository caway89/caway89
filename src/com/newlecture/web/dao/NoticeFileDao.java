package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.vo.NoticeFile;

public interface NoticeFileDao 
{
	// add가 잘되었는지 숫자로 반환해주어야 결과물에 상황 알 수 있음
	public int addNoticeFile(NoticeFile noticeFile); 
	public List<NoticeFile> getNoticeFilesOfNotice(String code);
}
