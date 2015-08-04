package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MyPage")
public class MyPage extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
																									throws ServletException, IOException 
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8"); 
		
		PrintWriter out = response.getWriter();
		
		int app = 0; 
		int ss = 0; 
		int ck = 0; 

		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		
		Cookie[] cookies = request.getCookies();
		String _c = "";
		
		if(cookies != null)
		{
			for(Cookie cookie : cookies)
			{
				if("c".equals(cookie.getName()))
				{
					_c = cookie.getValue();
				}
			}
		}
		
		Object _a = application.getAttribute("a");
		Object _s = session.getAttribute("s");
		
		
		if(_a != null && !(_a.equals("")))
		{
			app =  (int)_a;
		}

		if(_s != null && (!_s.equals("")))
		{
			ss = (int)_s; 
		}
		
		if(_c != null && (!_c.equals("")))
		{
			ck = Integer.parseInt(_c); 
		}
		
		out.printf("Application : %d", app);
		out.printf("Session : %d", ss);
		out.printf("Cookie : %d", ck);
	}
}
