package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	void addUser(User user);
	boolean checkPhone(String phone);
	boolean checkUsername(String name);
	User login(String username,String password);
	User getUserById(Integer id);
}
