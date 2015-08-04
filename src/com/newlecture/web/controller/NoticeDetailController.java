package com.newlecture.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.vo.Notice;

/*@WebServlet("/customer/notice") */
/*@WebServlet("/customer/noticeDetail")*/
public class NoticeDetailController extends HttpServlet
{	
	/*private static final long serialVersionUID = 1L;*/
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
/*		HttpSession session = request.getSession();
		// �������� �ڼ��Ѱ� ������ ���� 
		if(session.getAttribute("uid") ==null)
		{
			request.setAttribute("no", "ȸ���� �ƴϸ� �� �� �����ϴ�.");
			response.sendRedirect("notice?error=1");
		}//�갡 ��������� �� ������ ����??  
*/	
		
	    NoticeDao noticeDao = new MybatisNoticeDao();
		String code = request.getParameter("c");
		
	    String codePlus = null; 
	    String codeMinus = null; 
	    
	    int convrtCode = 0; 
	    int codePlusInt = 0; 
	    int codeMinusInt = 0; 
	    
	    if(code != null)
	    {
	    	convrtCode = Integer.parseInt(code);
	    	
	    	codePlusInt = convrtCode + 1; 
	    	codeMinusInt = convrtCode - 1; 
	    	
	    	codePlus = Integer.toString(codePlusInt);
	    	codeMinus = Integer.toString(codeMinusInt);
	   
	    	Notice nPlus = noticeDao.getNotice(codePlus);
	    	request.setAttribute("plus", nPlus); 
	    	
	    	Notice nMinus = noticeDao.getNotice(codeMinus);
	    	request.setAttribute("minus", nMinus); 
	    }
		
		// Notice: �˸��� 
	    Notice n = noticeDao.getNotice(code);
	    
		// ��Ʈ�ѷ����� request�� ��´�. 
	 	request.setAttribute("n", n); 
	 	
 		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/noticeDetail.jsp");
 		dispatcher.forward(request, response);
	 	return; 
	}
}
