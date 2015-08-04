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

@WebServlet("/add")
public class Add extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html); charset=UTF-8"); 
		
		int x = 0; 
		int y = 0; 
		int result = x + y; 
		
		PrintWriter out = response.getWriter();
		String _result = request.getParameter("result");
		
		if(_result != null)
		{
			result = Integer.parseInt(_result);
		}
		
		// POST �϶� 
		if(request.getMethod().equals("POST"))
		{
			String _btn = request.getParameter("btn");

			if(_btn.equals("application"))
			{
				// �������� �� ����
				ServletContext application = request.getServletContext();
				application.setAttribute("a", result);
			
				out.write("<p>application �� ���� �Ϸ�</p>");
			}
			else if(_btn.equals("session"))
			{
				// �������� �� ����
				HttpSession session = request.getSession();
				session.setAttribute("s", result);
				
				out.write("<p>session �� ���� �Ϸ�</p>");
			}
			else if(_btn.equals("cookie"))
			{
				// ������ ��Ű�� �� ����
				Cookie cookie = new Cookie("c", String.valueOf(result));
				cookie.setMaxAge(24*60*60);  // 0���� �ϸ� ��Ű ���� ��
				response.addCookie(cookie);
				
				out.write("<p>cookie �� ���� �Ϸ�</p>");
			}
			else
			{
				String _x =  request.getParameter("x");
				String _y =  request.getParameter("y");
				
				if(_x != null && !(_x.equals("")) && _y != null && (!_y.equals("")))
				{
					x = Integer.parseInt(_x);
					y = Integer.parseInt(_y);
					
				}
			}
			result = x + y; 
		}

		// HTML->JSP�� �ϸ� ���� �̷��� ������ ���� �ʾƵ� ��..
		out.write("<form action=\"add\" method=\"post\">");
		out.write("	<ul>");
		out.write("		<li><label for='x'>X:</label><input name='x'/></li>"); // name 
		out.write("		<li><label for='y'>Y:</label><input name='y'/></li>");
		out.write("	</ul>");
		out.write("		<input type=\"submit\"  name=\"btn\" value=\"����\"/></p>");
		out.write("	    <p> ");
		out.printf("          <input type=\"hidden\" name=\"result\" value=\"%d\" />", result);
		out.write("           <input type=\"submit\" name=\"btn\" value=\"application\" />");
		out.write("           <input type=\"submit\" name=\"btn\" value=\"session\" />");
		out.write("           <input type=\"submit\" name=\"btn\" value=\"cookie\" />");
		out.write("      </p>");
		out.write("</form>");
		out.printf("���� ����� : %d<br/>", result);
		out.println("<a href=\"MyPage\">����������</a>");
//		out.println(result);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
																									throws ServletException, IOException 
	{
		service(request, response);
		
//		String _cnt = request.getParameter("cnt");
//		
//		int cnt = 10;
//		
//		if(_cnt != null && _cnt.equals(""))
//			cnt = Integer.parseInt(_cnt);
//		
//		response.setCharacterEncoding("UTF-8"); // ����, ��� �� �� UTF-8 ������� ����
//		// � ���ڸ� ǥ������ �������� �˷��ش� �׷��� ���������� � ���ڸ� ����϶�� �˷��ش�.
//		response.setContentType("text/html; charset=UTF-8"); 
//		
//		PrintWriter out = response.getWriter();
////		
///*		for(int i=0; i < cnt; i++)
//			out.println("Hello Servlet �ѱ۵� �ǳ�?? <br />");*/
//		out.write("<form action=\"add\" method=\"post\">");
//		out.write("	<ul>");
//		out.write("		<li><label for='x'>X:</label><input name='x'/></li>");
//		out.write("		<li><label for='y'>Y:</label><input name='y'/></li>");
//		out.write("	</ul>");
//		out.write("		<p><input type='submit' value=\"����\"/> </p>");
//		out.write("      <input type=\"submit\" value=\"application\" />");
//		out.write("      <input type=\"submit\" value=\"session\" />");
//		out.write("      <input type=\"submit\" value=\"cookie\" />");
//		out.write("      </p>");
//		out.write("</form>");
//
//		out.println("<a href=\"MyPage\">����������</a>");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException 
	{
		service(request, response);
//		response.setCharacterEncoding("UTF-8"); // ����, ��� �� �� UTF-8 ������� ����
//		// � ���ڸ� ǥ������ �������� �˷��ش� �׷��� ���������� � ���ڸ� ����϶�� �˷��ش�.
//		response.setContentType("text/html; charset=UTF-8"); 
//		
//		String _x =  request.getParameter("x");
//		String _y =  request.getParameter("y");
//		
//		int x = 0; 
//		int y = 0; 
//		int result = x + y; 
//		
//		if(_x != null && !(_x.equals("")) && _y != null && (!_y.equals("")))
//		{
//			x = Integer.parseInt(_x);
//			y = Integer.parseInt(_y);
//			
//			result = x + y; 
//		}
//		
//		PrintWriter out = response.getWriter();
//		
////		out.write("<form action=\"hi\" method=\"post\">");
////		out.write("	<ul>");
////		out.write("		<li><label for='x'>X:</label><input name='x'/></li>");
////		out.write("		<li><label for='y'>Y:</label><input name='y'/></li>");
////		out.write("	</ul>");
////		out.write("		<p><input type='submit' value=\"����\"/> </p>");
////		out.write("</form>");
//		
//		
//		out.write("<form action=\"add\" method=\"post\">");
//		out.write("	<ul>");
//		out.write("		<li><label for='x'>X:</label><input name='x'/></li>");
//		out.write("		<li><label for='y'>Y:</label><input name='y'/></li>");
//		out.write("	</ul>");
//		out.write("		<p><input type='submit' value=\"����\"/> </p>");
//		out.write("      <input type=\"submit\" value=\"application\" />");
//		out.write("      <input type=\"submit\" value=\"session\" />");
//		out.write("      <input type=\"submit\" value=\"cookie\" />");
//		out.write("      </p>");
//		out.write("</form>");
//		out.printf("���� ����� : %d<br />", result);
//		out.println("<a href=\"MyPage\">����������</a>");
//		
//		out.println(result);
	}
}
