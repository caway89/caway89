package com.newlecture.web.dao;

import java.util.List;

import com.newlecture.web.vo.NoticeFile;

public interface NoticeFileDao 
{
	// add�� �ߵǾ����� ���ڷ� ��ȯ���־�� ������� ��Ȳ �� �� ����
	public int addNoticeFile(NoticeFile noticeFile); 
	public List<NoticeFile> getNoticeFilesOfNotice(String code);
}
