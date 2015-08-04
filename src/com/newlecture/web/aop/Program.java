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
	static //�����Լ� ���� ȣ�� ��
	{
		// �� �ڵ带 �������� ������ MyBatis Mapper ������ ���� ������ null���� �ȴ�. 
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
							noticeDao_prince.getClass().getClassLoader(),   //���ڴ�
							noticeDao_prince.getClass().getInterfaces(),       //���ڴ�
							new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable // Methoid�� ���� ���ڴ��� ȣ���ϱ� ���� ����
					{
						System.out.println("����");  // ���� ���� 
				
						// ���ڰ� ����Ǵ� ���� �Ǵ� ����
						List<Notice> list = (List<Notice>) method.invoke(noticeDao_prince, args);
						
						System.out.println("����");
						
						return list;
					}
				}); */
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/web/aop/spring-context-aop.xml");
		NoticeDao noticeDao = (NoticeDao)context.getBean("noticeDao"); // ��¥���� ��¥���� �𸣴� ���
				
//		Proxy���� ��¥ ���� ��
		List<Notice> list = noticeDao.getNotices();
/*		Notice notice =  noticeDao.getNotice("1");*/
	
		// aroundAdvice�϶� ��� ȭ�鿡 ���������� ���� �� ��µǰ� ���߿� �־����� ǥ�õǴ°�ó�� ��������
		// ����� �������� ȣ�� �ǰ� ���� ���� ȣ��ǰ� �������� ȣ��Ǿ���. 
		// getNotice�� ȣ������� ����� ���� ������ �ʴ°��̴�. 
		// �ؿ� for������ ������ִ°� ������� ȣ�� �Ǵ� ���̴�. �׷��� ��� ȭ�鿡 �������� ȣ��ǰ� �־��� ȣ��Ǵ°�ó�� ���̴°�.
		for(Notice n : list)
			System.out.printf("���� :  %s\n", n.getTitle());
	}
}
