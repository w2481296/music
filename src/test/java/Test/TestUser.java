package Test;

import java.util.List;

import org.junit.Test;
import org.omg.CORBA.NVList;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.Cart;
import cn.tedu.store.bean.CartVo;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.CartMapper;
import cn.tedu.store.mapper.DictMapper;
import cn.tedu.store.mapper.GoodsCategoryMapper;
import cn.tedu.store.mapper.GoodsMapper;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.AddressService;
import cn.tedu.store.service.IAddressService;
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
		user.setEmail("admin@tedu.cn");
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
		user.setEmail("admin@tedu.cn");
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
	@Test
	public void testUpdatePwd(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IUserService us = ac.getBean("userService", UserService.class);
		us.changePassword(2, "123456", "123");
		ac.close();
	}
	//测试修改个人信息业务层方法
	@Test
	public void testUpdateUser(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
		IUserService us = ac.getBean("userService", UserService.class);
		us.updateUser(1,"adminn",0, "123@qq.com", "13233449013");
		ac.close();
	}
	//测试查询所有省份持久层方法
	@Test
	public void testSelectPro(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper um = ac.getBean("dictMapper",DictMapper.class);
		System.out.println(um.selectProvince());
		ac.close();
	}
	//测试查询所有城市持久层方法
	@Test
	public void testSelectCity(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper um = ac.getBean("dictMapper",DictMapper.class);
		System.out.println(um.selectCity("140000"));
		ac.close();
	}
	//测试查询所有区县持久层方法
	@Test
	public void testSelectArea(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		DictMapper um = ac.getBean("dictMapper",DictMapper.class);
		System.out.println(um.selectArea("110100"));
		ac.close();
	}
	//测试添加地址持久层方法
	@Test
	public void testinsertAdd(){
		AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
		AddressMapper um = ac.getBean("addressMapper",AddressMapper.class);
		Address address=new Address();
		address.setId(1);
		address.setUid(2);
		address.setRecvzip("ni2");
		address.setRecvtel("ni3");
		address.setRecvtag("ni3");
		address.setRecvprovince("ni4");
		address.setRecvphone("ni5");
		address.setRecvname("ni6");
		address.setRecvdistrict("ni7");
		address.setRecvcity("ni8");
		address.setRecvarea("ni9");
		address.setRecvaddress("ni10");
		address.setIsDefault(1);
		um.insertAddress(address);
		ac.close();
	}
	//测试查询所有省市区名字持久层方法
		@Test
		public void testSelectByName(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			DictMapper um = ac.getBean("dictMapper",DictMapper.class);
			System.out.println(um.selectByProvinceCode("130000")+um.selectByCityCode("130100")+um.selectByAreaCode("130103"));
			ac.close();
		}
		//测试根据uid判断是否有地址
		@Test
		public void testSelectByUid(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			AddressMapper um = ac.getBean("addressMapper",AddressMapper.class);
			List<Address> list=um.selectByUid(2);
			System.out.println(list.size());
			ac.close();
		}
		@Test
		public void testaddAdd(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
			AddressService us = ac.getBean("addressService", AddressService.class);
			Address address=new Address();
			address.setUid(2);
			address.setRecvzip("ni23");
			address.setRecvtel("ni33");
			address.setRecvtag("ni33");
			address.setRecvprovince("ni43");
			address.setRecvphone("ni53");
			address.setRecvname("ni63");
			address.setRecvcity("ni83");
			address.setRecvarea("ni93");
			address.setRecvaddress("ni130");
			us.addAddress(address);
			ac.close();
		}
		//测试根据uid和id更新设置默认值持久层方法
		@Test
		public void testupdate(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			AddressMapper um = ac.getBean("addressMapper",AddressMapper.class);
			System.out.println(um.updateById(2));
			System.out.println(um.updateByUid(2));
			ac.close();
		}
		//测试根据id做查询
		@Test
		public void testselsectid(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			AddressMapper um = ac.getBean("addressMapper",AddressMapper.class);
			System.out.println(um.selectById(2));
			ac.close();
		}
		//测试根据id做修改
		@Test
		public void testupdateid(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			AddressMapper um = ac.getBean("addressMapper",AddressMapper.class);
			Address address=new Address();
			address.setId(2);
			address.setRecvzip("ni231");
			address.setRecvtel("ni332");
			address.setRecvtag("ni333");
			address.setRecvprovince("ni434");
			address.setRecvphone("ni535");
			address.setRecvname("ni636");
			address.setRecvcity("ni837");
			address.setRecvarea("ni938");
			address.setRecvaddress("ni1301");
			um.updateAddress(address);
			ac.close();
		}
		//测试删除地址的业务层持久层方法
		@Test
		public void testdelete(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml","application-service.xml");
			AddressService us = ac.getBean("addressService", AddressService.class);
			us.removeAddress(3);
			ac.close();
		}
		//测试二级分类业务层
		@Test
		public void testGoods(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			GoodsCategoryMapper gt = ac.getBean("goodsCategoryMapper",GoodsCategoryMapper.class);
			System.out.println(gt.selectByParentId(161,0,3));
			ac.close();
		}
		//测试热门信息业务层
		@Test
		public void testGoodshot(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			GoodsMapper gt = ac.getBean("goodsMapper",GoodsMapper.class);
			System.out.println(gt.selectByCategoryId(163, 0, 3));
			ac.close();
		}
		//测试商品信息数量业务层
		@Test
		public void testGoodcount(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			GoodsMapper gt = ac.getBean("goodsMapper",GoodsMapper.class);
			System.out.println(gt.selectCount(163));
			ac.close();
		}
		//测试商品信息查询持久层
		@Test
		public void testGoodinfor(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			GoodsMapper gt = ac.getBean("goodsMapper",GoodsMapper.class);
			System.out.println(gt.selectById("10000014"));
			ac.close();
		}
		//测试购物车加入购物车持久层
		@Test
		public void testinsertCart(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			CartMapper gt = ac.getBean("cartMapper",CartMapper.class);
			Cart cart=new Cart();
			cart.setUid(2);
			cart.setGoodsId("ni");
			cart.setNum(100);
			gt.insertCart(cart);
			ac.close();
		}
		//测试购物车信息持久层
		@Test
		public void testCartvo(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			CartMapper gt = ac.getBean("cartMapper",CartMapper.class);
			List<CartVo>list=gt.selectByUid(1);
			System.out.println(list);
			ac.close();
		}
		
		//测试购物车批量删除持久层
		@Test
		public void testCartdel(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			CartMapper gt = ac.getBean("cartMapper",CartMapper.class);
			Integer[] list={5,6};
			gt.deleteByIds(list);
			ac.close();
		}
		//测试购物车单个删除持久层
		@Test
		public void testCartdelone(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			CartMapper gt = ac.getBean("cartMapper",CartMapper.class);
			gt.deleteById(9);
			ac.close();
		}
		//测试购物车数量信息持久层
		@Test
		public void testupdatecart(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			CartMapper gt = ac.getBean("cartMapper",CartMapper.class);
			gt.updateById(7,2);
			ac.close();
		}
		//测试照片信息输入持久层
		@Test
		public void testImage(){
			AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-dao.xml");
			UserMapper gt = ac.getBean("userMapper",UserMapper.class);
			gt.updateImage(6, "dsf");
			ac.close();
		}
		
		
}
