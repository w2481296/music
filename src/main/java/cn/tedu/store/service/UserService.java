package cn.tedu.store.service;


import java.util.List;
import java.util.Map;

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
import cn.tedu.store.mapper.VipuserMapper;

@Service
public class UserService implements IUserService {

	@Resource
	private UserMapper userMapper;


	public void addUser(User user) {
		// 1.���ó־ò�ķ���selectByUsername(user.getUsername());����user1����
		// 2.����û��������������insertUser(user)����,
		// ��Ϊ�գ����û����Ѵ��ڣ��׳��쳣UsernameAlreadyExistException
		User user1 = userMapper.selectByUsername(user.getUsername());
		if (user1 == null) {
			userMapper.insert(user);
		} else {
			throw new UsernameAlreadyExistException("�û����Ѵ��ڣ�");
		}
	}


	public boolean checkPhone(String phone) {
		return userMapper.selectByPhone(phone) > 0;
	}

	public boolean checkUsername(String name) {
		return userMapper.selectByUsername(name) != null;
	}
	public boolean checkEmail(String email) {
		return userMapper.selectEmail(email) > 0;
	}
	// ʵ�ֵ�¼����
	public User login(String username, String password,String cip,String cname) {
		// 1.���ó־ò㷽��ByUsername;����user����
		// 2.�ж϶����Ƿ���ڣ��������׳��쳣
		// 3.�����ж�����
		User user = userMapper.selectByUsername(username);
		if (user == null) {
			throw new UserNotFoundException("�ʺŲ�����");
		} else {
			if (user.getPassword().equals(password)) {
				userMapper.addlogininfo(username,cip,cname);
				return user;
			} else {
				throw new PasswordNotMatchException("���벻ƥ��");
			}
		}

	}

	//��ѯ����������û���
	@Override
	public String queryoldPwd(String username) {
		return userMapper.queryoldPwd(username);
	}

	@Override
	public void updateuserNwd(String username, String newPwd) {
		userMapper.updateuserNwd(username,newPwd);
	}


	@Override
	public User getUserByEmail(String email) {
		return userMapper.queryuser(email);
	}


	@Override
	public List<Map<String, Object>> selectMenu(Integer id) {
		return userMapper.selectmenu(id);
	}


	

}