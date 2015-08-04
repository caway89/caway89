package com.newlecture.web.controller.customer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/customer/download")
public class DownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		String fname = request.getParameter("f");
	
		// 응답헤더 조작 필요 브라우저에게 이거는 다운로드 하는거야 라고 알려줌
		response.setHeader("Content-Disposition", "attachment;filename="+ fname);
		response.setContentType("application/octet-stream");
		
		ServletContext application = request.getServletContext();
	
		String url = "/customer/upload";  
		String path = application.getRealPath(url);
		String fpath = path + "\\" + fname;  // 문자열을 더셋 많이 하면 성능 떨어짐
		
		OutputStream outs = response.getOutputStream();// 출력
		InputStream ins = new FileInputStream(fpath); // 입력
		byte[] 대야 = new byte[1024];
		
		int len = 0; 
		while((len = ins.read(대야, 0, 1024)) >= 0)
		{
			outs.write(대야, 0, len);
		}
		
		outs.flush();
		outs.close();
		ins.close();
	}
}
