package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Instruments;
import cn.tedu.store.bean.User;
import cn.tedu.store.bean.vipuser;
/**
 * 哪个工程中的类和接口。 
 * @author 名字
 * 开始时间：
 *
 */
public interface VipuserMapper {

	List<Map<String, Object>> selectVipInfo(@Param("vipName")String vipName, @Param("vipTime1")String vipTime1, @Param("vipTime2")String vipTime2);

	void delMainInsById(@Param("vipid2")Integer vipid2);

	void delvipsByIds(@Param("ids2")Integer[] ids2);

	void addvipinfo(vipuser vipuser);

	List<Map<String, Object>> queryvipById(Integer ids2);

	void updatevipinfo(vipuser vipuser);
	//查询登陆日志
	List<Map<String, Object>> querylogin(@Param("vipName")String vipName, @Param("vipTime1")String vipTime1, @Param("vipTime2")String vipTime2);

	
	List<Map<String, Object>> selectUserInfo(@Param("vipName")String vipName, @Param("vipTime1")String vipTime1, @Param("vipTime2")String vipTime2);

	void delMainUserById(@Param("vipid2")Integer vipid2);

	void delUsersByIds(@Param("ids2")Integer[] ids2);

	void addUserinfo(User user);

	List<Map<String, Object>> queryuserById(@Param("ids2")Integer ids2);

	void updateroleinfo(@Param("role")Integer role, @Param("id")Integer id);

	void updateuserinfo(User user);

	Integer queryuserByname(@Param("username")String username);

	void delroleUserById(@Param("vipid2")Integer vipid2);

	void delroleUsersByIds(@Param("ids2")Integer[] ids2);

	List<Map<String, Object>> selectrole();

	void delroleById(@Param("vipid2")Integer vipid2);
	void delroleById2(@Param("vipid2")Integer vipid2);

	List<Map<String, Object>> selectMenu();

	void addrole(@Param("rolename")String rolename, @Param("remake")String remake);

	void addrolemenu(@Param("id")int id, @Param("valu")int valu);

	int qryroleid(@Param("rolename")String rolename);

	List<Map<String, Object>> selectmenubyid(@Param("id")int id);
	
	Map<String, Object> selectrolebyid(@Param("id")int id);

	void delrolemenuById(@Param("id")Integer id);

	void updaterole(@Param("rolename")String rolename, @Param("remake")String remake);

	void insertroleinfo(@Param("role")Integer role, @Param("id")Integer id);
	

}
