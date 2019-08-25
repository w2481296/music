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
@Aspect // ----表示当前类是切面类
public class DemoAspect {
	// test1方法在userService业务方法之前执行
	//before（userservice）表示横切的bean类为userService
	//userservice表示spring实例化bean的名称
	@Before("bean(userService)")
	public void test1() {
		System.out.println("业务方法之前执行");
	}
	//后置通知(最终通知，不管有没有异常都要执行的方法)
	@After("bean(userService)")
	public void test2(){
		System.out.println("业务方法执行之后");
	}
	//后置通知
	//不发生异常，执行通知
	@AfterReturning("bean(userService)")
	public void test3(){
		System.out.println("业务方法执行之后执行。。。");
	}
	//异常通知，发生异常时执行
	@AfterThrowing("bean(userService)")
	public void test4(){
		System.out.println("异常通知");
	}
	//@Around表示环绕通知
	/*1.方法必须有返回值:返回值类型，业务逻辑方法返回值类型
	2.必须有参数
	3.必须把值返回*/
	@Around("execution(* cn.tedu.store.service.UserService.login(..))")
	public Object test5(ProceedingJoinPoint pp) throws Throwable{
		System.out.println("????");
		//调用业务方法
		Object object=pp.proceed();
		return object;
		
	}
	
}