package com.newlecture.web.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LogAroundAdvice implements MethodInterceptor
{
	@Override
	public Object invoke(MethodInvocation method) throws Throwable 
	{
		StopWatch stopWatch = new StopWatch();
		
		System.out.println();
		System.out.println("[�ð�üũ] ȣ�����");
		stopWatch.start();
		
		Object result = method.proceed(); // ���ڴ� ȣ�� �ϴ� ���� ����Ʈ
		
		System.out.println("[�ð�üũ] ȣ�� ��");
		stopWatch.stop();
		
		System.out.println("[TIMELOG] Method : " + method.getMethod().getName()+"is finished" );
		System.out.println("[TIMELOG] Process TIME : " + stopWatch.getTotalTimeMillis());
		
		return result; 
	}
}
