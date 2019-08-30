package cn.tedu.store.service;


import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sun.xml.internal.ws.model.wsdl.WSDLBoundOperationImpl;

import cn.tedu.store.bean.User;
import cn.tedu.store.ex.PasswordNotMatchException;
import cn.tedu.store.ex.UserNotFoundException;
import cn.tedu.store.ex.UsernameAlreadyExistException;
import cn.tedu.store.mapper.UserMapper;

@Service
public class UserService implements IUserService {

	@Resource
	private UserMapper userMapper;
	@Value("#{config.salt}")
	private String salt;

	public void addUser(User user) {
		// 1.调用持久层的方法selectByUsername(user.getUsername());返回user1对象
		// 2.如果用户名不存在则调用insertUser(user)方法,
		// 不为空，则用户名已存在，抛出异常UsernameAlreadyExistException
		User user1 = userMapper.selectByUsername(user.getUsername());
		if (user1 == null) {
			//获取页面的密码
			//String pwd=user.getPassword();
			//生成的密码密文
			//String md5pwd=DigestUtils.md5Hex(pwd+salt);
			//把密文设置为user的属性
			//user.setPassword(pwd);
			userMapper.insert(user);
		} else {
			throw new UsernameAlreadyExistException("用户名已存在！");
		}
	}


	public boolean checkPhone(String phone) {
		return userMapper.selectByPhone(phone) > 0;
	}

	public boolean checkUsername(String name) {
		return userMapper.selectByUsername(name) != null;
	}
	
	// 实现登录功能
	public User login(String username, String password) {
		// 1.调用持久层方法ByUsername;返回user对象
		// 2.判断对象是否存在，不存在抛出异常
		// 3.存在判断密码
		User user = userMapper.selectByUsername(username);
		if (user == null) {
			throw new UserNotFoundException("帐号不存在");
		} else {
			//获取密码成为密文
			//String md5pwd=DigestUtils.md5Hex(password+salt);
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				throw new PasswordNotMatchException("密码不匹配");
			}
		}

	}
	//刷新页面
	public User getUserById(Integer id) {
		return userMapper.selectUserById(id);
	}

}