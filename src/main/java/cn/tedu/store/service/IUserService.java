package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	void addUser(User user);
	boolean checkPhone(String phone);
	boolean checkUsername(String name);
	User login(String username,String password);
	void changePassword(Integer id,String oldPwd,String newPwd);
	void updateUser(Integer id,String username,String phone);
	User getUserById(Integer id);
}
