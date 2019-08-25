package cn.tedu.store.aop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * ��������ص�
 * 1.��Ŀ�����й�ͬ�Ľӿ�
 * 2.ͬʱӵ��Ŀ����Ķ����������Ķ���
 * */
@Component
public class StudentProxy 
			 implements IStudentService{
	@Resource
	private StudentService studentService;
	@Resource
	private StudentAspect studentAspect;
	//ģ��ǰ��֪ͨ
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

