package cn.tedu.store.aop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * 代理类的特点
 * 1.和目标类有共同的接口
 * 2.同时拥有目标类的对象和切面类的对象
 * */
@Component
public class StudentProxy 
			 implements IStudentService{
	@Resource
	private StudentService studentService;
	@Resource
	private StudentAspect studentAspect;
	//模拟前置通知
	public void add() {
		studentAspect.test();
		studentService.add();
		
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public void get() {
		// TODO Auto-generated method stub
		
	}

	public void getAll() {
		// TODO Auto-generated method stub
		
	}

}

