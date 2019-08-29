package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface InstrumentsMapper {

	//查询乐器信息
	List<Map<String, Object>> selinstruByName(@Param("insName")String insName);
	//删除乐器信息
	void delMainInsById(@Param("insid2")Integer insid2);
}
