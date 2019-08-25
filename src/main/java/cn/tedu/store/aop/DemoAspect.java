package cn.tedu.store.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect // ----��ʾ��ǰ����������
public class DemoAspect {
	// test1������userServiceҵ�񷽷�֮ǰִ��
	//before��userservice����ʾ���е�bean��ΪuserService
	//userservice��ʾspringʵ����bean������
	@Before("bean(userService)")
	public void test1() {
		System.out.println("ҵ�񷽷�֮ǰִ��");
	}
	//����֪ͨ(����֪ͨ��������û���쳣��Ҫִ�еķ���)
	@After("bean(userService)")
	public void test2(){
		System.out.println("ҵ�񷽷�ִ��֮��");
	}
	//����֪ͨ
	//�������쳣��ִ��֪ͨ
	@AfterReturning("bean(userService)")
	public void test3(){
		System.out.println("ҵ�񷽷�ִ��֮��ִ�С�����");
	}
	//�쳣֪ͨ�������쳣ʱִ��
	@AfterThrowing("bean(userService)")
	public void test4(){
		System.out.println("�쳣֪ͨ");
	}
	//@Around��ʾ����֪ͨ
	/*1.���������з���ֵ:����ֵ���ͣ�ҵ���߼���������ֵ����
	2.�����в���
	3.�����ֵ����*/
	@Around("execution(* cn.tedu.store.service.UserService.login(..))")
	public Object test5(ProceedingJoinPoint pp) throws Throwable{
		System.out.println("????");
		//����ҵ�񷽷�
		Object object=pp.proceed();
		return object;
		
	}
	
}