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
	void changePassword(@Param("username")String username,@Param("newPwd")String  newPwd);
	/**
	 * ����id��ѯ�û�
	 * */
	User selectUserById(Integer id);
	String queryoldPwd(@Param("username")String username);
	void updateuserNwd(@Param("username")String username, @Param("newPwd")String newPwd);
	//��ӵ�½��־
	void addlogininfo(@Param("username")String username, @Param("cip")String cip,@Param("cname") String cname);

}
