package com.newlecture.web;

import javax.servlet.ServletException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;

public class Program_spring {
	static // 메인함수 전에 호출 됨
	{
		// 이 코드를 삽입하지 않으면 MyBatis Mapper 정보가 없기 때문에 null값이 된다.
		SqlNewlecSessionFactory factory = new SqlNewlecSessionFactory();
		try {
			factory.init();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws ServletException 
	{
		// Spring 사용
		// Context에 의미는 공유 데이타
		// ApplicationContext에 객체를 저장하는 이유는 부품들이 결합되어 Application내
		// 즉, 모든 곳에서 공유되어야 되기 때문이다.

		// spring-context.xml 경로에 있는 명세서를 ApplicationContext(IoC 컨테이너)에 로드 시킨다.
		// 이과정에서 부품들이 조립이 되었다.
		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/web/spring-context.xml");

		NoticeConsole console = (NoticeConsole) context.getBean("console");
		console.print();
	}
}