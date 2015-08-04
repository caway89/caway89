package com.newlecture.web.dao.mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.NoticeFile;

public class MybatisNoticeFileDao implements NoticeFileDao
{
//	SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();

	@Autowired
	SqlSession session;
	
	@Override
	public int addNoticeFile(NoticeFile noticeFile) 
	{
		int result = 0; 
//		SqlSession session = factory.openSession();
		
		try
		{
			NoticeFileDao dao = session.getMapper(NoticeFileDao.class);
			result = dao.addNoticeFile(noticeFile);
/*			session.commit();*/
		}
		finally
		{
/*			session.rollback();*/
/*			session.close();*/
		}
		return result;
	}
	
	public List<NoticeFile> getNoticeFilesOfNotice(String code)
	{
		List<NoticeFile> list = new ArrayList<NoticeFile>();
		NoticeFile file = new NoticeFile();
		file.setName("����1");
		list.add(file);
		
		file = new NoticeFile();
		file.setName("����2");
		list.add(file);
		
		return list;
		
/*	  NoticeFileDao dao = (NoticeFileDao)session.getMapper(NoticeFileDao.class);
	      List<NoticeFile> list = dao.getNoticeFilesOfNotice(code);
	      session.close();
	      
	      return list;*/
	}
}
