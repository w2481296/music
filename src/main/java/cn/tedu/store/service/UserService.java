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
			String pwd=user.getPassword();
			//生成的密码密文
			String md5pwd=DigestUtils.md5Hex(pwd+salt);
			//把密文设置为user的属性
			user.setPassword(md5pwd);
			userMapper.insert(user);
		} else {
			throw new UsernameAlreadyExistException("用户名已存在！");
		}
	}

	public boolean checkEmail(String email) {
		return userMapper.selectByEmail(email) > 0;
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
			String md5pwd=DigestUtils.md5Hex(password+salt);
			if (user.getPassword().equals(md5pwd)) {
				return user;
			} else {
				throw new PasswordNotMatchException("密码不匹配");
			}
		}

	}

	// 实现修改密码
	public void changePassword(Integer id, String oldPwd, String newPwd) {
		// 调用持久层方法
		User user = userMapper.selectUserById(id);
		User user1 = new User();
		String md5opwd=DigestUtils.md5Hex(oldPwd+salt);
		if (user != null) {
			if (user.getPassword().equals(md5opwd)) {
				String md5pwd=DigestUtils.md5Hex(newPwd+salt);
				user1.setPassword(md5pwd);
				user1.setId(user.getId());
				userMapper.updateUser(user1);
			} else {
				throw new PasswordNotMatchException("旧密码不正确");
			}
		} else {
			throw new UserNotFoundException("用户不存在");
		}
	}

	public void updateUser(Integer id, String username, Integer gender, String email, String phone) {
		User user1 = userMapper.selectUserById(id);
		// 1.调用持久层的方法selectById(通过session获取)，返回user1对象
		// 判断是否存在
		if (user1 != null) {
			// 调用持久层的方法selectByUsername，返回use2对象
			User user2 = userMapper.selectByUsername(username);
			//如果use2不为空，说明数据库中存在该用户名
			//如果用户名和登录用户的名称相同，可以实现修改
			if (user2 != null &&!user1.getUsername().equals(username)) {
				// 抛出异常
				throw new UsernameAlreadyExistException("用户名已存在");
			} else {
				User user = new User();
				// 设置属性包含
				user.setId(id);
				user.setUsername(username);
				user.setGender(gender);
				user.setEmail(email);
				user.setPhone(phone);
				// 调用持久层update(user);
				userMapper.updateUser(user);
			}
		} else {
			// 抛出异常
			throw new UserNotFoundException("用户没有找到");
		}

	}
	//刷新页面
	public User getUserById(Integer id) {
		return userMapper.selectUserById(id);
	}

	public void updImage(Integer id, String image) {
		userMapper.updateImage(id, image);
	}
}