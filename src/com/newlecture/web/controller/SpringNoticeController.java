package com.newlecture.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.vo.Notice;

//URL ������..
public class SpringNoticeController implements Controller
{//POJO Ŭ����(Real POJO�� �ƴϴ�.)

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		NoticeDao noticeDao = new MybatisNoticeDao();
		List<Notice> list = noticeDao.getNotices();
		//request.setAttribute("list", list); // ���巺Ʈ �ϸ� ���� ������� ����� ����Ʈ �״�� ������

		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/notice.jsp");
		dispatcher.forward(request, response);*/
		
		// spring 2.5 ������������ ����ϴ� ���� ���
		// �״� Dispatcher �����ڰ� �־��ִ� ��Ŀ� ���� ������ ����..
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("/WEB-INF/view/customer/notice.jsp");
		mv.addObject("list",list);
		
		// ���� ���� �ִ� ����� ������
		// Ŭ���� ���� �޼ҵ� 1���� ���� -> ��ü �� ������
		// xml mapping ������ ��� �־���� ��, 
		
		// ���ο� ���
		// annotaion ������� ���
		// �Լ����� URL���� �ϸ� ��...
		
		return mv;
	}
}
