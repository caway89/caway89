package com.newlecture.web.aop;

import java.util.List;

import javax.servlet.ServletException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;
import com.newlecture.web.vo.Notice;

public class Program 
{
	static //메인함수 전에 호출 됨
	{
		// 이 코드를 삽입하지 않으면 MyBatis Mapper 정보가 없기 때문에 null값이 된다. 
		SqlNewlecSessionFactory factory = new SqlNewlecSessionFactory();
		try 
		{
			factory.init();
		} 
		catch (ServletException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	public static void main(String[] args) 
	{
/*		NoticeDao noticeDao_prince = new MybatisNoticeDao();
		
		NoticeDao proxy =  (NoticeDao)Proxy.newProxyInstance(
							noticeDao_prince.getClass().getClassLoader(),   //왕자님
							noticeDao_prince.getClass().getInterfaces(),       //왕자님
							new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable // Methoid가 실제 왕자님을 호출하기 위한 도구
					{
						System.out.println("사전");  // 보조 업무 
				
						// 왕자가 실행되는 실행 되는 로직
						List<Notice> list = (List<Notice>) method.invoke(noticeDao_prince, args);
						
						System.out.println("사후");
						
						return list;
					}
				}); */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/web/aop/spring-context-aop.xml");
		NoticeDao noticeDao = (NoticeDao)context.getBean("noticeDao"); // 진짜인지 가짜인지 모르는 방식
				
//		Proxy인지 진짜 인지 모름
		List<Notice> list = noticeDao.getNotices();
/*		Notice notice =  noticeDao.getNotice("1");*/
	
		// aroundAdvice일때 결과 화면에 보조업무가 먼저 다 출력되고 나중에 주업무가 표시되는것처럼 보이지만
		// 사실은 보조업무 호출 되고 보조 업무 호출되고 보조업무 호출되었다. 
		// getNotice가 호출되지만 사실은 눈에 보이지 않는것이다. 
		// 밑에 for문에서 출력해주는걸 보여줘야 호출 되는 것이다. 그래서 결과 화면에 보조업무 호출되고 주업무 호출되는것처럼 보이는것.
		for(Notice n : list)
			System.out.printf("제목 :  %s\n", n.getTitle());
	}
}
