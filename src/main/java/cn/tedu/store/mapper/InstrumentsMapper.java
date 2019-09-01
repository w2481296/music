package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.Instruments;

public interface InstrumentsMapper {

	//查询乐器信息
	List<Map<String, Object>> selinstruByName(@Param("insName")String insName,@Param("insTime1")String insTime1,@Param("insTime2")String insTime2);
	//删除乐器信息
	void delMainInsById(@Param("insid")Integer insid);
	//批量删除
	int deletesById(@Param("ids2")Integer[] ids2);
	//查询信息根据id
	List<Map<String, Object>> queryinstruById(@Param("ids2")Integer ids2);
	void updateinfo(Instruments instruments);
}
