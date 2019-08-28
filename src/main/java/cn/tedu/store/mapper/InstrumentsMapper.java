package cn.tedu.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface InstrumentsMapper {

	//²éÑ¯ÀÖÆ÷ĞÅÏ¢
	List<Map<String, Object>> selinstruByName(@Param("insName")String insName);
}
