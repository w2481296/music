package cn.tedu.store.aop;

import org.springframework.stereotype.Component;
/*
 * 定义切面类
 * */
@Component
public class StudentAspect {
	public void test(){
		System.out.println("模拟前置通知");
	}
}	
