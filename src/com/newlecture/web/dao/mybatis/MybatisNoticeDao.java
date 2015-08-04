package com.newlecture.web.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.Notice;

public class MybatisNoticeDao implements NoticeDao
{
	//SqlSessionFactory factory = new SqlNewlecSessionFactory().getSqlSessionFactory();
	//ĸ��ȭ ����
	//@Autowired
	SqlSession session;
	
	@Autowired
	public void setSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public List<Notice> getNotices(int page, String field, String query) 
	{
		NoticeDao dao = session.getMapper(NoticeDao.class);
//		NoticeFileDao fileDao = session.getMapper(NoticeFileDao.class);
		NoticeFileDao fileDao = new MybatisNoticeFileDao();
	
		
//		List<Notice> list = dao.getNotices(page, field, query);
		List<Notice> list = dao.getNotices(page, field, query);
		
		for(Notice n : list)
			n.setNoticeFiles(fileDao.getNoticeFilesOfNotice(n.getCode()));
		
//		return dao.getNotices(1, "TITLE", "");
		return list;
		//dao ������� 
	}

	@Override
	public Notice getNotice(String code) 
	{
//		SqlSession session = factory.openSession();
		NoticeDao dao = session.getMapper(NoticeDao.class);
		
		Notice notice = dao.getNotice(code); 
		
		return notice;
	}
	
	// �Ź� ���� �ֱ� �Ⱦ� 
	@Override
	public List<Notice> getNotices(int page) 
	{
//		SqlSession session = factory.openSession();
//		NoticeDao dao = session.getMapper(NoticeDao.class);
//		
//		return dao.getNotices(page);
		
		return getNotices(page,"TITLE","");
	}

	@Override
	public List<Notice> getNotices() 
	{
//		SqlSession session = factory.openSession();
//		NoticeDao dao = session.getMapper(NoticeDao.class);
//		
//		return dao.getNotices();
		
		return getNotices(1,"TITLE","");
	}
	
	@Override
	public int addNotice(Notice notice) 
	{
		int result = 0; 
		
		try
		{
			NoticeDao dao = session.getMapper(NoticeDao.class);
			result = dao.addNotice(notice);
//			session.commit();
		}
		finally
		{
//			session.rollback();
/*			session.close();*/
		}
		return result;
	}

	@Override
	public String getLastCode() 
	{
		// �ʿ��� �������� �ҷ����� ��Ȱ
//		SqlSession session = factory.openSession();  
		NoticeDao dao = session.getMapper(NoticeDao.class);
//		String code = session.selectOne("getLastCode");
		return dao.getLastCode(); 
	}
}
