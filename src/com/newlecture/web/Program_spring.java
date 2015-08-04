package com.newlecture.web;

import javax.servlet.ServletException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.newlecture.web.dao.mybatis.SqlNewlecSessionFactory;

public class Program_spring {
	static // �����Լ� ���� ȣ�� ��
	{
		// �� �ڵ带 �������� ������ MyBatis Mapper ������ ���� ������ null���� �ȴ�.
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
		// Spring ���
		// Context�� �ǹ̴� ���� ����Ÿ
		// ApplicationContext�� ��ü�� �����ϴ� ������ ��ǰ���� ���յǾ� Application��
		// ��, ��� ������ �����Ǿ�� �Ǳ� �����̴�.

		// spring-context.xml ��ο� �ִ� ������ ApplicationContext(IoC �����̳�)�� �ε� ��Ų��.
		// �̰������� ��ǰ���� ������ �Ǿ���.
		ApplicationContext context = new ClassPathXmlApplicationContext("com/newlecture/web/spring-context.xml");

		NoticeConsole console = (NoticeConsole) context.getBean("console");
		console.print();
	}
}