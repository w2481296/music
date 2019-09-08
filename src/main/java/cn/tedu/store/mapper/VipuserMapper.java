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


}
