package com.newlecture.web.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//MyBatis �����ͺ��̽� �������ִ� Ŭ����
public class SqlNewlecSessionFactory extends HttpServlet // ���� ������ ���� ������ Tomcat�� �������ֱ� ���� ��� �޴´�.
{
	// DB�� �ִ� �����͸� ��üȭ ��Ų�� ��� ������ ssf ������ ��´�. 
	public static SqlSessionFactory ssf;
	
	@Override
	// Tomcat�� ���ϸ��� ȣ���ϴ� �Լ� , ��Ĺ�� ����Ǹ� �ٷ� ���� ����ǰ� �Ѵ�. 
	public void init() throws ServletException   
	{
		// static ������
		// ���� ������ �� ���� �������� �Ǵϱ� static �����ڸ� ����Ѵ�.
//		static
		{
			String resource = "com/newlecture/web/dao/mybatis/config.xml";

			InputStream inputStream = null;  // config.xml ������ �о� ���� ���ؼ� ���
			
			try
			{
				//���� ������ ���� �� �ִ� Reader ��ü ����
				inputStream = Resources.getResourceAsStream(resource);
			}
			catch(IOException e)
			{
				System.out.println("SQL ���� : " + e.getMessage());
				e.printStackTrace();
			}
			
			//reader�� �̿��ؼ� MyBatis���� ��ü ����
			ssf = new SqlSessionFactoryBuilder().build(inputStream);   
		}
	}
	
	public SqlSessionFactory getSqlSessionFactory()
	{
		return ssf; 
	}
}
