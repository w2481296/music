package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	void addUser(User user);
	boolean checkPhone(String phone);
	boolean checkUsername(String name);
	User login(String username,String password, String cip, String cname);
	String queryoldPwd(String username);
	void updateuserNwd(String username, String newPwd);
	User getUserByEmail(String email);
}
