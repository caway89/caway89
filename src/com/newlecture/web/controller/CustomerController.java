package com.newlecture.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.NoticeFileDao;
import com.newlecture.web.vo.Notice;
import com.newlecture.web.vo.NoticeFile;

// 이렇게 Controller라고 쓰지 않으면 Spring이 찾지 못한다.
// Controller라고 Spring이라고 인지 시켜주려면 Controller이라고 적어줘야한다.
@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private NoticeFileDao noticeFileDao;

	// url 맴핑된 각각에 메소드가 호출이 된다.

	// 아무 지정 없으면 스프링이 뒤지지 않음..

	// spring 도움 받기
/*	@Autowired
	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Autowired
	public void setNoticeFileDao(NoticeFileDao noticeFileDao) {
		this.noticeFileDao = noticeFileDao;
	}*/

	@RequestMapping("notice")
	public String notice(Model model) {
		// 모델과 뷰 넘겨주기
		/* NoticeDao noticeDao = new MybatisNoticeDao(); */
		//noticeDao = new MybatisNoticeDao();
		List<Notice> list = noticeDao.getNotices();
		String str = list.get(0).getTitle();
		str.length();
		//System.out.println(str);
		
		model.addAttribute("list", list);

		return "customer.notice";
		
		/*return "/WEB-INF/view/customer/notice.jsp";*/
	}

	@RequestMapping("noticeDetail") // 구분하지 않아 get post 요청 할 수 있음
	public String noticeDetail(String c, Model model) {
		// getParameter 알아서 해줌
		/* NoticeDao noticeDao = new MybatisNoticeDao(); */
		Notice n = noticeDao.getNotice(c);

		List<NoticeFile> list = noticeFileDao.getNoticeFilesOfNotice(n.getCode());
		
		model.addAttribute("n", n);
		model.addAttribute("list",list);

		return "/WEB-INF/view/customer/noticeDetail.jsp";
	}

	@RequestMapping(value = "noticeReg", method = RequestMethod.GET)
	public String noticeReg() {
		return "/WEB-INF/view/customer/noticeReg.jsp";
	}

	@RequestMapping(value = "noticeReg", method = RequestMethod.POST)
	public String noticeReg(Notice n, MultipartFile file, 
			Principal principal, HttpServletRequest request,
			//SecurityContextHolder holder,
			SecurityContext context) throws IOException {

		if(request.isUserInRole("ROLE_ADMIN"))
		{
		
		}
		
		//holder.getContext();
/*		context.getAuthentication().getAuthorities();
		context.getAuthentication().isAuthenticated();*/
		// file이 키값이 file이기 때문에 file로 써줘야함

		// DB에 쓰는 작업
		// 트랜잭션 묶어줘야함 --> JDBC는 커밋 기능있는데 DAO로 하면 따로 구현을 해줘야한다.
		n.setWriter(principal.getName());
		noticeDao.addNotice(n);
		String lastCode = noticeDao.getLastCode();
		
		if (!file.isEmpty()) {
			// Part part = request.getPart("file"); //Spring에서 제공해서 필요없음
			ServletContext application = request.getServletContext();

			String url = "/resource/customer/upload";
			String path = application.getRealPath(url); 
			String temp = file.getOriginalFilename(); // 파일명안 가져옴.. 파일 이름 중복 일 수 있으니까
			String fname = temp.substring(temp.lastIndexOf("\\") + 1);
			String fpath = path + "\\" + fname; // fpath(서비스 될 디렉토리)

			InputStream ins = file.getInputStream(); 					// 사용자가  첨부한 파일을 읽어 들임 
			OutputStream outs = new FileOutputStream(fpath); // 출력 서비스 될 디렉토리에 

			// try~catch 내가 오류를 제정의 공손하게 인사...
			// url로 전달된 파일 녀석을 스프링이 어떻게 알게 할까
			byte[] 대야 = new byte[1024];

			int len = 0;
			while ((len = ins.read(대야, 0, 1024)) >= 0) 
			{
				outs.write(대야, 0, len);
			}
			outs.flush();
			outs.close();
			ins.close();
			
			NoticeFile noticeFile = new NoticeFile();
			noticeFile.setNoticeCode(lastCode);
			noticeFile.setName(fname);
			
			noticeFileDao.addNoticeFile(noticeFile);
		}
		return "redirect:notice";
	}
}
