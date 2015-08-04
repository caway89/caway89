package com.newlecture.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.MybatisNoticeDao;
import com.newlecture.web.vo.Notice;

//URL 없어짐..
public class SpringNoticeController implements Controller
{//POJO 클래스(Real POJO는 아니다.)

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		NoticeDao noticeDao = new MybatisNoticeDao();
		List<Notice> list = noticeDao.getNotices();
		//request.setAttribute("list", list); // 리드렉트 하면 날라감 포워드는 담견진 리스트 그대로 보여줌

		/*RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/customer/notice.jsp");
		dispatcher.forward(request, response);*/
		
		// spring 2.5 이전버전에서 사용하는 과거 방식
		// 그닥 Dispatcher 개발자가 넣어주는 방식에 비해 좋은점 없음..
		ModelAndView mv = new ModelAndView(); 
		mv.setViewName("/WEB-INF/view/customer/notice.jsp");
		mv.addObject("list",list);
		
		// 지금 쓰고 있는 방식의 문제점
		// 클래스 마다 메소드 1개씩 존재 -> 객체 수 증가함
		// xml mapping 정보도 계속 넣어줘야 함, 
		
		// 새로운 방식
		// annotaion 방식으로 사용
		// 함수에만 URL지정 하면 됨...
		
		return mv;
	}
}
