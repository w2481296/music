package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;
/**
 * 哪个工程中的类和接口。 
 * @author 名字
 * 开始时间：
 *
 */
public interface UserMapper {
	/**
	 *插入一个用户信息 
	 */
	void insert(User user);
	/**
	 * 根据用户名查询,把结果封装成user对象
	 * */
	User selectByUsername(String username);
	/**
	 * 验证手机
	 */
	Integer selectByPhone(String phone);
	/**
	 * 修改个人信息
	 */
	void updateUser(User user);
	/**
	 * 根据id查询用户
	 * */
	User selectUserById(Integer id);
	void updateImage(@Param("id")Integer id, String image);
}
