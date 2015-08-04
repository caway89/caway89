package com.newlecture.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.dao.mybatis.MybatisMemberDao;
import com.newlecture.web.vo.Member;

/*@WebServlet("/joinus/login")*/
public class MemberLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getMethod().equals("POST"))  // EQUAL or POST
		{
			// null ���� post ���� ���� �׷��� �ӽú��� ǥ���� ����ٸ� ������ ����
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			
			MemberDao memberDao = new MybatisMemberDao();
			Member member = memberDao.getMember(uid);
			
			if(member == null)
			{
				// "error" Ű���� request ���º����� �ְ� 
				request.setAttribute("error", "����� �Է� �ϼ���... --^");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(
						"/WEB-INF/joinus/login.jsp");
				dispatcher.forward(request, response);
			}
			else if(!member.getPwd().equals(pwd))
			{
				//��� �޼��� ����
				request.setAttribute("error", "����� �Է� �ϼ���... --^");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(
						"/WEB-INF/joinus/login.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				// ���� ����
				// ���� ������ or ���� �������� ������
				// ���� ���̳ʽ� ���丮�� ����
				HttpSession session = request.getSession();
				session.setAttribute("uid", uid);
				response.sendRedirect("../customer/notice");
			//	WebContent\WEB-INF\view\customer
			}
		}
		else // �ǹ̰� �����ϱ�?? �� �ּ� ó�� �ߴµ��� ������ �ȳ���??
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/joinus/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
