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
			String pwd=user.getPassword();
			//���ɵ���������
			String md5pwd=DigestUtils.md5Hex(pwd+salt);
			//����������Ϊuser������
			user.setPassword(md5pwd);
			userMapper.insert(user);
		} else {
			throw new UsernameAlreadyExistException("�û����Ѵ��ڣ�");
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
			String md5pwd=DigestUtils.md5Hex(password+salt);
			if (user.getPassword().equals(md5pwd)) {
				return user;
			} else {
				throw new PasswordNotMatchException("���벻ƥ��");
			}
		}

	}

	// ʵ���޸�����
	public void changePassword(Integer id, String oldPwd, String newPwd) {
		// ���ó־ò㷽��
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
				throw new PasswordNotMatchException("�����벻��ȷ");
			}
		} else {
			throw new UserNotFoundException("�û�������");
		}
	}

	public void updateUser(Integer id, String username, Integer gender, String email, String phone) {
		User user1 = userMapper.selectUserById(id);
		// 1.���ó־ò�ķ���selectById(ͨ��session��ȡ)������user1����
		// �ж��Ƿ����
		if (user1 != null) {
			// ���ó־ò�ķ���selectByUsername������use2����
			User user2 = userMapper.selectByUsername(username);
			//���use2��Ϊ�գ�˵�����ݿ��д��ڸ��û���
			//����û����͵�¼�û���������ͬ������ʵ���޸�
			if (user2 != null &&!user1.getUsername().equals(username)) {
				// �׳��쳣
				throw new UsernameAlreadyExistException("�û����Ѵ���");
			} else {
				User user = new User();
				// �������԰���
				user.setId(id);
				user.setUsername(username);
				user.setGender(gender);
				user.setEmail(email);
				user.setPhone(phone);
				// ���ó־ò�update(user);
				userMapper.updateUser(user);
			}
		} else {
			// �׳��쳣
			throw new UserNotFoundException("�û�û���ҵ�");
		}

	}
	//ˢ��ҳ��
	public User getUserById(Integer id) {
		return userMapper.selectUserById(id);
	}

	public void updImage(Integer id, String image) {
		userMapper.updateImage(id, image);
	}
}