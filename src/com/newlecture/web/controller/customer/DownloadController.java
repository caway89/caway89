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
	
		// ������� ���� �ʿ� ���������� �̰Ŵ� �ٿ�ε� �ϴ°ž� ��� �˷���
		response.setHeader("Content-Disposition", "attachment;filename="+ fname);
		response.setContentType("application/octet-stream");
		
		ServletContext application = request.getServletContext();
	
		String url = "/customer/upload";  
		String path = application.getRealPath(url);
		String fpath = path + "\\" + fname;  // ���ڿ��� ���� ���� �ϸ� ���� ������
		
		OutputStream outs = response.getOutputStream();// ���
		InputStream ins = new FileInputStream(fpath); // �Է�
		byte[] ��� = new byte[1024];
		
		int len = 0; 
		while((len = ins.read(���, 0, 1024)) >= 0)
		{
			outs.write(���, 0, len);
		}
		
		outs.flush();
		outs.close();
		ins.close();
	}
}