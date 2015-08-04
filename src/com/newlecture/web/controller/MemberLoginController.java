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
			// null 값을 post 하지 않음 그래서 임시변수 표시인 언더바를 붙이지 않음
			String uid = request.getParameter("uid");
			String pwd = request.getParameter("pwd");
			
			MemberDao memberDao = new MybatisMemberDao();
			Member member = memberDao.getMember(uid);
			
			if(member == null)
			{
				// "error" 키값을 request 상태변수에 넣고 
				request.setAttribute("error", "제대로 입력 하세요... --^");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(
						"/WEB-INF/joinus/login.jsp");
				dispatcher.forward(request, response);
			}
			else if(!member.getPwd().equals(pwd))
			{
				//비번 메세지 보냄
				request.setAttribute("error", "제대로 입력 하세요... --^");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(
						"/WEB-INF/joinus/login.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
				// 인증 성공
				// 메인 페이지 or 마이 페이지로 가야함
				// 현재 조이너스 디렉토리에 있음
				HttpSession session = request.getSession();
				session.setAttribute("uid", uid);
				response.sendRedirect("../customer/notice");
			//	WebContent\WEB-INF\view\customer
			}
		}
		else // 의미가 무엇일까?? 왜 주석 처리 했는데도 오류가 안나지??
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/joinus/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}
