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

// �̷��� Controller��� ���� ������ Spring�� ã�� ���Ѵ�.
// Controller��� Spring�̶�� ���� �����ַ��� Controller�̶�� ��������Ѵ�.
@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private NoticeFileDao noticeFileDao;

	// url ���ε� ������ �޼ҵ尡 ȣ���� �ȴ�.

	// �ƹ� ���� ������ �������� ������ ����..

	// spring ���� �ޱ�
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
		// �𵨰� �� �Ѱ��ֱ�
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

	@RequestMapping("noticeDetail") // �������� �ʾ� get post ��û �� �� ����
	public String noticeDetail(String c, Model model) {
		// getParameter �˾Ƽ� ����
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
		// file�� Ű���� file�̱� ������ file�� �������

		// DB�� ���� �۾�
		// Ʈ����� ��������� --> JDBC�� Ŀ�� ����ִµ� DAO�� �ϸ� ���� ������ ������Ѵ�.
		n.setWriter(principal.getName());
		noticeDao.addNotice(n);
		String lastCode = noticeDao.getLastCode();
		
		if (!file.isEmpty()) {
			// Part part = request.getPart("file"); //Spring���� �����ؼ� �ʿ����
			ServletContext application = request.getServletContext();

			String url = "/resource/customer/upload";
			String path = application.getRealPath(url); 
			String temp = file.getOriginalFilename(); // ���ϸ�� ������.. ���� �̸� �ߺ� �� �� �����ϱ�
			String fname = temp.substring(temp.lastIndexOf("\\") + 1);
			String fpath = path + "\\" + fname; // fpath(���� �� ���丮)

			InputStream ins = file.getInputStream(); 					// ����ڰ�  ÷���� ������ �о� ���� 
			OutputStream outs = new FileOutputStream(fpath); // ��� ���� �� ���丮�� 

			// try~catch ���� ������ ������ �����ϰ� �λ�...
			// url�� ���޵� ���� �༮�� �������� ��� �˰� �ұ�
			byte[] ��� = new byte[1024];

			int len = 0;
			while ((len = ins.read(���, 0, 1024)) >= 0) 
			{
				outs.write(���, 0, len);
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
