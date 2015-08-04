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
/*		location = "/temp",*/ // 임시가 아니라 바로 올리겠다는 뜻
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
			// 멀티 파트 중 특정 부분 얻기 
			// 파일이든 문자열이든 다양한놈이 옴..
			Part part = request.getPart("file");
			ServletContext application = request.getServletContext();
			
			//StringBuilder sb = new StringBuilder();
	/*		sb.append("D;\\File\\");
//			sb.append(..);
//			sb.toString()  // */	
//			String path = "D:\\File\\";  // 지금은 이게 빠름 상대경로
			
			//이클립스 프로젝트 내에서 폴더 생성 해주어야 이클립스가 Tomcat에 서비스 해주는 폴더로 옮겨 준다.
			//이렇게 지정해주면 Tomcat이 정확하게 인식하지 못한다. 사용자가 첨부한 파일을 위 경로에 즉,  
			//Tomcat이 배포하는 경로에 넣으려면 getRealPath함수를 사용해야 한다.
			String url = "/customer/upload";  
			String path = application.getRealPath(url);
			String temp = part.getSubmittedFileName();
			String fname = temp.substring(temp.lastIndexOf("\\")+1); 
			String fpath = path + "\\" + fname;  // 문자열을 더셋 많이 하면 성능 떨어짐
			
//			response.getWriter().println(fpath);

			InputStream ins = part.getInputStream();  // 입력
			OutputStream outs = new FileOutputStream(fpath);  // 출력
		
			byte[] 대야 = new byte[1024];
			
			int len = 0; 
			while((len = ins.read(대야, 0, 1024)) >= 0)
			{
				outs.write(대야, 0, len);
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
			noticeFile.setName(fname); //경로는 정해져 있기 때문에 따로 줄수가 없다. 
			noticeFile.setNoticeCode(noticeDao.getLastCode());  // 다른놈 개입되지 않게 하기 하나의 트랜잭션으로 묶어야 함!! 
			noticeFileDao.addNoticeFile(noticeFile);
			
			//notice.jsp 페이지로 이동
			//response.sendRedirect("notice.jsp"); jsp요청하면 껍데기만 나옴 데이터가 중요한데!!
			
			// 다른 컨트롤러를 요청하기 위해서 Redirect쓰는 것이고 껍데기가 아닌 데이터를 가져와야 하니까
			// 컨트롤러를 호출하는 것이다. 
			response.sendRedirect("notice"); 
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/noticeReg.jsp");
		  	dispatcher.forward(request, response);
		}
	}
}
