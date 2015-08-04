package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

/*@WebServlet("/customer/notice") */
/*@WebServlet("/customer/noticeReg")*/
@MultipartConfig(
/*		location = "/temp",*/ // �ӽð� �ƴ϶� �ٷ� �ø��ڴٴ� ��
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024 * 1024,
		maxRequestSize = 1024 * 1024 * 5 *5)
public class NoticeRegController extends HttpServlet
{	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getMethod().equals("POST"))  // EQUAL or POST
		{
			// ��Ƽ ��Ʈ �� Ư�� �κ� ��� 
			// �����̵� ���ڿ��̵� �پ��ѳ��� ��..
			Part part = request.getPart("file");
			ServletContext application = request.getServletContext();
			
			//StringBuilder sb = new StringBuilder();
	/*		sb.append("D;\\File\\");
//			sb.append(..);
//			sb.toString()  // */	
//			String path = "D:\\File\\";  // ������ �̰� ���� �����
			
			//��Ŭ���� ������Ʈ ������ ���� ���� ���־�� ��Ŭ������ Tomcat�� ���� ���ִ� ������ �Ű� �ش�.
			//�̷��� �������ָ� Tomcat�� ��Ȯ�ϰ� �ν����� ���Ѵ�. ����ڰ� ÷���� ������ �� ��ο� ��,  
			//Tomcat�� �����ϴ� ��ο� �������� getRealPath�Լ��� ����ؾ� �Ѵ�.
			String url = "/customer/upload";  
			String path = application.getRealPath(url);
			String temp = part.getSubmittedFileName();
			String fname = temp.substring(temp.lastIndexOf("\\")+1); 
			String fpath = path + "\\" + fname;  // ���ڿ��� ���� ���� �ϸ� ���� ������
			
//			response.getWriter().println(fpath);

			InputStream ins = part.getInputStream();  // �Է�
			OutputStream outs = new FileOutputStream(fpath);  // ���
		
			byte[] ��� = new byte[1024];
			
			int len = 0; 
			while((len = ins.read(���, 0, 1024)) >= 0)
			{
				outs.write(���, 0, len);
			}
			
			outs.flush();
			outs.close();
			ins.close();
			
			String title = request.getParameter("title");
			String file = request.getParameter("file");
			String content = request.getParameter("content");
			
			Notice notice = new Notice();
			NoticeFile noticeFile = new NoticeFile();
			
			notice.setTitle(title);
			notice.setWriter("newlec");
			notice.setContent(content);
			
			response.getWriter().println(title);

			NoticeDao noticeDao = new MybatisNoticeDao();
			noticeDao.addNotice(notice);
		
			NoticeFileDao noticeFileDao = new MybatisNoticeFileDao();
			noticeFile.setName(fname); //��δ� ������ �ֱ� ������ ���� �ټ��� ����. 
			noticeFile.setNoticeCode(noticeDao.getLastCode());  // �ٸ��� ���Ե��� �ʰ� �ϱ� �ϳ��� Ʈ��������� ����� ��!! 
			noticeFileDao.addNoticeFile(noticeFile);
			
			//notice.jsp �������� �̵�
			//response.sendRedirect("notice.jsp"); jsp��û�ϸ� �����⸸ ���� �����Ͱ� �߿��ѵ�!!
			
			// �ٸ� ��Ʈ�ѷ��� ��û�ϱ� ���ؼ� Redirect���� ���̰� �����Ⱑ �ƴ� �����͸� �����;� �ϴϱ�
			// ��Ʈ�ѷ��� ȣ���ϴ� ���̴�. 
			response.sendRedirect("notice"); 
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/noticeReg.jsp");
		  	dispatcher.forward(request, response);
		}
	}
}
