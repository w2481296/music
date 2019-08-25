package Test;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.aop.IStudentService;
import cn.tedu.store.aop.StudentProxyHandler;

public class TestAop {
	@Test
	public void testProxy() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-aop.xml");
		IStudentService ss = ac.getBean("studentProxy", IStudentService.class);
		ss.add();
		ac.close();
	}
	@Test
	public void testProxyHandler(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-aop.xml");
		StudentProxyHandler ss = ac.getBean("studentProxyHandler", StudentProxyHandler.class);
		//��ȡ��̬������Ķ���
		IStudentService studentService=(IStudentService)ss.getProxyObject();
		//����ҵ�񷽷�
		studentService.add();
		ac.close();
	}

}
