package cn.tedu.store.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * jdk��̬�����ʵ��
 * ע�⣺studentProxyHandler�����Ƕ�̬�����࣬�Ǹ����ࡣ
 * */
@Component
public class StudentProxyHandler implements InvocationHandler {
	@Resource
	private StudentService studentService;
	@Resource
	private StudentAspect studentAspect;

	// ��ȡ������Ķ���
	public Object getProxyObject() {
		// ��һ��������ʾĿ����ļ���������
		// �ڶ�����������ʾĿ����Ľӿ�����
		// ��������������ʾʵ����InvocationHandler�ӿڵ�ʵ����Ķ���
		return Proxy.newProxyInstance(studentService.getClass().getClassLoader(),
				studentService.getClass().getInterfaces(), this);

	}

	// ͨ��������ʵ��Ŀ����ķ����ĵ��á�
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// ǰ��֪ͨ
		studentAspect.test();
		// ����Ŀ�������
		Object obj = method.invoke(studentService, args);
		return obj;
	}

}
