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
		// 1.���ó־ò�ķ���selectByUsername(user.getUsername());����user1����
		// 2.����û��������������insertUser(user)����,
		// ��Ϊ�գ����û����Ѵ��ڣ��׳��쳣UsernameAlreadyExistException
		User user1 = userMapper.selectByUsername(user.getUsername());
		if (user1 == null) {
			//��ȡҳ�������
			//String pwd=user.getPassword();
			//���ɵ���������
			//String md5pwd=DigestUtils.md5Hex(pwd+salt);
			//����������Ϊuser������
			//user.setPassword(pwd);
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
	
	// ʵ�ֵ�¼����
	public User login(String username, String password) {
		// 1.���ó־ò㷽��ByUsername;����user����
		// 2.�ж϶����Ƿ���ڣ��������׳��쳣
		// 3.�����ж�����
		User user = userMapper.selectByUsername(username);
		if (user == null) {
			throw new UserNotFoundException("�ʺŲ�����");
		} else {
			//��ȡ�����Ϊ����
			//String md5pwd=DigestUtils.md5Hex(password+salt);
			if (user.getPassword().equals(password)) {
				return user;
			} else {
				throw new PasswordNotMatchException("���벻ƥ��");
			}
		}

	}
	//ˢ��ҳ��
	public User getUserById(Integer id) {
		return userMapper.selectUserById(id);
	}

}