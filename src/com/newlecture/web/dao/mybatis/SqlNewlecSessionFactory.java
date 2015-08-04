package com.newlecture.web.dao.mybatis;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//MyBatis 데이터베이스 연결해주는 클레스
public class SqlNewlecSessionFactory extends HttpServlet // 웹은 메인이 없기 때문에 Tomcat이 실행해주기 위해 상속 받는다.
{
	// DB에 있는 데이터를 객체화 시킨후 모든 정보를 ssf 변수에 담는다. 
	public static SqlSessionFactory ssf;
	
	@Override
	// Tomcat이 제일먼저 호출하는 함수 , 톰캣이 실행되면 바로 서블릿 실행되게 한다. 
	public void init() throws ServletException   
	{
		// static 생성자
		// 설정 파일은 한 번만 가져오면 되니까 static 생성자를 사용한다.
//		static
		{
			String resource = "com/newlecture/web/dao/mybatis/config.xml";

			InputStream inputStream = null;  // config.xml 파일을 읽어 오기 위해서 사용
			
			try
			{
				//설정 파일을 읽을 수 있는 Reader 객체 생성
				inputStream = Resources.getResourceAsStream(resource);
			}
			catch(IOException e)
			{
				System.out.println("SQL 에러 : " + e.getMessage());
				e.printStackTrace();
			}
			
			//reader를 이용해서 MyBatis연동 객체 생성
			ssf = new SqlSessionFactoryBuilder().build(inputStream);   
		}
	}
	
	public SqlSessionFactory getSqlSessionFactory()
	{
		return ssf; 
	}
}
