package cn.tedu.store.service;

import java.util.List;
import java.util.Map;

import cn.tedu.store.bean.User;

public interface IUserService {
	void addUser(User user);
	boolean checkPhone(String phone);
	boolean checkUsername(String name);
	boolean checkEmail(String email);
	User login(String username,String password, String cip, String cname);
	String queryoldPwd(String username);
	void updateuserNwd(String username, String newPwd);
	User getUserByEmail(String email);
	List<Map<String, Object>> selectMenu(Integer id);
	
}
