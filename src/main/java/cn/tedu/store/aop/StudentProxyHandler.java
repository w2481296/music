package cn.tedu.store.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/*
 * jdk动态代理的实现
 * 注意：studentProxyHandler并不是动态代理类，是辅助类。
 * */
@Component
public class StudentProxyHandler implements InvocationHandler {
	@Resource
	private StudentService studentService;
	@Resource
	private StudentAspect studentAspect;

	// 获取代理类的对象
	public Object getProxyObject() {
		// 第一个参数表示目标类的加载器对象
		// 第二个参数，表示目标类的接口类型
		// 第三个参数，表示实现了InvocationHandler接口的实现类的对象
		return Proxy.newProxyInstance(studentService.getClass().getClassLoader(),
				studentService.getClass().getInterfaces(), this);

	}

	// 通过反射来实现目标类的方法的调用。
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 前置通知
		studentAspect.test();
		// 调用目标类对象
		Object obj = method.invoke(studentService, args);
		return obj;
	}

}
