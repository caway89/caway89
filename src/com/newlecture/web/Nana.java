package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class Nana extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
																									throws ServletException, IOException 
	{
		
		String _cnt = request.getParameter("cnt");
		
		int cnt = 10;
		
		if(_cnt != null && _cnt.equals(""))
			cnt = Integer.parseInt(_cnt);
		
		response.setCharacterEncoding("UTF-8"); // 전송, 출력 할 때 UTF-8 응답헤로 보냄
		// 어떤 문자를 표혈할지 서버에게 알려준다 그러면 브라우저에게 어떤 문자를 출력하라고 알려준다.
		response.setContentType("text/html); charset=UTF-8"); 
		
		PrintWriter out = response.getWriter();
		
		for(int i=0; i < cnt; i++)
			out.println("Hello Servlet 한글도 되나?? <br />");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException 
	{
//		response.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html); charset=UTF-8"); 
	
		String _x =  request.getParameter("x");
		String _y =  request.getParameter("y");
		
		int x = 0; 
		int y = 0; 
		
		int result = x + y; 
		
		if(_x != null && !(_x.equals("")) && _y != null && (!_y.equals("")))
		{
			x = Integer.parseInt(_x);
			y = Integer.parseInt(_y);
			
			result = x + y; 
		}
		
		PrintWriter out = response.getWriter();
		
//		out.write("<form action=\"hi\" method=\"post\">");
//		out.write("	<ul>");
//		out.write("		<li><label for='x'>X:</label><input name='x'/></li>");
//		out.write("		<li><label for='y'>Y:</label><input name='y'/></li>");
//		out.write("	</ul>");
//		out.write("		<p><input type='submit' value=\"덧셈\"/> </p>");
//		out.write("</form>");
		
		
		
		out.write("<form action=\"hi\" method=\"post\">");
		out.write("	<ul>");
		out.write("		<li><label for='x'>X:</label><input name='x'/></li>");
		out.write("		<li><label for='y'>Y:</label><input name='y'/></li>");
		out.write("	</ul>");
		out.write("		<p><input type='submit' value=\"덧셈\"/> </p>");
		out.write("      <input type=\"submit\" value=\"application\" />");
		out.write("      <input type=\"submit\" value=\"session\" />");
		out.write("      <input type=\"submit\" value=\"cookie\" />");
		out.write("      </p>");
		out.write("</form>");
		out.printf("덧셈 결과는 : %d<br />", result);
		out.println("<a href=\"MyPage\">마이페이지</a>");
	}
}
