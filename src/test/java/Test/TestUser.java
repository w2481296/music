package Test;

import java.util.List;

import org.junit.Test;
import org.omg.CORBA.NVList;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.UserService;

public class TestUser {
	@Test
	public void testInsertUser() {
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
		user.setPhone("13800138000");
		um.insert(user);
		ac.close();
	}
	@Test
	public void testSelectById(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		System.out.println(um.selectByUsername("admin"));
		ac.close();
	}
	@Test
	public void testuser(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IUserService us = ac.getBean("userService", UserService.class);
		User user=new User();
		user.setUsername("admin1");
		user.setPassword("123");
		user.setPhone("13800138000");
		us.addUser(user);
		ac.close();
	}
	@Test
	public void testemail(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		//System.out.println(um.selectByEmail("admin@tedu.cn"));
		System.out.println(um.selectByPhone("13800138000"));
		ac.close();
	}
	@Test
	public void testemails(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IUserService us = ac.getBean("userService", UserService.class);
		//System.out.println(us.checkEmail("admin@tedu.cn"));
		System.out.println(us.checkPhone("13800138000"));
		ac.close();
	}
	@Test
	public void testusername(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IUserService us = ac.getBean("userService", UserService.class);
		System.out.println(us.checkUsername("admin"));
		ac.close();
	}
	@Test
	public void testlogin(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IUserService us = ac.getBean("userService", UserService.class);
		System.out.println(us.login("admin", "123456"));
		ac.close();
	}
	@Test
	public void testUpdate(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		UserMapper um = ac.getBean("userMapper", UserMapper.class);
		//User user=new User();
		//user.setId(2);
		//user.setPassword("123456");
		//user.setEmail("123@qq.com");
		System.out.println(um.selectUserById(2));
		ac.close();
	}
		//≤‚ ‘’’∆¨–≈œ¢ ‰»Î≥÷æ√≤„
		@Test
		public void testImage(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			UserMapper gt = ac.getBean("userMapper",UserMapper.class);
			gt.updateImage(6, "dsf");
			ac.close();
		}
		
		
}
