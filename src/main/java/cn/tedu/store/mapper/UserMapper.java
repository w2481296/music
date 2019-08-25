package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;
/**
 * �ĸ������е���ͽӿڡ� 
 * @author ����
 * ��ʼʱ�䣺
 *
 */
public interface UserMapper {
	/**
	 *����һ���û���Ϣ 
	 */
	void insert(User user);
	/**
	 * �����û�����ѯ,�ѽ����װ��user����
	 * */
	User selectByUsername(String username);
	/**
	 * ��֤�ֻ�
	 */
	Integer selectByPhone(String phone);
	/**
	 * �޸ĸ�����Ϣ
	 */
	void updateUser(User user);
	/**
	 * ����id��ѯ�û�
	 * */
	User selectUserById(Integer id);
	void updateImage(@Param("id")Integer id, String image);
}
